lazy val gildedRose = project
  .copy(id = "gilded-rose")
  .in(file("."))
  .enablePlugins(AutomateHeaderPlugin, GitVersioning)

name := "gilded-rose"

libraryDependencies ++= Vector(
  Library.scalaCheck % "test",
  Library.scalaTest  % "test"
)

initialCommands := """|import de.britter.gildedrose
                      |""".stripMargin
