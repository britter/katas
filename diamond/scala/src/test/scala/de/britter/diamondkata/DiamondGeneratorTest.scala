package de.britter.diamondkata

import org.scalatest.{Matchers, WordSpec}

class DiamondGeneratorTest extends WordSpec with Matchers {

  "DiamondGenerator generateLine" should {

    "print single line 'A' for character 'A' and target 'A'" in {
      new DiamondGenerator('A').generateLine('A') shouldBe "A"
    }
    
    "print ' A ' for character 'A' and target 'B'" in {
      new DiamondGenerator('B').generateLine('A') shouldBe " A "
    }

    "print '   A   ' for character 'A' and target 'D'" in {
      new DiamondGenerator('D').generateLine('A') shouldBe "   A   "
    }
    
    "print 'B B' for character 'B' and target B" in {
      new DiamondGenerator('B').generateLine('B') shouldBe "B B"
    }
    
    "print ' B B ' for character 'B' and target 'C'" in {
      new DiamondGenerator('C').generateLine('B') shouldBe " B B "
    }
  }
  
  "Diamond generate" should {
    
    "generate 'A' for input 'A'" in {
      Diamond('A') shouldBe "A"
    }
    
    "generate a diamond for input 'B'" in {
      Diamond('B') shouldBe
        """| A 
           |B B
           | A """.stripMargin
    }
  }
}
