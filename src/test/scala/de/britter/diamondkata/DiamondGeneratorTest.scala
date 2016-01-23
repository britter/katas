package de.britter.diamondkata

import org.scalatest.{Matchers, WordSpec}

class DiamondGeneratorTest extends WordSpec with Matchers {

  "A DiamondGenerator" should {
    
    "generate a single 'A' for A input" in {
      DiamondGenerator.generate('A') shouldBe "A"
    }
  }
}
