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

package de.britter.gildedrose

import org.scalatest._

class GildedRoseSpec extends WordSpec with Matchers {

  "Gilded Rose" should {

    "lower the sellIn value" in {
      val items = Array[Item](new Item("foo", 10, 10))

      val app = new GildedRose(items)
      app.updateQuality()

      app.items(0).sellIn should equal(9)
    }

    "lower the quality value" in {
      val items = Array[Item](new Item("foo", 10, 10))

      val app = new GildedRose(items)
      app.updateQuality()

      app.items(0).quality should equal(9)
    }

    "lower the quality twice as fast when sellIn is 0" in {
      val items = Array[Item](new Item("foo", 0, 10))

      val app = new GildedRose(items)
      app.updateQuality()

      app.items(0).quality should equal(8)
    }
  }
}
