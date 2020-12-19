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

class Game {

  private val rolls: Array[Int] = Array.ofDim(21)
  private var currentRoll = 0

  def roll(pins: Int): Unit = {
    rolls(currentRoll) = pins
    currentRoll += 1
  }

  def score: Int = {
    var score = 0
    var frameIndex = 0
    for (frame <- 0 until 10) {
      if (isStrike(frameIndex)) {
        score += 10 + strikeBonus(frameIndex)
        frameIndex += 1
      } else if (isSpare(frameIndex)) {
        score += 10 + spareBonus(frameIndex)
        frameIndex += 2
      } else {
        score += sumOfBallsInFrame(frameIndex)
        frameIndex += 2
      }
    }
    score
  }

  private def sumOfBallsInFrame(frameIndex: Int): Int = rolls(frameIndex) + rolls(frameIndex + 1)

  private def spareBonus(frameIndex: Int) = rolls(frameIndex + 2)

  private def strikeBonus(frameIndex: Int) = rolls(frameIndex + 1) + rolls(frameIndex + 2)

  private def isSpare(frameIndex: Int) = rolls(frameIndex) + rolls(frameIndex + 1) == 10

  private def isStrike(frameIndex: Int) = rolls(frameIndex) == 10
}
