SBT deadlock demo:

```
% sbt setup test
[info] Loading project definition from /Users/aleckoss/work/scalatest-deadlock/project
[info] Set current project to scalatest-deadlock (in build file:/Users/aleckoss/work/scalatest-deadlock/)
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
[success] Total time: 2 s, completed Mar 28, 2017 2:41:48 PM
[info] Test2:
[info] Test2
[info] - should do stuff
[info] Test4:
[info] Test4
[info] - should do stuff
[info] Test10:
[info] Test10
[info] - should do stuff
[info] Test8:
[info] Test8
[info] - should do stuff
[info] Test6:
[info] Test6
[info] - should do stuff
[info] Test7:
[info] Test7
[info] - should do stuff
[info] Test1:
[info] Test1
[info] - should do stuff
[info] Test5:
[info] Test5
[info] - should do stuff
^C%                                                                                                                                                 %
```

Here's a more complete example:
```
% sbt -Dsbt.log.noformat=true 'set scalaVersion := "2.11.9"' setup scalaVersion test >> README.md
[info] Loading project definition from /Users/aleckoss/work/scalatest-deadlock/project
[info] Set current project to scalatest-deadlock (in build file:/Users/aleckoss/work/scalatest-deadlock/)
[info] Defining *:scalaVersion
[info] The new value will be used by *:allDependencies, *:crossScalaVersions and 12 others.
[info] 	Run `last` for details.
[info] Reapplying settings...
[info] Set current project to scalatest-deadlock (in build file:/Users/aleckoss/work/scalatest-deadlock/)
[success] Total time: 1 s, completed Mar 28, 2017 2:46:52 PM
[info] 2.11.9
[info] Updating {file:/Users/aleckoss/work/scalatest-deadlock/}scalatest-deadlock...
[info] Resolving org.scala-lang#scala-library;2.11.9 ...
[info] Resolving org.scalatest#scalatest_2.11;3.0.1 ...
[info] Resolving org.scalactic#scalactic_2.11;3.0.1 ...
[info] Resolving org.scala-lang#scala-reflect;2.11.9 ...
[info] Resolving org.scala-lang.modules#scala-xml_2.11;1.0.5 ...
[info] Resolving org.scala-lang.modules#scala-parser-combinators_2.11;1.0.4 ...
[info] Resolving org.mockito#mockito-core;2.7.17 ...
[info] Resolving net.bytebuddy#byte-buddy;1.6.11 ...
[info] Resolving net.bytebuddy#byte-buddy-agent;1.6.11 ...
[info] Resolving org.objenesis#objenesis;2.5 ...
[info] Resolving org.scala-lang#scala-compiler;2.11.9 ...
[info] Resolving jline#jline;2.14.3 ...
[info] Done updating.
[info] Test1:
[info] Test1
[info] - should do stuff
[info] Test6:
[info] Test6
[info] - should do stuff
[info] Test9:
[info] Test9
[info] - should do stuff
[info] Test5:
[info] Test5
[info] - should do stuff
[info] Test8:
[info] Test8
[info] - should do stuff
[info] Test2:
[info] Test2
[info] - should do stuff
[info] Test4:
[info] Test4
[info] - should do stuff
[info] Test7:
[info] Test7
[info] - should do stuff
2017-03-28 14:46:58
Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.121-b13 mixed mode):

"Timer-9" #68 prio=5 os_prio=31 tid=0x00007fd2f4d19800 nid=0x7f03 in Object.wait() [0x0000700008ca4000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x00000007ad626ca0> (a java.util.TaskQueue)
	at java.lang.Object.wait(Object.java:502)
	at java.util.TimerThread.mainLoop(Timer.java:526)
	- locked <0x00000007ad626ca0> (a java.util.TaskQueue)
	at java.util.TimerThread.run(Timer.java:505)

"Timer-10" #67 prio=5 os_prio=31 tid=0x00007fd2f597d000 nid=0x7d03 in Object.wait() [0x0000700008ba1000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x00000007ad265350> (a java.util.TaskQueue)
	at java.lang.Object.wait(Object.java:502)
	at java.util.TimerThread.mainLoop(Timer.java:526)
	- locked <0x00000007ad265350> (a java.util.TaskQueue)
	at java.util.TimerThread.run(Timer.java:505)

"pool-6-thread-10-ScalaTest-running-Test3" #66 prio=5 os_prio=31 tid=0x00007fd2f183e000 nid=0x7b03 waiting for monitor entry [0x0000700008a9a000]
   java.lang.Thread.State: BLOCKED (on object monitor)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:404)
	- waiting to lock <0x0000000782850cd0> (a sbt.classpath.ClasspathFilter)
	at sbt.classpath.ClasspathFilter.loadClass(ClassLoaders.scala:59)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at net.bytebuddy.dynamic.loading.MultipleParentClassLoader.loadClass(MultipleParentClassLoader.java:68)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at java.lang.ClassLoader.defineClass1(Native Method)
	at java.lang.ClassLoader.defineClass(ClassLoader.java:763)
	at sun.reflect.GeneratedMethodAccessor20.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$Direct.defineClass(ClassInjector.java:408)
	at net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection.inject(ClassInjector.java:185)
	- locked <0x00000007ada66968> (a net.bytebuddy.dynamic.loading.MultipleParentClassLoader)
	at net.bytebuddy.dynamic.loading.ClassLoadingStrategy$Default$InjectionDispatcher.load(ClassLoadingStrategy.java:187)
	at net.bytebuddy.dynamic.TypeResolutionStrategy$Passive.initialize(TypeResolutionStrategy.java:79)
	at net.bytebuddy.dynamic.DynamicType$Default$Unloaded.load(DynamicType.java:4376)
	at org.mockito.internal.creation.bytebuddy.SubclassBytecodeGenerator.mockClass(SubclassBytecodeGenerator.java:94)
	at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator$1.call(TypeCachingBytecodeGenerator.java:37)
	at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator$1.call(TypeCachingBytecodeGenerator.java:34)
	at net.bytebuddy.TypeCache.findOrInsert(TypeCache.java:138)
	at net.bytebuddy.TypeCache$WithInlineExpunction.findOrInsert(TypeCache.java:346)
	at net.bytebuddy.TypeCache.findOrInsert(TypeCache.java:161)
	- locked <0x0000000782850d28> (a sbt.classpath.ClasspathUtilities$$anon$1)
	at net.bytebuddy.TypeCache$WithInlineExpunction.findOrInsert(TypeCache.java:355)
	at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator.mockClass(TypeCachingBytecodeGenerator.java:32)
	at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMockType(SubclassByteBuddyMockMaker.java:71)
	at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMock(SubclassByteBuddyMockMaker.java:42)
	at org.mockito.internal.creation.bytebuddy.ByteBuddyMockMaker.createMock(ByteBuddyMockMaker.java:26)
	at org.mockito.internal.util.MockUtil.createMock(MockUtil.java:35)
	at org.mockito.internal.MockitoCore.mock(MockitoCore.java:65)
	at org.mockito.Mockito.mock(Mockito.java:1729)
	at org.mockito.Mockito.mock(Mockito.java:1642)
	at org.scalatest.mockito.MockitoSugar$class.mock(MockitoSugar.scala:73)
	at scalatest.deadlock.Test3.mock(Test3.scala:11)
	at scalatest.deadlock.Test3$$anonfun$1.apply(Test3.scala:13)
	at scalatest.deadlock.Test3$$anonfun$1.apply(Test3.scala:12)
	at org.scalatest.AsyncFlatSpecLike$class.transformToOutcomeParam$1(AsyncFlatSpecLike.scala:139)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$org$scalatest$AsyncFlatSpecLike$$registerTestToRun$2.apply(AsyncFlatSpecLike.scala:145)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$org$scalatest$AsyncFlatSpecLike$$registerTestToRun$2.apply(AsyncFlatSpecLike.scala:145)
	at org.scalatest.AsyncTestSuite$$anonfun$transformToOutcome$1.apply(AsyncTestSuite.scala:240)
	at org.scalatest.AsyncTestSuite$$anonfun$transformToOutcome$1.apply(AsyncTestSuite.scala:239)
	at org.scalatest.AsyncFlatSpecLike$$anon$1.apply(AsyncFlatSpecLike.scala:1698)
	at org.scalatest.AsyncTestSuite$class.withFixture(AsyncTestSuite.scala:313)
	at org.scalatest.AsyncFlatSpec.withFixture(AsyncFlatSpec.scala:2219)
	at org.scalatest.AsyncFlatSpecLike$class.invokeWithAsyncFixture$1(AsyncFlatSpecLike.scala:1695)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$runTest$1.apply(AsyncFlatSpecLike.scala:1709)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$runTest$1.apply(AsyncFlatSpecLike.scala:1709)
	at org.scalatest.AsyncSuperEngine.runTestImpl(AsyncEngine.scala:292)
	at org.scalatest.AsyncFlatSpecLike$class.runTest(AsyncFlatSpecLike.scala:1709)
	at org.scalatest.AsyncFlatSpec.runTest(AsyncFlatSpec.scala:2219)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$runTests$1.apply(AsyncFlatSpecLike.scala:1767)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$runTests$1.apply(AsyncFlatSpecLike.scala:1767)
	at org.scalatest.AsyncSuperEngine$$anonfun$traverseSubNodes$1$1.apply(AsyncEngine.scala:434)
	at org.scalatest.AsyncSuperEngine$$anonfun$traverseSubNodes$1$1.apply(AsyncEngine.scala:419)
	at scala.collection.LinearSeqOptimized$class.foldLeft(LinearSeqOptimized.scala:124)
	at scala.collection.immutable.List.foldLeft(List.scala:84)
	at org.scalatest.AsyncSuperEngine.traverseSubNodes$1(AsyncEngine.scala:419)
	at org.scalatest.AsyncSuperEngine.org$scalatest$AsyncSuperEngine$$runTestsInBranch(AsyncEngine.scala:475)
	at org.scalatest.AsyncSuperEngine$$anonfun$traverseSubNodes$1$1.apply(AsyncEngine.scala:460)
	at org.scalatest.AsyncSuperEngine$$anonfun$traverseSubNodes$1$1.apply(AsyncEngine.scala:419)
	at scala.collection.LinearSeqOptimized$class.foldLeft(LinearSeqOptimized.scala:124)
	at scala.collection.immutable.List.foldLeft(List.scala:84)
	at org.scalatest.AsyncSuperEngine.traverseSubNodes$1(AsyncEngine.scala:419)
	at org.scalatest.AsyncSuperEngine.org$scalatest$AsyncSuperEngine$$runTestsInBranch(AsyncEngine.scala:483)
	at org.scalatest.AsyncSuperEngine.runTestsImpl(AsyncEngine.scala:550)
	at org.scalatest.AsyncFlatSpecLike$class.runTests(AsyncFlatSpecLike.scala:1767)
	at org.scalatest.AsyncFlatSpec.runTests(AsyncFlatSpec.scala:2219)
	at org.scalatest.Suite$class.run(Suite.scala:1147)
	at org.scalatest.AsyncFlatSpec.org$scalatest$AsyncFlatSpecLike$$super$run(AsyncFlatSpec.scala:2219)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$run$1.apply(AsyncFlatSpecLike.scala:1812)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$run$1.apply(AsyncFlatSpecLike.scala:1812)
	at org.scalatest.AsyncSuperEngine.runImpl(AsyncEngine.scala:620)
	at org.scalatest.AsyncFlatSpecLike$class.run(AsyncFlatSpecLike.scala:1812)
	at org.scalatest.AsyncFlatSpec.run(AsyncFlatSpec.scala:2219)
	at org.scalatest.tools.Framework.org$scalatest$tools$Framework$$runSuite(Framework.scala:314)
	at org.scalatest.tools.Framework$ScalaTestTask.execute(Framework.scala:480)
	at sbt.TestRunner.runTest$1(TestFramework.scala:76)
	at sbt.TestRunner.run(TestFramework.scala:85)
	at sbt.TestFramework$$anon$2$$anonfun$$init$$1$$anonfun$apply$8.apply(TestFramework.scala:202)
	at sbt.TestFramework$$anon$2$$anonfun$$init$$1$$anonfun$apply$8.apply(TestFramework.scala:202)
	at sbt.TestFramework$.sbt$TestFramework$$withContextLoader(TestFramework.scala:185)
	at sbt.TestFramework$$anon$2$$anonfun$$init$$1.apply(TestFramework.scala:202)
	at sbt.TestFramework$$anon$2$$anonfun$$init$$1.apply(TestFramework.scala:202)
	at sbt.TestFunction.apply(TestFramework.scala:207)
	at sbt.Tests$$anonfun$9.apply(Tests.scala:216)
	at sbt.Tests$$anonfun$9.apply(Tests.scala:216)
	at sbt.std.Transform$$anon$3$$anonfun$apply$2.apply(System.scala:44)
	at sbt.std.Transform$$anon$3$$anonfun$apply$2.apply(System.scala:44)
	at sbt.std.Transform$$anon$4.work(System.scala:63)
	at sbt.Execute$$anonfun$submit$1$$anonfun$apply$1.apply(Execute.scala:228)
	at sbt.Execute$$anonfun$submit$1$$anonfun$apply$1.apply(Execute.scala:228)
	at sbt.ErrorHandling$.wideConvert(ErrorHandling.scala:17)
	at sbt.Execute.work(Execute.scala:237)
	at sbt.Execute$$anonfun$submit$1.apply(Execute.scala:228)
	at sbt.Execute$$anonfun$submit$1.apply(Execute.scala:228)
	at sbt.ConcurrentRestrictions$$anon$4$$anonfun$1.apply(ConcurrentRestrictions.scala:159)
	at sbt.CompletionService$$anon$2.call(CompletionService.scala:28)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

"Timer-5" #65 prio=5 os_prio=31 tid=0x00007fd2f12d8000 nid=0x7903 in Object.wait() [0x000070000899b000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x0000000784ccf448> (a java.util.TaskQueue)
	at java.lang.Object.wait(Object.java:502)
	at java.util.TimerThread.mainLoop(Timer.java:526)
	- locked <0x0000000784ccf448> (a java.util.TaskQueue)
	at java.util.TimerThread.run(Timer.java:505)

"Timer-6" #59 prio=5 os_prio=31 tid=0x00007fd2f4b68800 nid=0x7703 in Object.wait() [0x0000700008898000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x0000000783b4a7d8> (a java.util.TaskQueue)
	at java.lang.Object.wait(Object.java:502)
	at java.util.TimerThread.mainLoop(Timer.java:526)
	- locked <0x0000000783b4a7d8> (a java.util.TaskQueue)
	at java.util.TimerThread.run(Timer.java:505)

"Timer-4" #60 prio=5 os_prio=31 tid=0x00007fd2f59f3000 nid=0x7503 in Object.wait() [0x0000700008795000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x0000000783afdf30> (a java.util.TaskQueue)
	at java.lang.Object.wait(Object.java:502)
	at java.util.TimerThread.mainLoop(Timer.java:526)
	- locked <0x0000000783afdf30> (a java.util.TaskQueue)
	at java.util.TimerThread.run(Timer.java:505)

"Timer-2" #61 prio=5 os_prio=31 tid=0x00007fd2f23fe800 nid=0x7303 in Object.wait() [0x0000700008692000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x0000000782a6b7a0> (a java.util.TaskQueue)
	at java.lang.Object.wait(Object.java:502)
	at java.util.TimerThread.mainLoop(Timer.java:526)
	- locked <0x0000000782a6b7a0> (a java.util.TaskQueue)
	at java.util.TimerThread.run(Timer.java:505)

"Timer-8" #63 prio=5 os_prio=31 tid=0x00007fd2f68c2800 nid=0x7103 in Object.wait() [0x000070000858f000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x0000000784cc61a0> (a java.util.TaskQueue)
	at java.lang.Object.wait(Object.java:502)
	at java.util.TimerThread.mainLoop(Timer.java:526)
	- locked <0x0000000784cc61a0> (a java.util.TaskQueue)
	at java.util.TimerThread.run(Timer.java:505)

"Timer-1" #62 prio=5 os_prio=31 tid=0x00007fd2ef6bc800 nid=0x6f03 in Object.wait() [0x000070000848c000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x0000000784ce4718> (a java.util.TaskQueue)
	at java.lang.Object.wait(Object.java:502)
	at java.util.TimerThread.mainLoop(Timer.java:526)
	- locked <0x0000000784ce4718> (a java.util.TaskQueue)
	at java.util.TimerThread.run(Timer.java:505)

"Timer-7" #64 prio=5 os_prio=31 tid=0x00007fd2f68af800 nid=0x6d03 in Object.wait() [0x0000700008389000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x0000000784cc6b40> (a java.util.TaskQueue)
	at java.lang.Object.wait(Object.java:502)
	at java.util.TimerThread.mainLoop(Timer.java:526)
	- locked <0x0000000784cc6b40> (a java.util.TaskQueue)
	at java.util.TimerThread.run(Timer.java:505)

"Timer-3" #58 prio=5 os_prio=31 tid=0x00007fd2f432d800 nid=0x6b03 in Object.wait() [0x0000700008286000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x0000000783b4b268> (a java.util.TaskQueue)
	at java.lang.Object.wait(Object.java:502)
	at java.util.TimerThread.mainLoop(Timer.java:526)
	- locked <0x0000000783b4b268> (a java.util.TaskQueue)
	at java.util.TimerThread.run(Timer.java:505)

"Timer-0" #57 prio=5 os_prio=31 tid=0x00007fd2ef6c0000 nid=0x640b in Object.wait() [0x0000700008183000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x0000000783afd4e8> (a java.util.TaskQueue)
	at java.util.TimerThread.mainLoop(Timer.java:552)
	- locked <0x0000000783afd4e8> (a java.util.TaskQueue)
	at java.util.TimerThread.run(Timer.java:505)

"ScalaTest-dispatcher" #56 prio=5 os_prio=31 tid=0x00007fd2eff15800 nid=0x5f13 waiting on condition [0x0000700008080000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x0000000782a6c078> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at org.scalatest.LinkedBlockingQueue.take(JavaClassesWrappers.scala:43)
	at org.scalatest.DispatchReporter$Propagator.run(DispatchReporter.scala:166)
	at java.lang.Thread.run(Thread.java:745)

"pool-6-thread-9" #55 prio=5 os_prio=31 tid=0x00007fd2f08fb000 nid=0x5a13 waiting on condition [0x0000700007f7d000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x0000000783b4bb10> (a java.util.concurrent.SynchronousQueue$TransferStack)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

"pool-6-thread-8" #54 prio=5 os_prio=31 tid=0x00007fd2f1190000 nid=0x6a0f waiting on condition [0x0000700007e7a000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x0000000783b4bb10> (a java.util.concurrent.SynchronousQueue$TransferStack)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

"pool-6-thread-7" #53 prio=5 os_prio=31 tid=0x00007fd2f118f800 nid=0x6717 waiting on condition [0x0000700007d77000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x0000000783b4bb10> (a java.util.concurrent.SynchronousQueue$TransferStack)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

"pool-6-thread-6" #52 prio=5 os_prio=31 tid=0x00007fd2f11ce800 nid=0x5c13 waiting on condition [0x0000700007c74000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x0000000783b4bb10> (a java.util.concurrent.SynchronousQueue$TransferStack)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

"pool-6-thread-5" #51 prio=5 os_prio=31 tid=0x00007fd2f08fa800 nid=0x690f waiting on condition [0x0000700007b71000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x0000000783b4bb10> (a java.util.concurrent.SynchronousQueue$TransferStack)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

"pool-6-thread-4" #50 prio=5 os_prio=31 tid=0x00007fd2f08f9800 nid=0x6813 waiting on condition [0x0000700007a6e000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x0000000783b4bb10> (a java.util.concurrent.SynchronousQueue$TransferStack)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

"pool-6-thread-3" #49 prio=5 os_prio=31 tid=0x00007fd2f3fdd000 nid=0x1007 waiting on condition [0x000070000796b000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x0000000783b4bb10> (a java.util.concurrent.SynchronousQueue$TransferStack)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

"pool-6-thread-2" #48 prio=5 os_prio=31 tid=0x00007fd2f3fdc000 nid=0x1407 waiting on condition [0x0000700007868000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x0000000783b4bb10> (a java.util.concurrent.SynchronousQueue$TransferStack)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

"pool-6-thread-1-ScalaTest-running-Test10" #47 prio=5 os_prio=31 tid=0x00007fd2f51c4000 nid=0x5917 waiting for monitor entry [0x0000700007760000]
   java.lang.Thread.State: BLOCKED (on object monitor)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:404)
	- waiting to lock <0x0000000782850d28> (a sbt.classpath.ClasspathUtilities$$anon$1)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:411)
	- locked <0x0000000782850cd0> (a sbt.classpath.ClasspathFilter)
	at sbt.classpath.ClasspathFilter.loadClass(ClassLoaders.scala:59)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at net.bytebuddy.dynamic.loading.MultipleParentClassLoader.loadClass(MultipleParentClassLoader.java:68)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at sun.misc.Unsafe.defineClass(Native Method)
	at sun.reflect.ClassDefiner.defineClass(ClassDefiner.java:63)
	at sun.reflect.MethodAccessorGenerator$1.run(MethodAccessorGenerator.java:399)
	at sun.reflect.MethodAccessorGenerator$1.run(MethodAccessorGenerator.java:394)
	at java.security.AccessController.doPrivileged(Native Method)
	at sun.reflect.MethodAccessorGenerator.generate(MethodAccessorGenerator.java:393)
	at sun.reflect.MethodAccessorGenerator.generateSerializationConstructor(MethodAccessorGenerator.java:112)
	at sun.reflect.ReflectionFactory.generateConstructor(ReflectionFactory.java:398)
	at sun.reflect.ReflectionFactory.newConstructorForSerialization(ReflectionFactory.java:360)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.objenesis.instantiator.sun.SunReflectionFactoryHelper.newConstructorForSerialization(SunReflectionFactoryHelper.java:44)
	at org.objenesis.instantiator.sun.SunReflectionFactoryInstantiator.<init>(SunReflectionFactoryInstantiator.java:41)
	at org.objenesis.strategy.StdInstantiatorStrategy.newInstantiatorOf(StdInstantiatorStrategy.java:67)
	at org.objenesis.ObjenesisBase.getInstantiatorOf(ObjenesisBase.java:94)
	at org.objenesis.ObjenesisBase.newInstance(ObjenesisBase.java:73)
	at org.mockito.internal.creation.instance.ObjenesisInstantiator.newInstance(ObjenesisInstantiator.java:18)
	at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMock(SubclassByteBuddyMockMaker.java:47)
	at org.mockito.internal.creation.bytebuddy.ByteBuddyMockMaker.createMock(ByteBuddyMockMaker.java:26)
	at org.mockito.internal.util.MockUtil.createMock(MockUtil.java:35)
	at org.mockito.internal.MockitoCore.mock(MockitoCore.java:65)
	at org.mockito.Mockito.mock(Mockito.java:1729)
	at org.mockito.Mockito.mock(Mockito.java:1642)
	at org.scalatest.mockito.MockitoSugar$class.mock(MockitoSugar.scala:73)
	at scalatest.deadlock.Test10.mock(Test10.scala:11)
	at scalatest.deadlock.Test10$$anonfun$1.apply(Test10.scala:13)
	at scalatest.deadlock.Test10$$anonfun$1.apply(Test10.scala:12)
	at org.scalatest.AsyncFlatSpecLike$class.transformToOutcomeParam$1(AsyncFlatSpecLike.scala:139)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$org$scalatest$AsyncFlatSpecLike$$registerTestToRun$2.apply(AsyncFlatSpecLike.scala:145)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$org$scalatest$AsyncFlatSpecLike$$registerTestToRun$2.apply(AsyncFlatSpecLike.scala:145)
	at org.scalatest.AsyncTestSuite$$anonfun$transformToOutcome$1.apply(AsyncTestSuite.scala:240)
	at org.scalatest.AsyncTestSuite$$anonfun$transformToOutcome$1.apply(AsyncTestSuite.scala:239)
	at org.scalatest.AsyncFlatSpecLike$$anon$1.apply(AsyncFlatSpecLike.scala:1698)
	at org.scalatest.AsyncTestSuite$class.withFixture(AsyncTestSuite.scala:313)
	at org.scalatest.AsyncFlatSpec.withFixture(AsyncFlatSpec.scala:2219)
	at org.scalatest.AsyncFlatSpecLike$class.invokeWithAsyncFixture$1(AsyncFlatSpecLike.scala:1695)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$runTest$1.apply(AsyncFlatSpecLike.scala:1709)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$runTest$1.apply(AsyncFlatSpecLike.scala:1709)
	at org.scalatest.AsyncSuperEngine.runTestImpl(AsyncEngine.scala:292)
	at org.scalatest.AsyncFlatSpecLike$class.runTest(AsyncFlatSpecLike.scala:1709)
	at org.scalatest.AsyncFlatSpec.runTest(AsyncFlatSpec.scala:2219)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$runTests$1.apply(AsyncFlatSpecLike.scala:1767)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$runTests$1.apply(AsyncFlatSpecLike.scala:1767)
	at org.scalatest.AsyncSuperEngine$$anonfun$traverseSubNodes$1$1.apply(AsyncEngine.scala:434)
	at org.scalatest.AsyncSuperEngine$$anonfun$traverseSubNodes$1$1.apply(AsyncEngine.scala:419)
	at scala.collection.LinearSeqOptimized$class.foldLeft(LinearSeqOptimized.scala:124)
	at scala.collection.immutable.List.foldLeft(List.scala:84)
	at org.scalatest.AsyncSuperEngine.traverseSubNodes$1(AsyncEngine.scala:419)
	at org.scalatest.AsyncSuperEngine.org$scalatest$AsyncSuperEngine$$runTestsInBranch(AsyncEngine.scala:475)
	at org.scalatest.AsyncSuperEngine$$anonfun$traverseSubNodes$1$1.apply(AsyncEngine.scala:460)
	at org.scalatest.AsyncSuperEngine$$anonfun$traverseSubNodes$1$1.apply(AsyncEngine.scala:419)
	at scala.collection.LinearSeqOptimized$class.foldLeft(LinearSeqOptimized.scala:124)
	at scala.collection.immutable.List.foldLeft(List.scala:84)
	at org.scalatest.AsyncSuperEngine.traverseSubNodes$1(AsyncEngine.scala:419)
	at org.scalatest.AsyncSuperEngine.org$scalatest$AsyncSuperEngine$$runTestsInBranch(AsyncEngine.scala:483)
	at org.scalatest.AsyncSuperEngine.runTestsImpl(AsyncEngine.scala:550)
	at org.scalatest.AsyncFlatSpecLike$class.runTests(AsyncFlatSpecLike.scala:1767)
	at org.scalatest.AsyncFlatSpec.runTests(AsyncFlatSpec.scala:2219)
	at org.scalatest.Suite$class.run(Suite.scala:1147)
	at org.scalatest.AsyncFlatSpec.org$scalatest$AsyncFlatSpecLike$$super$run(AsyncFlatSpec.scala:2219)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$run$1.apply(AsyncFlatSpecLike.scala:1812)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$run$1.apply(AsyncFlatSpecLike.scala:1812)
	at org.scalatest.AsyncSuperEngine.runImpl(AsyncEngine.scala:620)
	at org.scalatest.AsyncFlatSpecLike$class.run(AsyncFlatSpecLike.scala:1812)
	at org.scalatest.AsyncFlatSpec.run(AsyncFlatSpec.scala:2219)
	at org.scalatest.tools.Framework.org$scalatest$tools$Framework$$runSuite(Framework.scala:314)
	at org.scalatest.tools.Framework$ScalaTestTask.execute(Framework.scala:480)
	at sbt.TestRunner.runTest$1(TestFramework.scala:76)
	at sbt.TestRunner.run(TestFramework.scala:85)
	at sbt.TestFramework$$anon$2$$anonfun$$init$$1$$anonfun$apply$8.apply(TestFramework.scala:202)
	at sbt.TestFramework$$anon$2$$anonfun$$init$$1$$anonfun$apply$8.apply(TestFramework.scala:202)
	at sbt.TestFramework$.sbt$TestFramework$$withContextLoader(TestFramework.scala:185)
	at sbt.TestFramework$$anon$2$$anonfun$$init$$1.apply(TestFramework.scala:202)
	at sbt.TestFramework$$anon$2$$anonfun$$init$$1.apply(TestFramework.scala:202)
	at sbt.TestFunction.apply(TestFramework.scala:207)
	at sbt.Tests$$anonfun$9.apply(Tests.scala:216)
	at sbt.Tests$$anonfun$9.apply(Tests.scala:216)
	at sbt.std.Transform$$anon$3$$anonfun$apply$2.apply(System.scala:44)
	at sbt.std.Transform$$anon$3$$anonfun$apply$2.apply(System.scala:44)
	at sbt.std.Transform$$anon$4.work(System.scala:63)
	at sbt.Execute$$anonfun$submit$1$$anonfun$apply$1.apply(Execute.scala:228)
	at sbt.Execute$$anonfun$submit$1$$anonfun$apply$1.apply(Execute.scala:228)
	at sbt.ErrorHandling$.wideConvert(ErrorHandling.scala:17)
	at sbt.Execute.work(Execute.scala:237)
	at sbt.Execute$$anonfun$submit$1.apply(Execute.scala:228)
	at sbt.Execute$$anonfun$submit$1.apply(Execute.scala:228)
	at sbt.ConcurrentRestrictions$$anon$4$$anonfun$1.apply(ConcurrentRestrictions.scala:159)
	at sbt.CompletionService$$anon$2.call(CompletionService.scala:28)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

"process reaper" #10 daemon prio=10 os_prio=31 tid=0x00007fd2efab9000 nid=0x5703 waiting on condition [0x0000700007662000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x0000000780003040> (a java.util.concurrent.SynchronousQueue$TransferStack)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

"Service Thread" #9 daemon prio=9 os_prio=31 tid=0x00007fd2ee84b800 nid=0x5303 runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C1 CompilerThread3" #8 daemon prio=9 os_prio=31 tid=0x00007fd2ee801000 nid=0x5103 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C2 CompilerThread2" #7 daemon prio=9 os_prio=31 tid=0x00007fd2ef062800 nid=0x4f03 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C2 CompilerThread1" #6 daemon prio=9 os_prio=31 tid=0x00007fd2ef04b000 nid=0x4d03 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C2 CompilerThread0" #5 daemon prio=9 os_prio=31 tid=0x00007fd2ef806800 nid=0x4b03 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Signal Dispatcher" #4 daemon prio=9 os_prio=31 tid=0x00007fd2ee026800 nid=0x4903 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Finalizer" #3 daemon prio=8 os_prio=31 tid=0x00007fd2ee838800 nid=0x3903 in Object.wait() [0x0000700006f22000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x000000078000e898> (a java.lang.ref.ReferenceQueue$Lock)
	at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:143)
	- locked <0x000000078000e898> (a java.lang.ref.ReferenceQueue$Lock)
	at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:164)
	at java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:209)

"Reference Handler" #2 daemon prio=10 os_prio=31 tid=0x00007fd2ee835800 nid=0x3703 in Object.wait() [0x0000700006e1f000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x0000000780009438> (a java.lang.ref.Reference$Lock)
	at java.lang.Object.wait(Object.java:502)
	at java.lang.ref.Reference.tryHandlePending(Reference.java:191)
	- locked <0x0000000780009438> (a java.lang.ref.Reference$Lock)
	at java.lang.ref.Reference$ReferenceHandler.run(Reference.java:153)

"main" #1 prio=5 os_prio=31 tid=0x00007fd2ee802800 nid=0x1c03 waiting on condition [0x00007000063ff000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x0000000784ce5a90> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at java.util.concurrent.ExecutorCompletionService.take(ExecutorCompletionService.java:193)
	at sbt.ConcurrentRestrictions$$anon$4.take(ConcurrentRestrictions.scala:188)
	at sbt.Execute.next$1(Execute.scala:85)
	at sbt.Execute.processAll(Execute.scala:88)
	at sbt.Execute.runKeep(Execute.scala:68)
	at sbt.EvaluateTask$.liftedTree1$1(EvaluateTask.scala:359)
	at sbt.EvaluateTask$.run$1(EvaluateTask.scala:358)
	at sbt.EvaluateTask$.runTask(EvaluateTask.scala:378)
	at sbt.Aggregation$$anonfun$3.apply(Aggregation.scala:69)
	at sbt.Aggregation$$anonfun$3.apply(Aggregation.scala:67)
	at sbt.EvaluateTask$.withStreams(EvaluateTask.scala:314)
	at sbt.Aggregation$.timedRun(Aggregation.scala:67)
	at sbt.Aggregation$.runTasks(Aggregation.scala:76)
	at sbt.Aggregation$$anonfun$applyTasks$1.apply(Aggregation.scala:37)
	at sbt.Aggregation$$anonfun$applyTasks$1.apply(Aggregation.scala:36)
	at sbt.Command$$anonfun$applyEffect$2$$anonfun$apply$3.apply(Command.scala:61)
	at sbt.Command$$anonfun$applyEffect$2$$anonfun$apply$3.apply(Command.scala:61)
	at sbt.Aggregation$$anonfun$evaluatingParser$4$$anonfun$apply$5.apply(Aggregation.scala:158)
	at sbt.Aggregation$$anonfun$evaluatingParser$4$$anonfun$apply$5.apply(Aggregation.scala:157)
	at sbt.Act$$anonfun$sbt$Act$$actParser0$1$$anonfun$sbt$Act$$anonfun$$evaluate$1$1$$anonfun$apply$10.apply(Act.scala:259)
	at sbt.Act$$anonfun$sbt$Act$$actParser0$1$$anonfun$sbt$Act$$anonfun$$evaluate$1$1$$anonfun$apply$10.apply(Act.scala:256)
	at sbt.Command$.process(Command.scala:93)
	at sbt.MainLoop$$anonfun$1$$anonfun$apply$1.apply(MainLoop.scala:96)
	at sbt.MainLoop$$anonfun$1$$anonfun$apply$1.apply(MainLoop.scala:96)
	at sbt.State$$anon$1.process(State.scala:184)
	at sbt.MainLoop$$anonfun$1.apply(MainLoop.scala:96)
	at sbt.MainLoop$$anonfun$1.apply(MainLoop.scala:96)
	at sbt.ErrorHandling$.wideConvert(ErrorHandling.scala:17)
	at sbt.MainLoop$.next(MainLoop.scala:96)
	at sbt.MainLoop$.run(MainLoop.scala:89)
	at sbt.MainLoop$$anonfun$runWithNewLog$1.apply(MainLoop.scala:68)
	at sbt.MainLoop$$anonfun$runWithNewLog$1.apply(MainLoop.scala:63)
	at sbt.Using.apply(Using.scala:24)
	at sbt.MainLoop$.runWithNewLog(MainLoop.scala:63)
	at sbt.MainLoop$.runAndClearLast(MainLoop.scala:46)
	at sbt.MainLoop$.runLoggedLoop(MainLoop.scala:30)
	at sbt.MainLoop$.runLogged(MainLoop.scala:22)
	at sbt.StandardMain$.runManaged(Main.scala:57)
	at sbt.xMain.run(Main.scala:29)
	at xsbt.boot.Launch$$anonfun$run$1.apply(Launch.scala:109)
	at xsbt.boot.Launch$.withContextLoader(Launch.scala:128)
	at xsbt.boot.Launch$.run(Launch.scala:109)
	at xsbt.boot.Launch$$anonfun$apply$1.apply(Launch.scala:35)
	at xsbt.boot.Launch$.launch(Launch.scala:117)
	at xsbt.boot.Launch$.apply(Launch.scala:18)
	at xsbt.boot.Boot$.runImpl(Boot.scala:41)
	at xsbt.boot.Boot$.main(Boot.scala:17)
	at xsbt.boot.Boot.main(Boot.scala)

"VM Thread" os_prio=31 tid=0x00007fd2ef034800 nid=0x3503 runnable 

"GC task thread#0 (ParallelGC)" os_prio=31 tid=0x00007fd2ee80e800 nid=0x2503 runnable 

"GC task thread#1 (ParallelGC)" os_prio=31 tid=0x00007fd2ee80f000 nid=0x2703 runnable 

"GC task thread#2 (ParallelGC)" os_prio=31 tid=0x00007fd2ee80f800 nid=0x2903 runnable 

"GC task thread#3 (ParallelGC)" os_prio=31 tid=0x00007fd2ee810800 nid=0x2b03 runnable 

"GC task thread#4 (ParallelGC)" os_prio=31 tid=0x00007fd2ee811000 nid=0x2d03 runnable 

"GC task thread#5 (ParallelGC)" os_prio=31 tid=0x00007fd2ee002800 nid=0x2f03 runnable 

"GC task thread#6 (ParallelGC)" os_prio=31 tid=0x00007fd2ee003000 nid=0x3103 runnable 

"GC task thread#7 (ParallelGC)" os_prio=31 tid=0x00007fd2ee004000 nid=0x3303 runnable 

"VM Periodic Task Thread" os_prio=31 tid=0x00007fd2ee84c800 nid=0x5503 waiting on condition 

JNI global references: 294


Found one Java-level deadlock:
=============================
"pool-6-thread-10-ScalaTest-running-Test3":
  waiting to lock monitor 0x00007fd2f0880558 (object 0x0000000782850cd0, a sbt.classpath.ClasspathFilter),
  which is held by "pool-6-thread-1-ScalaTest-running-Test10"
"pool-6-thread-1-ScalaTest-running-Test10":
  waiting to lock monitor 0x00007fd2f0880608 (object 0x0000000782850d28, a sbt.classpath.ClasspathUtilities$$anon$1),
  which is held by "pool-6-thread-10-ScalaTest-running-Test3"

Java stack information for the threads listed above:
===================================================
"pool-6-thread-10-ScalaTest-running-Test3":
	at java.lang.ClassLoader.loadClass(ClassLoader.java:404)
	- waiting to lock <0x0000000782850cd0> (a sbt.classpath.ClasspathFilter)
	at sbt.classpath.ClasspathFilter.loadClass(ClassLoaders.scala:59)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at net.bytebuddy.dynamic.loading.MultipleParentClassLoader.loadClass(MultipleParentClassLoader.java:68)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at java.lang.ClassLoader.defineClass1(Native Method)
	at java.lang.ClassLoader.defineClass(ClassLoader.java:763)
	at sun.reflect.GeneratedMethodAccessor20.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection$Dispatcher$Direct.defineClass(ClassInjector.java:408)
	at net.bytebuddy.dynamic.loading.ClassInjector$UsingReflection.inject(ClassInjector.java:185)
	- locked <0x00000007ada66968> (a net.bytebuddy.dynamic.loading.MultipleParentClassLoader)
	at net.bytebuddy.dynamic.loading.ClassLoadingStrategy$Default$InjectionDispatcher.load(ClassLoadingStrategy.java:187)
	at net.bytebuddy.dynamic.TypeResolutionStrategy$Passive.initialize(TypeResolutionStrategy.java:79)
	at net.bytebuddy.dynamic.DynamicType$Default$Unloaded.load(DynamicType.java:4376)
	at org.mockito.internal.creation.bytebuddy.SubclassBytecodeGenerator.mockClass(SubclassBytecodeGenerator.java:94)
	at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator$1.call(TypeCachingBytecodeGenerator.java:37)
	at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator$1.call(TypeCachingBytecodeGenerator.java:34)
	at net.bytebuddy.TypeCache.findOrInsert(TypeCache.java:138)
	at net.bytebuddy.TypeCache$WithInlineExpunction.findOrInsert(TypeCache.java:346)
	at net.bytebuddy.TypeCache.findOrInsert(TypeCache.java:161)
	- locked <0x0000000782850d28> (a sbt.classpath.ClasspathUtilities$$anon$1)
	at net.bytebuddy.TypeCache$WithInlineExpunction.findOrInsert(TypeCache.java:355)
	at org.mockito.internal.creation.bytebuddy.TypeCachingBytecodeGenerator.mockClass(TypeCachingBytecodeGenerator.java:32)
	at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMockType(SubclassByteBuddyMockMaker.java:71)
	at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMock(SubclassByteBuddyMockMaker.java:42)
	at org.mockito.internal.creation.bytebuddy.ByteBuddyMockMaker.createMock(ByteBuddyMockMaker.java:26)
	at org.mockito.internal.util.MockUtil.createMock(MockUtil.java:35)
	at org.mockito.internal.MockitoCore.mock(MockitoCore.java:65)
	at org.mockito.Mockito.mock(Mockito.java:1729)
	at org.mockito.Mockito.mock(Mockito.java:1642)
	at org.scalatest.mockito.MockitoSugar$class.mock(MockitoSugar.scala:73)
	at scalatest.deadlock.Test3.mock(Test3.scala:11)
	at scalatest.deadlock.Test3$$anonfun$1.apply(Test3.scala:13)
	at scalatest.deadlock.Test3$$anonfun$1.apply(Test3.scala:12)
	at org.scalatest.AsyncFlatSpecLike$class.transformToOutcomeParam$1(AsyncFlatSpecLike.scala:139)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$org$scalatest$AsyncFlatSpecLike$$registerTestToRun$2.apply(AsyncFlatSpecLike.scala:145)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$org$scalatest$AsyncFlatSpecLike$$registerTestToRun$2.apply(AsyncFlatSpecLike.scala:145)
	at org.scalatest.AsyncTestSuite$$anonfun$transformToOutcome$1.apply(AsyncTestSuite.scala:240)
	at org.scalatest.AsyncTestSuite$$anonfun$transformToOutcome$1.apply(AsyncTestSuite.scala:239)
	at org.scalatest.AsyncFlatSpecLike$$anon$1.apply(AsyncFlatSpecLike.scala:1698)
	at org.scalatest.AsyncTestSuite$class.withFixture(AsyncTestSuite.scala:313)
	at org.scalatest.AsyncFlatSpec.withFixture(AsyncFlatSpec.scala:2219)
	at org.scalatest.AsyncFlatSpecLike$class.invokeWithAsyncFixture$1(AsyncFlatSpecLike.scala:1695)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$runTest$1.apply(AsyncFlatSpecLike.scala:1709)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$runTest$1.apply(AsyncFlatSpecLike.scala:1709)
	at org.scalatest.AsyncSuperEngine.runTestImpl(AsyncEngine.scala:292)
	at org.scalatest.AsyncFlatSpecLike$class.runTest(AsyncFlatSpecLike.scala:1709)
	at org.scalatest.AsyncFlatSpec.runTest(AsyncFlatSpec.scala:2219)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$runTests$1.apply(AsyncFlatSpecLike.scala:1767)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$runTests$1.apply(AsyncFlatSpecLike.scala:1767)
	at org.scalatest.AsyncSuperEngine$$anonfun$traverseSubNodes$1$1.apply(AsyncEngine.scala:434)
	at org.scalatest.AsyncSuperEngine$$anonfun$traverseSubNodes$1$1.apply(AsyncEngine.scala:419)
	at scala.collection.LinearSeqOptimized$class.foldLeft(LinearSeqOptimized.scala:124)
	at scala.collection.immutable.List.foldLeft(List.scala:84)
	at org.scalatest.AsyncSuperEngine.traverseSubNodes$1(AsyncEngine.scala:419)
	at org.scalatest.AsyncSuperEngine.org$scalatest$AsyncSuperEngine$$runTestsInBranch(AsyncEngine.scala:475)
	at org.scalatest.AsyncSuperEngine$$anonfun$traverseSubNodes$1$1.apply(AsyncEngine.scala:460)
	at org.scalatest.AsyncSuperEngine$$anonfun$traverseSubNodes$1$1.apply(AsyncEngine.scala:419)
	at scala.collection.LinearSeqOptimized$class.foldLeft(LinearSeqOptimized.scala:124)
	at scala.collection.immutable.List.foldLeft(List.scala:84)
	at org.scalatest.AsyncSuperEngine.traverseSubNodes$1(AsyncEngine.scala:419)
	at org.scalatest.AsyncSuperEngine.org$scalatest$AsyncSuperEngine$$runTestsInBranch(AsyncEngine.scala:483)
	at org.scalatest.AsyncSuperEngine.runTestsImpl(AsyncEngine.scala:550)
	at org.scalatest.AsyncFlatSpecLike$class.runTests(AsyncFlatSpecLike.scala:1767)
	at org.scalatest.AsyncFlatSpec.runTests(AsyncFlatSpec.scala:2219)
	at org.scalatest.Suite$class.run(Suite.scala:1147)
	at org.scalatest.AsyncFlatSpec.org$scalatest$AsyncFlatSpecLike$$super$run(AsyncFlatSpec.scala:2219)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$run$1.apply(AsyncFlatSpecLike.scala:1812)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$run$1.apply(AsyncFlatSpecLike.scala:1812)
	at org.scalatest.AsyncSuperEngine.runImpl(AsyncEngine.scala:620)
	at org.scalatest.AsyncFlatSpecLike$class.run(AsyncFlatSpecLike.scala:1812)
	at org.scalatest.AsyncFlatSpec.run(AsyncFlatSpec.scala:2219)
	at org.scalatest.tools.Framework.org$scalatest$tools$Framework$$runSuite(Framework.scala:314)
	at org.scalatest.tools.Framework$ScalaTestTask.execute(Framework.scala:480)
	at sbt.TestRunner.runTest$1(TestFramework.scala:76)
	at sbt.TestRunner.run(TestFramework.scala:85)
	at sbt.TestFramework$$anon$2$$anonfun$$init$$1$$anonfun$apply$8.apply(TestFramework.scala:202)
	at sbt.TestFramework$$anon$2$$anonfun$$init$$1$$anonfun$apply$8.apply(TestFramework.scala:202)
	at sbt.TestFramework$.sbt$TestFramework$$withContextLoader(TestFramework.scala:185)
	at sbt.TestFramework$$anon$2$$anonfun$$init$$1.apply(TestFramework.scala:202)
	at sbt.TestFramework$$anon$2$$anonfun$$init$$1.apply(TestFramework.scala:202)
	at sbt.TestFunction.apply(TestFramework.scala:207)
	at sbt.Tests$$anonfun$9.apply(Tests.scala:216)
	at sbt.Tests$$anonfun$9.apply(Tests.scala:216)
	at sbt.std.Transform$$anon$3$$anonfun$apply$2.apply(System.scala:44)
	at sbt.std.Transform$$anon$3$$anonfun$apply$2.apply(System.scala:44)
	at sbt.std.Transform$$anon$4.work(System.scala:63)
	at sbt.Execute$$anonfun$submit$1$$anonfun$apply$1.apply(Execute.scala:228)
	at sbt.Execute$$anonfun$submit$1$$anonfun$apply$1.apply(Execute.scala:228)
	at sbt.ErrorHandling$.wideConvert(ErrorHandling.scala:17)
	at sbt.Execute.work(Execute.scala:237)
	at sbt.Execute$$anonfun$submit$1.apply(Execute.scala:228)
	at sbt.Execute$$anonfun$submit$1.apply(Execute.scala:228)
	at sbt.ConcurrentRestrictions$$anon$4$$anonfun$1.apply(ConcurrentRestrictions.scala:159)
	at sbt.CompletionService$$anon$2.call(CompletionService.scala:28)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
"pool-6-thread-1-ScalaTest-running-Test10":
	at java.lang.ClassLoader.loadClass(ClassLoader.java:404)
	- waiting to lock <0x0000000782850d28> (a sbt.classpath.ClasspathUtilities$$anon$1)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:411)
	- locked <0x0000000782850cd0> (a sbt.classpath.ClasspathFilter)
	at sbt.classpath.ClasspathFilter.loadClass(ClassLoaders.scala:59)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at net.bytebuddy.dynamic.loading.MultipleParentClassLoader.loadClass(MultipleParentClassLoader.java:68)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at sun.misc.Unsafe.defineClass(Native Method)
	at sun.reflect.ClassDefiner.defineClass(ClassDefiner.java:63)
	at sun.reflect.MethodAccessorGenerator$1.run(MethodAccessorGenerator.java:399)
	at sun.reflect.MethodAccessorGenerator$1.run(MethodAccessorGenerator.java:394)
	at java.security.AccessController.doPrivileged(Native Method)
	at sun.reflect.MethodAccessorGenerator.generate(MethodAccessorGenerator.java:393)
	at sun.reflect.MethodAccessorGenerator.generateSerializationConstructor(MethodAccessorGenerator.java:112)
	at sun.reflect.ReflectionFactory.generateConstructor(ReflectionFactory.java:398)
	at sun.reflect.ReflectionFactory.newConstructorForSerialization(ReflectionFactory.java:360)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.objenesis.instantiator.sun.SunReflectionFactoryHelper.newConstructorForSerialization(SunReflectionFactoryHelper.java:44)
	at org.objenesis.instantiator.sun.SunReflectionFactoryInstantiator.<init>(SunReflectionFactoryInstantiator.java:41)
	at org.objenesis.strategy.StdInstantiatorStrategy.newInstantiatorOf(StdInstantiatorStrategy.java:67)
	at org.objenesis.ObjenesisBase.getInstantiatorOf(ObjenesisBase.java:94)
	at org.objenesis.ObjenesisBase.newInstance(ObjenesisBase.java:73)
	at org.mockito.internal.creation.instance.ObjenesisInstantiator.newInstance(ObjenesisInstantiator.java:18)
	at org.mockito.internal.creation.bytebuddy.SubclassByteBuddyMockMaker.createMock(SubclassByteBuddyMockMaker.java:47)
	at org.mockito.internal.creation.bytebuddy.ByteBuddyMockMaker.createMock(ByteBuddyMockMaker.java:26)
	at org.mockito.internal.util.MockUtil.createMock(MockUtil.java:35)
	at org.mockito.internal.MockitoCore.mock(MockitoCore.java:65)
	at org.mockito.Mockito.mock(Mockito.java:1729)
	at org.mockito.Mockito.mock(Mockito.java:1642)
	at org.scalatest.mockito.MockitoSugar$class.mock(MockitoSugar.scala:73)
	at scalatest.deadlock.Test10.mock(Test10.scala:11)
	at scalatest.deadlock.Test10$$anonfun$1.apply(Test10.scala:13)
	at scalatest.deadlock.Test10$$anonfun$1.apply(Test10.scala:12)
	at org.scalatest.AsyncFlatSpecLike$class.transformToOutcomeParam$1(AsyncFlatSpecLike.scala:139)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$org$scalatest$AsyncFlatSpecLike$$registerTestToRun$2.apply(AsyncFlatSpecLike.scala:145)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$org$scalatest$AsyncFlatSpecLike$$registerTestToRun$2.apply(AsyncFlatSpecLike.scala:145)
	at org.scalatest.AsyncTestSuite$$anonfun$transformToOutcome$1.apply(AsyncTestSuite.scala:240)
	at org.scalatest.AsyncTestSuite$$anonfun$transformToOutcome$1.apply(AsyncTestSuite.scala:239)
	at org.scalatest.AsyncFlatSpecLike$$anon$1.apply(AsyncFlatSpecLike.scala:1698)
	at org.scalatest.AsyncTestSuite$class.withFixture(AsyncTestSuite.scala:313)
	at org.scalatest.AsyncFlatSpec.withFixture(AsyncFlatSpec.scala:2219)
	at org.scalatest.AsyncFlatSpecLike$class.invokeWithAsyncFixture$1(AsyncFlatSpecLike.scala:1695)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$runTest$1.apply(AsyncFlatSpecLike.scala:1709)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$runTest$1.apply(AsyncFlatSpecLike.scala:1709)
	at org.scalatest.AsyncSuperEngine.runTestImpl(AsyncEngine.scala:292)
	at org.scalatest.AsyncFlatSpecLike$class.runTest(AsyncFlatSpecLike.scala:1709)
	at org.scalatest.AsyncFlatSpec.runTest(AsyncFlatSpec.scala:2219)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$runTests$1.apply(AsyncFlatSpecLike.scala:1767)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$runTests$1.apply(AsyncFlatSpecLike.scala:1767)
	at org.scalatest.AsyncSuperEngine$$anonfun$traverseSubNodes$1$1.apply(AsyncEngine.scala:434)
	at org.scalatest.AsyncSuperEngine$$anonfun$traverseSubNodes$1$1.apply(AsyncEngine.scala:419)
	at scala.collection.LinearSeqOptimized$class.foldLeft(LinearSeqOptimized.scala:124)
	at scala.collection.immutable.List.foldLeft(List.scala:84)
	at org.scalatest.AsyncSuperEngine.traverseSubNodes$1(AsyncEngine.scala:419)
	at org.scalatest.AsyncSuperEngine.org$scalatest$AsyncSuperEngine$$runTestsInBranch(AsyncEngine.scala:475)
	at org.scalatest.AsyncSuperEngine$$anonfun$traverseSubNodes$1$1.apply(AsyncEngine.scala:460)
	at org.scalatest.AsyncSuperEngine$$anonfun$traverseSubNodes$1$1.apply(AsyncEngine.scala:419)
	at scala.collection.LinearSeqOptimized$class.foldLeft(LinearSeqOptimized.scala:124)
	at scala.collection.immutable.List.foldLeft(List.scala:84)
	at org.scalatest.AsyncSuperEngine.traverseSubNodes$1(AsyncEngine.scala:419)
	at org.scalatest.AsyncSuperEngine.org$scalatest$AsyncSuperEngine$$runTestsInBranch(AsyncEngine.scala:483)
	at org.scalatest.AsyncSuperEngine.runTestsImpl(AsyncEngine.scala:550)
	at org.scalatest.AsyncFlatSpecLike$class.runTests(AsyncFlatSpecLike.scala:1767)
	at org.scalatest.AsyncFlatSpec.runTests(AsyncFlatSpec.scala:2219)
	at org.scalatest.Suite$class.run(Suite.scala:1147)
	at org.scalatest.AsyncFlatSpec.org$scalatest$AsyncFlatSpecLike$$super$run(AsyncFlatSpec.scala:2219)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$run$1.apply(AsyncFlatSpecLike.scala:1812)
	at org.scalatest.AsyncFlatSpecLike$$anonfun$run$1.apply(AsyncFlatSpecLike.scala:1812)
	at org.scalatest.AsyncSuperEngine.runImpl(AsyncEngine.scala:620)
	at org.scalatest.AsyncFlatSpecLike$class.run(AsyncFlatSpecLike.scala:1812)
	at org.scalatest.AsyncFlatSpec.run(AsyncFlatSpec.scala:2219)
	at org.scalatest.tools.Framework.org$scalatest$tools$Framework$$runSuite(Framework.scala:314)
	at org.scalatest.tools.Framework$ScalaTestTask.execute(Framework.scala:480)
	at sbt.TestRunner.runTest$1(TestFramework.scala:76)
	at sbt.TestRunner.run(TestFramework.scala:85)
	at sbt.TestFramework$$anon$2$$anonfun$$init$$1$$anonfun$apply$8.apply(TestFramework.scala:202)
	at sbt.TestFramework$$anon$2$$anonfun$$init$$1$$anonfun$apply$8.apply(TestFramework.scala:202)
	at sbt.TestFramework$.sbt$TestFramework$$withContextLoader(TestFramework.scala:185)
	at sbt.TestFramework$$anon$2$$anonfun$$init$$1.apply(TestFramework.scala:202)
	at sbt.TestFramework$$anon$2$$anonfun$$init$$1.apply(TestFramework.scala:202)
	at sbt.TestFunction.apply(TestFramework.scala:207)
	at sbt.Tests$$anonfun$9.apply(Tests.scala:216)
	at sbt.Tests$$anonfun$9.apply(Tests.scala:216)
	at sbt.std.Transform$$anon$3$$anonfun$apply$2.apply(System.scala:44)
	at sbt.std.Transform$$anon$3$$anonfun$apply$2.apply(System.scala:44)
	at sbt.std.Transform$$anon$4.work(System.scala:63)
	at sbt.Execute$$anonfun$submit$1$$anonfun$apply$1.apply(Execute.scala:228)
	at sbt.Execute$$anonfun$submit$1$$anonfun$apply$1.apply(Execute.scala:228)
	at sbt.ErrorHandling$.wideConvert(ErrorHandling.scala:17)
	at sbt.Execute.work(Execute.scala:237)
	at sbt.Execute$$anonfun$submit$1.apply(Execute.scala:228)
	at sbt.Execute$$anonfun$submit$1.apply(Execute.scala:228)
	at sbt.ConcurrentRestrictions$$anon$4$$anonfun$1.apply(ConcurrentRestrictions.scala:159)
	at sbt.CompletionService$$anon$2.call(CompletionService.scala:28)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

Found 1 deadlock.

Heap
 PSYoungGen      total 305664K, used 50474K [0x00000007aab00000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 262144K, 19% used [0x00000007aab00000,0x00000007adc4aad0,0x00000007bab00000)
  from space 43520K, 0% used [0x00000007bab00000,0x00000007bab00000,0x00000007bd580000)
  to   space 43520K, 0% used [0x00000007bd580000,0x00000007bd580000,0x00000007c0000000)
 ParOldGen       total 699392K, used 83976K [0x0000000780000000, 0x00000007aab00000, 0x00000007aab00000)
  object space 699392K, 12% used [0x0000000780000000,0x0000000785202280,0x00000007aab00000)
 Metaspace       used 73192K, capacity 74034K, committed 74368K, reserved 1110016K
  class space    used 13647K, capacity 13867K, committed 13952K, reserved 1048576K

```
