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

class GildedRoseSpec extends WordSpec with Matchers with BeforeAndAfterEach {

  var app: GildedRose = null
  var regular, agedBrie, sulfuras, backstagePass, conjured: Item = null

  override protected def beforeEach() = {
    regular = new Item("regular", 10, 10)
    agedBrie = new Item("Aged Brie", 10, 10)
    sulfuras = new Item("Sulfuras, Hand of Ragnaros", 10, 80)
    backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 20, 20)
    conjured = new Item("Conjured cookie", 10, 10)

    app = new GildedRose(regular, agedBrie, sulfuras, backstagePass, conjured)
  }

  "Gilded Rose" should {

    "lower the sellIn value" in {
      app.updateQuality()

      regular.sellIn should equal(9)
    }

    "lower the quality value" in {
      app.updateQuality()

      regular.quality should equal(9)
    }

    "lower the quality twice as fast when sellIn is 0" in {
      regular.sellIn = 0

      app.updateQuality()

      app.items(0).quality should equal(8)
    }

    "never lower the quality below 0" in {
      regular.quality = 0

      app.updateQuality()

      regular.quality should be <= 0
    }

    "Aged Brie increases quality" in {
      app.updateQuality()

      agedBrie.quality should equal(11)
    }

    "Aged Brie's quality can not be higher than 50" in {
      agedBrie.quality = 50

      app.updateQuality()

      agedBrie.quality should equal(50)
    }

    "Sulfuras, Hand of Ragnaros quality never alters" in {
      app.updateQuality()

      sulfuras.quality should equal(80)
    }

    "Sulfuras, Hand of Ragnaros sellIn never alters" in {
      app.updateQuality()

      sulfuras.sellIn should equal(10)
    }

    "Backstage passes should increase quality by one when more than 10 days are left" in {
      app.updateQuality()

      backstagePass.quality should equal(21)

      app.updateQuality()

      backstagePass.quality should equal(22)
    }

    "Backstage passes should increase quality by two when 10 days are left" in {
      backstagePass.sellIn = 10

      app.updateQuality()

      backstagePass.quality should equal(22)

      app.updateQuality()

      backstagePass.quality should equal(24)
    }

    "Backstage passes should increase quality by three when 5 days are left" in {
      backstagePass.sellIn = 5

      app.updateQuality()

      backstagePass.quality should equal(23)

      app.updateQuality()

      backstagePass.quality should equal(26)
    }

    "Backstage passes should drop quality zero when no days are left" in {
      backstagePass.sellIn = 0

      app.updateQuality()

      backstagePass.quality should equal(0)
    }

    "Conjured items degrade twice as fast" in {
      app.updateQuality()

      conjured.quality should equal(8)
    }
  }
}
