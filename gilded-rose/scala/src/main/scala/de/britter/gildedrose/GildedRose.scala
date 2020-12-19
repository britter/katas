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

class GildedRose(val items: Item*) {

  def updateQuality() {
    for (item <- items) {
      case Item("Sulfuras, Hand of Ragnaros", _, _) =>
      case item@Item("Aged Brie", sellIn, quality) if quality < 50 && sellIn < 0 => 
        item.sellIn -= 1
        item.quality += 2
      case item@Item("Aged Brie", sellIn, quality) if quality < 50 && sellIn >= 0 => 
        item.sellIn -= 1
        item.quality += 1
      case item@Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) if quality < 50 && sellIn > 10 =>
        item.sellIn -= 1
        item.quality += 1
      case item@Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) if quality < 50 && sellIn <= 10 && item.sellIn > 5 =>
        item.sellIn -= 1
        item.quality += 2
      case item@Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) if quality < 50 && sellIn <= 5 && item.sellIn > 0 =>
        item.sellIn -= 1
        item.quality += 3
      case item@Item("Backstage passes to a TAFKAL80ETC concert", _, _) =>
        item.sellIn -= 1
        item.quality = 0
      case item@Item(name, sellIn, quality) if name.startsWith("Conjured") && quality > 0 && sellIn > 0 =>
        item.sellIn -= 1
        item.quality -= 2
      case item@Item(name, sellIn, quality) if name.startsWith("Conjured") && quality > 0 =>
        item.sellIn -= 1
        item.quality -= 4
      case item@Item(_, sellIn, quality) if quality > 0 && sellIn > 0 =>
        item.sellIn -= 1
        item.quality -= 1
      case item@Item(_, sellIn, quality) if quality > 0 =>
        item.sellIn -= 1
        item.quality -= 2
    }
  }

}
