lazy val `bank-kata-scala` =
  project.in(file(".")).enablePlugins(AutomateHeaderPlugin, GitVersioning)

libraryDependencies ++= Vector(
  Library.scalaTest % "test"
)

initialCommands := """|import de.britter.bank.kata.scala._
                      |""".stripMargin
