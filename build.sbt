name := "sample-spark-scala-application"
version := "0.0.0-SNAPSHOT"
organization := "com.cerenode"

scalaVersion := "2.11.11"
val sparkVersion = "2.2.0"

libraryDependencies ++= Seq(
    "org.apache.spark" %% "spark-core" % sparkVersion % Provided,
    "org.apache.spark" %% "spark-sql"  % sparkVersion % Provided,
    "org.scalatest"    %% "scalatest"  % "2.2.1"      % "test",
    "com.holdenkarau" %% "spark-testing-base" % "2.2.0_0.9.0" % "test"
)

// test run settings
//parallelExecution in Test := false
//coverageEnabled.in(Test, test) := true
coverageMinimum := 70
coverageFailOnMinimum := true

