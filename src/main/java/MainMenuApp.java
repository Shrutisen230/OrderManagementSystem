import java.util.*;

public class MainMenuApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Order order = new Order();
        int choice;

        do {
            IO.println("\n==== Order Management Menu ====");
            IO.println("1. Add Item");
            IO.println("2. View All Items");
            IO.println("3. Update Item");
            IO.println("4. Delete Item");
            IO.println("5. Search Item by Name");
            IO.println("6. Sort Items by Name");
            IO.println("7. Sort Items by Price");
            IO.println("0. Exit");
            IO.println("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        IO.println("Enter Item ID: ");
                        int id = sc.nextInt(); sc.nextLine();
                        IO.println("Enter Item Name: ");
                        String name = sc.nextLine();
                        IO.println("Enter Price: ");
                        double price = sc.nextDouble();
                        order.addItem(new Item(id, name, price));
                        IO.println("Item added successfully.");
                        break;

                    case 2:
                        IO.println("--- All Items ---");
                        order.viewItems();
                        break;

                    case 3:
                        IO.println("Enter Item ID to update: ");
                        int uid = sc.nextInt(); sc.nextLine();
                        IO.println("Enter new Name: ");
                        String newName = sc.nextLine();
                        IO.println("Enter new Price: ");
                        double newPrice = sc.nextDouble();
                        order.updateItem(uid, newName, newPrice);
                        IO.println("Item updated.");
                        break;

                    case 4:
                        IO.println("Enter Item ID to delete: ");
                        int did = sc.nextInt();
                        order.deleteItem(did);
                        IO.println("Item deleted.");
                        break;

                    case 5:
                        IO.println("Enter Item Name to search: ");
                        String sname = sc.nextLine();
                        Item found = order.searchItem(sname);
                        IO.println("Found: " + found);
                        break;

                    case 6:
                        IO.println("--- Items Sorted by Name ---");
                        List<Item> listName = new ArrayList<>(order.getAllItems());
                        Collections.sort(listName, new SortByName());
                        listName.forEach(i -> IO.println(i.toString()));
                        break;

                    case 7:
                        IO.println("--- Items Sorted by Price ---");
                        List<Item> listPrice = new ArrayList<>(order.getAllItems());
                        Collections.sort(listPrice, new SortByPrice());
                        listPrice.forEach(i -> IO.println(i.toString()));
                        break;

                    case 0:
                        IO.println("Exiting...");
                        break;

                    default:
                        IO.println("Invalid choice!");
                }
            } catch (Exception e) {
                IO.println("Error: " + e.getMessage());
            }

        } while (choice != 0);

        sc.close();
    }
}
