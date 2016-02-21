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
    val itemsToHandle = items.filterNot(_.name == "Sulfuras, Hand of Ragnaros")

    for (item <- itemsToHandle) {
      item.sellIn = item.sellIn - 1
      if (item.name.equals("Aged Brie")) {
        handleAgedBrie(item)
      } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
        handleBackstagePass(item)
      } else {
        handleItem(item)
      }
    }
  }

  def handleBackstagePass(item: Item): Unit = {
    if (item.quality < 50) {
      if (item.sellIn > 10) {
        item.quality = item.quality + 1
      } else if (item.sellIn <= 10 && item.sellIn > 5) {
        item.quality = item.quality + 2
      } else if (item.sellIn <= 5 && item.sellIn > 0) {
        item.quality = item.quality + 3
      } else {
        item.quality = 0
      }
    }
  }

  private def handleAgedBrie(item: Item) = {
    if (item.quality < 50) {
      item.quality = item.quality + 1
      if (item.sellIn < 0) {
        item.quality = item.quality + 1
      }
    }
  }

  private def handleItem(item: Item) = {
    if (item.quality > 0) {
      if (item.sellIn > 0) {
        item.quality = item.quality - 1
      } else {
        item.quality = item.quality - 2
      }
    }
  }
}
