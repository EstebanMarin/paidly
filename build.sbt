import Dependencies._

ThisBuild / organization := "com.estebanmarin"
ThisBuild / scalaVersion := "3.1.3"

ThisBuild / scalacOptions ++=
  Seq(
    "-deprecation",
    "-explain",
    "-feature",
    "-language:implicitConversions",
    "-unchecked",
    "-Xfatal-warnings",
    "-Yexplicit-nulls", // experimental (I've seen it cause issues with circe)
    "-Ykind-projector",
    "-Ysafe-init", // experimental (I've seen it cause issues with circe)
  ) ++ Seq("-rewrite", "-indent") ++ Seq("-source", "future-migration")

lazy val `paidly` =
  project
    .in(file("."))
    .settings(name := "paidly")
    .settings(commonSettings)
    .settings(dependencies)

lazy val commonSettings = commonScalacOptions ++ Seq(
  update / evictionWarningOptions := EvictionWarningOptions.empty
)

lazy val commonScalacOptions = Seq(
  Compile / console / scalacOptions --= Seq(
    "-Wunused:_",
    "-Xfatal-warnings",
  ),
  Test / console / scalacOptions :=
    (Compile / console / scalacOptions).value,
)

lazy val dependencies = Seq(
  libraryDependencies ++= Seq(
    // main dependencies
    org.zio.zio,
    org.timeLib.nsclala
  ),
  libraryDependencies ++= Seq(
    org.scalatest.scalatest,
    org.scalatestplus.`scalacheck-1-16`,
  ).map(_ % Test),
)
