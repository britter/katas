import sbt._

object Version {
  final val Scala      = "2.11.7"
  final val ScalaCheck = "1.12.5"
  final val ScalaTest  = "2.2.6"
}

object Library {
  val scalaCheck = "org.scalacheck" %% "scalacheck" % Version.ScalaCheck
  val scalaTest  = "org.scalatest"  %% "scalatest"  % Version.ScalaTest
}