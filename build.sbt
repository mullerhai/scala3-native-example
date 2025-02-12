ThisBuild / version := "0.1.0-SNAPSHOT"
import scala.scalanative.sbtplugin.ScalaNativePluginInternal.scalaNativeDependencySettings
import scala.scalanative.build.*
import scala.scalanative.build.SourceLevelDebuggingConfig
import scala.scalanative.build.OptimizerConfig
import bindgen.plugin.BindgenMode
import com.indoorvivants.detective.Platform.OS.*
import com.indoorvivants.detective.Platform
import bindgen.interface.Binding
import bindgen.interface.LogLevel

import java.nio.file.Paths

Global / onChangedBuildSource := ReloadOnSourceChanges

import sbt.*
import scala.scalanative.build.*
import scala.sys.process.*
lazy val Versions = new {
  val Scala = "3.6.3" // "3.3.4"
}
ThisBuild / scalaVersion := "3.6.3"
//ThisBuild / nativeConfiguration := ScalaNativePluginInternal.nativeConfiguration.value.withOptLevel("O3")
lazy val root = (project in file("."))
  .settings(
    name := "scala-native-muller"
  )
def configurePlatform(rename: String => String = identity) = Seq(
  nativeConfig := {
    val conf = nativeConfig.value
    val arch64 =
      if (
        Platform.arch == Platform.Arch.Arm && Platform.bits == Platform.Bits.x64
      )
        List("-arch", "arm64")
      else Nil

    conf
      .withLinkingOptions(
        conf.linkingOptions ++ arch64
      )
      .withCompileOptions(
        conf.compileOptions ++ arch64
      )
  }
)
val bindgenSettings = Seq(
  bindgenMode := BindgenMode.Manual(
    scalaDir = (Compile / sourceDirectory).value / "scala" / "generated",
    cDir = (Compile / resourceDirectory).value / "scala-native" / "generated"
  ),
  bindgenBindings := {
    bindgenBindings.value.map(_.withNoLocation(true))
  }
)

//lazy val root = project
//  .in(file("."))
//  .enablePlugins(ScalaNativePlugin, BindgenPlugin, VcpkgNativePlugin)
//  .settings(
//    scalaVersion := Versions.Scala,
//    vcpkgDependencies := VcpkgDependencies("opencv"),
//    vcpkgNativeConfig ~= { _.addRenamedLibrary("opencv", "libopencv") },
//    bindgenBindings += {
//      Binding(
//        vcpkgConfigurator.value.includes("libopencv") / "libopencv" / "cv.h",
//        "libopencv"
//      )
//        .withCImports(
//          List("cv.h")
//        )
//    }
//  )
//  .settings(bindgenSettings)
//  .settings(configurePlatform())

//lazy val root = project
//  .in(file("."))
//  .enablePlugins(ScalaNativePlugin, BindgenPlugin, VcpkgNativePlugin)
//  .settings(
//    scalaVersion := Versions.Scala,
//    vcpkgDependencies := VcpkgDependencies("cjson"),
//    vcpkgNativeConfig ~= { _.addRenamedLibrary("cjson", "libcjson") },
//    bindgenBindings += {
//      Binding(
//        vcpkgConfigurator.value.includes("cjson") / "cjson" / "cJSON.h",
//        "cjson"
//      )
//        .withCImports(
//          List("cJSON.h")
//        )
//    }
//  )
//  .settings(bindgenSettings)
//  .settings(configurePlatform())


// enablePlugins(ScalaNativePlugin)
enablePlugins(ScalaNativePlugin, BindgenPlugin)

import bindgen.interface.Binding

bindgenBindings := Seq(
  Binding(
    baseDirectory.value / "src" / "main" / "resources" / "scala-native" / "header.h",
    "lib_check"
  ).withCImports(List("header.h"))
)

//bindgenBindings := Seq(
//  Binding(
//    baseDirectory.value / "src" / "main" / "resources" / "scala-native" / "header.h",
//      /* 1 */  (Compile / resourceDirectory).value / "scala-native" / "header.h",
//      /* 2 */  "libtest"
//    )
//    .addCImport("header.h")) /* 3 */
////    .build
//)
//)

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
