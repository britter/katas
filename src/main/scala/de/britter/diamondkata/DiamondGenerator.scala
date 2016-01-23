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

object DiamondGenerator {

  private val alphabet = Vector('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')

  def generate(c: Char): String = generateLine(c, c)

  def generateLine(lineChar: Char, diamondChar: Char): String = {
    val innerSpacing = alphabet.indexOf(lineChar) * 2 -1

    val diff = alphabet.indexOf(diamondChar) - alphabet.indexOf(lineChar)

    if (innerSpacing > 0)
      spaces(diff) + lineChar + spaces(innerSpacing) + lineChar + spaces(diff)
    else
      spaces(diff) + lineChar + spaces(diff)
  }

  private def spaces(n: Int) = " " * n
}
