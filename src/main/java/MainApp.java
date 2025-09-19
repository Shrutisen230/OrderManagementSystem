import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        try {
            Order order = new Order();
            order.addItem(new Item(101, "Pen", 20));
            order.addItem(new Item(102, "Notebook", 50));
            order.addItem(new Item(103, "Pencil", 10));

            IO.println("---- All Items ----");
            order.viewItems();

            IO.println("\n---- Search Item ----");
            IO.println(order.searchItem("Pen").toString());

            IO.println("\n---- Update Item (ID 101) ----");
            order.updateItem(101, "Marker", 25);
            order.viewItems();

            IO.println("\n---- Delete Item (ID 103) ----");
            order.deleteItem(103);
            order.viewItems();

            IO.println("\n---- Sort Items by Name ----");
            List<Item> listByName = new ArrayList<>(order.getAllItems());
            Collections.sort(listByName, new SortByName());
            listByName.forEach(i -> IO.println(i.toString()));

            IO.println("\n---- Sort Items by Price ----");
            List<Item> listByPrice = new ArrayList<>(order.getAllItems());
            Collections.sort(listByPrice, new SortByPrice());
            listByPrice.forEach(i -> IO.println(i.toString()));

        } catch (Exception e) {
            IO.println("Error: " + e.getMessage());
        }
    }
}
