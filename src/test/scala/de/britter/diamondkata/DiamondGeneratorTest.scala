package de.britter.diamondkata

import org.scalatest.{Matchers, WordSpec}

class DiamondGeneratorTest extends WordSpec with Matchers {

  "A DiamondGenerator" should {

    "print single line 'A' for character 'A' and target 'A'" in {
      DiamondGenerator.generateLine('A', 'A') shouldBe "A"
    }
    
    "print ' A ' for character 'A' and target 'B'" in {
      DiamondGenerator.generateLine('A', 'B') shouldBe " A "
    }

  }
}
