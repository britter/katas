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

    "never lower the quality below 0" in {
      val items = Array[Item](new Item("foo", 0, 0))

      val app = new GildedRose(items)
      app.updateQuality()

      app.items(0).quality should be <= 0
    }

    "Aged Brie increases quality" in {
      val items = Array[Item](new Item("Aged Brie", 10, 10))

      val app = new GildedRose(items)
      app.updateQuality()

      app.items(0).quality should equal(11)
    }

    "Aged Brie's quality can not be higher than 50" in {
      val items = Array[Item](new Item("Aged Brie", 10, 50))

      val app = new GildedRose(items)
      app.updateQuality()

      app.items(0).quality should equal(50)
    }

    "Sulfuras, Hand of Ragnaros quality never alters" in {
      val items = Array[Item](new Item("Sulfuras, Hand of Ragnaros", 10, 80))

      val app = new GildedRose(items)
      app.updateQuality()

      app.items(0).quality should equal(80)
    }

    "Sulfuras, Hand of Ragnaros sellIn never alters" in {
      val items = Array[Item](new Item("Sulfuras, Hand of Ragnaros", 10, 80))

      val app = new GildedRose(items)
      app.updateQuality()

      app.items(0).sellIn should equal(10)
    }

    "Backstage passes should increase quality by one when more than 10 days are left" in {
      val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 20, 20))

      val app = new GildedRose(items)
      app.updateQuality()

      app.items(0).quality should equal(21)

      app.updateQuality()

      app.items(0).quality should equal(22)
    }

    "Backstage passes should increase quality by two when 10 days are left" in {
      val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20))

      val app = new GildedRose(items)
      app.updateQuality()

      app.items(0).quality should equal(22)

      app.updateQuality()

      app.items(0).quality should equal(24)
    }

    "Backstage passes should increase quality by three when 5 days are left" in {
      val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20))

      val app = new GildedRose(items)
      app.updateQuality()

      app.items(0).quality should equal(23)

      app.updateQuality()

      app.items(0).quality should equal(26)
    }

    "Backstage passes should drop quality zero when no days are left" in {
      val items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20))

      val app = new GildedRose(items)
      app.updateQuality()

      app.items(0).quality should equal(0)
    }
  }
}
