import sbt.CrossVersion

version := "0.0.1"

scalaVersion := "2.10.0"

crossScalaVersions := Seq("2.9.2", "2.10.0")

name := "pantalaimon"

organization := "com.mosesn"

libraryDependencies ++= Seq(
  "com.twitter" %% "ostrich" % "9.1.0" cross CrossVersion.binary,
  "com.twitter" %% "finagle-core" % "6.3.0" cross CrossVersion.binary,
  "com.twitter" %% "finagle-http" % "6.3.0" cross CrossVersion.binary,
  "com.twitter" %% "util-logging" % "6.3.0" cross CrossVersion.binary
)
