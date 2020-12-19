import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    private static List<Item> items = null;

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        for (int i = 0; i < 20; i++) {
            updateQuality();
            System.out.println();
        }
    }

    public static void updateQuality() {
        for (Item item : items) {
            if ("Sulfuras, Hand of Ragnaros".equals(item.getName())) {
                continue;
            }
            if (("Aged Brie".equals(item.getName()))) {
                increaseQuality(item);
            } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
                increaseQuality(item);

                if (item.getSellIn() < 11) {
                    increaseQuality(item);
                }

                if (item.getSellIn() < 6) {
                    increaseQuality(item);
                }
            } else {
                decreaseQuality(item);
            }

            item.setSellIn(item.getSellIn() - 1);
            System.out.println("SellIn -1: " + dump(item));

            if (item.getSellIn() < 0) {
                if ("Aged Brie".equals(item.getName())) {
                    increaseQuality(item);
                } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
                    item.setQuality(0);
                    System.out.println("Quality -> 0: " + dump(item));
                } else {
                    decreaseQuality(item);
                }
            }
        }
    }

    private static void decreaseQuality(final Item item) {
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
            System.out.println("Quality -1: " + dump(item));
        }
    }
    
    private static void increaseQuality(final Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
            System.out.println("Quality +1: " + dump(item));
        }
    }

    private static String dump(Item item) {
        return String.format("[name:%s;sellIn:%s;quality:%s]", item.name, item.sellIn, item.quality);
    }
}