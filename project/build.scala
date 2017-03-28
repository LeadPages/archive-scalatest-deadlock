import org.fusesource.scalate.{TemplateEngine, TemplateSource}
import sbt._
import sbt.Keys._
import sbt.IO

object Setup {
  lazy val setupTask = TaskKey[Unit]("setup", "setup")

  val mainCode = """
  |package scalatest.deadlock
  |
  |class Behavior{{i}} {
  |  def doSomething(str: String): String = ???
  |}
  """.stripMargin

  val testCode = """
    |package scalatest.deadlock
    |
    |import org.mockito.ArgumentMatchers._
    |import org.mockito.Mockito._
    |import org.scalatest.{AsyncFlatSpec, Matchers}
    |import org.scalatest.mockito.MockitoSugar
    |
    |import scala.concurrent.Future
    |
    |class Test{{i}} extends AsyncFlatSpec with Matchers with MockitoSugar {
    |  "Test{{i}}" should "do stuff" in {
    |    val m = mock[Behavior{{i}}]
    |    when(m.doSomething(any[String])).thenReturn("foo")
    |    Future {
    |      m.doSomething("x") should equal("foo")
    |    }
    |  }
    |}
  """.stripMargin

  lazy val settings = Seq(
    setupTask := {
      val engine = new TemplateEngine
      val sourceDir = (scalaSource in Compile).value / "scalatest" / "deadlock"
      val testSourceDir = (scalaSource in Test).value / "scalatest" / "deadlock"
      IO.createDirectories(Seq(sourceDir, testSourceDir))
      1 to 10 foreach { i =>
        val settings = Map("i" -> i)
        Seq((sourceDir, "Behavior", mainCode), (testSourceDir, "Test", testCode)) foreach { case (dir, name, code) =>
          val fileName = s"$name$i.scala.mustache"
          val sourceTemplate = TemplateSource.fromText(fileName, code)
          val result = engine.layout(sourceTemplate, settings)
          val outFile = dir / IO.split(fileName)._1
          IO.write(outFile, result)
        }
      }
    }
  )
}
