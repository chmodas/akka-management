import sbt._, Keys._

import de.heikoseeberger.sbtheader._
import de.heikoseeberger.sbtheader.HeaderPlugin.autoImport._

object Common extends AutoPlugin {

  override def trigger = allRequirements
  override def requires = plugins.JvmPlugin && HeaderPlugin

  override lazy val projectSettings =
    Dependencies.Common ++ Seq(
    organization := "com.lightbend.akka.management", // FIXME proposing this change, then we can have "com.lightbend.akka.management|discovery" etc; we'd do management.commercial for example later
    organizationName := "Lightbend Inc.",
    startYear := Some(2017),
    homepage := Some(url("https://github.com/akka/akka-management")),
    scmInfo := Some(ScmInfo(url("https://github.com/akka/akka-management"), "git@github.com:akka/akka-management.git")),
    developers += Developer("contributors", "Contributors", "https://gitter.im/akka/dev", url("https://github.com/akka/akka-management/graphs/contributors")),

    licenses := Seq(("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0"))),
    headerLicense := Some(HeaderLicense.Custom("Copyright (C) 2017-2018 Lightbend Inc. <https://www.lightbend.com>")),

    crossScalaVersions := Seq("2.11.12", "2.12.8", "2.13.0-M5"),

    crossVersion := CrossVersion.binary,

    scalacOptions ++= Seq(
      "-encoding", "UTF-8",
      "-feature",
      "-unchecked",
      "-deprecation",
      "-Xlint",
      "-Ywarn-dead-code",
      "-Xfuture",
      "-target:jvm-1.8"
    ),

    javacOptions ++= Seq(
      "-Xlint:unchecked"
    ),

    autoAPIMappings := true,

    // show full stack traces and test case durations
    testOptions in Test += Tests.Argument("-oDF"),

    // -v Log "test run started" / "test started" / "test run finished" events on log level "info" instead of "debug".
    // -a Show stack traces and exception class name for AssertionErrors.
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-v", "-a"),

    scalaVersion := "2.12.8"
  )
}
