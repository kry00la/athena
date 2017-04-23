import sbt._
import Process._
import Keys._



lazy val akkaSettings = Seq(
  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor" % "2.4.17",
    "com.typesafe.akka" %% "akka-testkit" % "2.4.17",
    "com.typesafe.akka" %% "akka-camel" % "2.4.17",
    "com.typesafe.akka" %% "akka-http-core" % "10.0.5",
    "com.typesafe.akka" %% "akka-http" % "10.0.5",
    "com.typesafe.akka" %% "akka-http-jackson" % "10.0.5",
    "com.typesafe.akka" %% "akka-http-testkit" % "10.0.5"
  )
)

lazy val commonSettings = Seq(
  organization := "com.ph.athena",
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.12.1"
)

lazy val root = (project in file("."))
  .settings(
    commonSettings,
    name := "athena",
    akkaSettings
  )
        