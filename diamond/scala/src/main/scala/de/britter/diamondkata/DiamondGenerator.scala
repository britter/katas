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

package de.britter.diamondkata

object Diamond {
  def apply(diamondChar: Char) = new DiamondGenerator(diamondChar).generate
}

class DiamondGenerator(diamondChar: Char) {

  private val alphabet = Vector('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')

  def generate: String = {
    val upperHalfCharacters = alphabet.slice(0, alphabet.indexOf(diamondChar))

    val upperLines = for (lineChar <- upperHalfCharacters) yield generateLine(lineChar)
    val middleLine = generateLine(diamondChar)
    val allLines = (upperLines :+ middleLine) ++ upperLines.reverse

    allLines.mkString(System.lineSeparator())
  }

  def generateLine(lineChar: Char): String = {
    val innerSpacing = alphabet.indexOf(lineChar) * 2 - 1
    val outerSpacing = alphabet.indexOf(diamondChar) - alphabet.indexOf(lineChar)

    if (innerSpacing > 0)
      outerSpacing.spaces + lineChar + innerSpacing.spaces + lineChar + outerSpacing.spaces
    else
      outerSpacing.spaces + lineChar + outerSpacing.spaces
  }

  private implicit class TimesSpaces(i: Int) {
    def spaces: String = " " * i
  }
}
