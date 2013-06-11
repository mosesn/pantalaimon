import sbt.CrossVersion

version := "0.0.2"

scalaVersion := "2.10.2"

crossScalaVersions := Seq("2.9.2", "2.9.3", "2.10.2")

name := "pantalaimon"

organization := "com.mosesn"

libraryDependencies ++= Seq(
  "com.twitter" %% "twitter-server" % "1.0.1" cross CrossVersion.binary,
  "com.twitter" %% "finagle-core"   % "6.4.1" cross CrossVersion.binary,
  "com.twitter" %% "finagle-http"   % "6.4.1" cross CrossVersion.binary,
  "com.twitter" %% "util-logging"   % "6.3.5" cross CrossVersion.binary
)
