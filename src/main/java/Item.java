public class Item {
    private int itemId;
    private String itemName;
    private double price;

    public Item(int itemId, String itemName, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
    }

    public int getItemId() { return itemId; }
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }

    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "[" + itemId + " - " + itemName + " - ₹" + price + "]";
    }

    @Override
    public int hashCode() {
        return itemId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Item)) return false;
        Item other = (Item) obj;
        return this.itemId == other.itemId;
    }
}
