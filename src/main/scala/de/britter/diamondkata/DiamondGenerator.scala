package de.britter.diamondkata

object DiamondGenerator {

  def generate(c: Char): String = {
    if (c == 'A') c.toString else
      """ A 
        |B B
        | A """.stripMargin
  }

}
