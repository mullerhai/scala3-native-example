addSbtPlugin("com.github.sbt" % "sbt-native-packager" % "1.11.1")
addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.5.6")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "2.3.1")
//addSbtPlugin("org.foundweekends.giter8" %% "sbt-giter8" % "0.16.2")
libraryDependencies += {
  "org.scala-sbt" %% "scripted-plugin" % "2.0.0-alpha10"
}
val VcpkgVersion =
  sys.env.getOrElse("SBT_VCPKG_VERSION", "0.0.21")
addSbtPlugin("com.indoorvivants" % "bindgen-sbt-plugin" % "0.2.2")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.2")
addSbtPlugin("com.indoorvivants.vcpkg" % "sbt-vcpkg-native" % VcpkgVersion)