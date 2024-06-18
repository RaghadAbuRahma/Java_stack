import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;


    


    public CoffeeKiosk(){
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();


    }

    public void addMenuItem(String name, double price ){
        Item item = new Item(name, price);
        menu.add(item);
        item.setIndex(menu.indexOf(item));
    }


    public void displayMenu(){
        for (Item item : menu ){
        System.out.println(item.getIndex() + " " + item.getName() + " " + "$" + item.getPrice());
        }
    }


    public void newOrder() {
        
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
    	// Your code:
        // Create a new order with the given input string
        // Show the user the menu, so they can choose items to add.
        Order newOrder = new Order(name);
        orders.add(newOrder);
        displayMenu();

    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            // Get the item object from the menu, and add the item to the order
            // Ask them to enter a new item index or q again, and take their input
            newOrder.addItem(menu.get(Integer.parseInt(itemNumber)));
            System.out.println("Please enter another item index or q to quit:");
            itemNumber = System.console().readLine();
        }

        // After you have collected their order, print the order details 
        newOrder.display();

    }













}

