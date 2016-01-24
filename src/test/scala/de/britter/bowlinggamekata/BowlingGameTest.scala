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

import org.scalatest.{ Matchers, WordSpec }

class BowlingGameTest extends WordSpec with Matchers {

  "A Game" should {

    "calculate 0 points for gutter game" in {
      val g = new Game
      for (i <- 0 until 20) g.roll(0)

      g.score shouldBe 0
    }

    "calculate 10 points for all 1 game" in {
      val g = new Game
      for (i <- 0 until 20) g.roll(1)

      g.score shouldBe 20
    }
  }

}
