import sbt._
import Process._
import Keys._

resolvers ++= Seq("Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  Resolver.bintrayRepo("hseeberger", "maven"))

lazy val AKKA_VERSION = "2.4.17"
lazy val AKKA_HTTP_VERSION = "10.0.5"
lazy val JSON4S_VERSION = "3.5.1"

lazy val json4s = Seq(
  libraryDependencies ++= Seq(
    "org.json4s"        %% "json4s-native"   % "3.5.1",
    "org.json4s"        %% "json4s-ext"      % "3.5.1"
  )
)

lazy val akkaSettings = Seq(
  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor" % AKKA_VERSION,
    "com.typesafe.akka" %% "akka-testkit" % AKKA_VERSION,
    "com.typesafe.akka" %% "akka-camel" % AKKA_VERSION,
    "com.typesafe.akka" %% "akka-http-core" % AKKA_HTTP_VERSION,
    "com.typesafe.akka" %% "akka-http" % AKKA_HTTP_VERSION,
    "com.typesafe.akka" %% "akka-http-jackson" % AKKA_HTTP_VERSION,
    "com.typesafe.akka" %% "akka-http-testkit" % AKKA_HTTP_VERSION
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
    akkaSettings ++
    json4s
  )
        