/*
 * Copyright 2016 Benedikt Ritter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.britter.bowlinggamekata

import org.scalatest.{BeforeAndAfterEach, Matchers, WordSpec}

class BowlingGameTest extends WordSpec with Matchers with BeforeAndAfterEach {

  var g: Game = null

  override def beforeEach() {
      g = new Game
  }

  "A Game" should {

    "calculate 0 points for gutter game" in {
      rollMany(20, 0)

      g.score shouldBe 0
    }

    "calculate 10 points for all 1 game" in {
      rollMany(20, 1)

      g.score shouldBe 20
    }

    "calculate bonus points for one spare" in {
      g.roll(5)
      g.roll(5) // spare
      g.roll(3)
      rollMany(17, 0)

      g.score shouldBe 16
    }
  }

  def rollMany(rolls: Int, pins: Int) = for (i <- 0 until rolls) g.roll(pins) 
}
