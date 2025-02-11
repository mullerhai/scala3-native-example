ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.6.2"
//ThisBuild / nativeConfiguration := ScalaNativePluginInternal.nativeConfiguration.value.withOptLevel("O3")
lazy val root = (project in file("."))
  .settings(
    name := "scala-native-muller"
  )

 enablePlugins(ScalaNativePlugin)

import scala.scalanative.sbtplugin.ScalaNativePluginInternal.scalaNativeDependencySettings
import scala.scalanative.build._

import sbt.*
import scala.scalanative.build.*
import scala.sys.process.*
lazy val nativeSettings = Seq(
  scalacOptions ++= Seq("-P:scalanative:genStaticForwardersForNonTopLevelObjects"),
  libraryDependencies ++= Seq(
    "io.github.cquiroz" %%% "scala-java-time-tzdb" % "2.6.0"  //% Test
  ),
  nativeConfig ~= {
    _.withMode(Mode.releaseFast) // TODO: Test with `Mode.releaseSize` and `Mode.releaseFull`
      .withLTO(LTO.none)
  }
//  coverageEnabled := false // FIXME: Unexpected linking error
)

//nativeConfig ~= {
//  _.withLTO(LTO.thin)
//    .withMode(Mode.releaseFast)
//    .withGC(GC.commix)
//}
libraryDependencies += "org.scala-sbt" %% "scripted-plugin" % "2.0.0-alpha10"
