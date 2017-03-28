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

