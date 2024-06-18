import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        Item item1 = new Item( "mocha", 12.5);
        Item item2 = new Item("latte", 9.5);
        Item item3 = new Item("drip coffee", 11.5);
        Item item4 = new Item("cappuccino", 15);
        CoffeeKiosk kiosk1 = new CoffeeKiosk(); 

    
        Order order1 = new Order();
        Order order2 = new Order();

        Order order3 = new Order("Jimmy");
        Order order4 = new Order("Sam");
        Order order5 = new Order("Noah");
        order1.addItem(item3);
        order1.addItem(item1);
        order2.addItem(item2);
        order2.addItem(item4);
        order3.addItem(item1);
        order3.addItem(item2);
        order4.addItem(item2);
        order4.addItem(item3);
        order5.addItem(item1);
        order5.addItem(item4);
        order5.setReady(false);
        // System.out.println(order5.getStatusMessage());



        // order1.setReady(true);
        // order1.display();
        // System.out.println(order1.getStatusMessage());
        // System.out.println("Your Total is:" + order1.getOrderTotal());
        // order1.display();
        // order2.display();
        // order3.display();
        // order4.display();
        // order5.display();
        kiosk1.addMenuItem("MilkShake", 9.50);
        kiosk1.addMenuItem("Mojito", 7.00);
        kiosk1.addMenuItem("Espresso", 5.00);
        kiosk1.addMenuItem("Mocha", 10.00);
        // kiosk1.displayMenu();
        kiosk1.newOrder();












        // order2.addToList(item1.getName(), item1.getPrice());
        // order2.addToList(item4.getName(), item4.getPrice());
        // order4.addToList(item2.getName(), item2.getPrice());
        // for (int i = 0 ; i<2 ; i++){
        //     order4.addToList(item2.getName(), item2.getPrice());
        // }
        // order1.setReady();
        // order3.setReady();
        
        // // Application Simulations
        
        // // Use this example code to test various orders' updates
        // System.out.printf("Total: %s\n", order1.getTotal());
        // System.out.printf("Ready: %s\n", order1.getReady());
        // System.out.println(order1);
        // System.out.println(order1.getTotal());        
        // System.out.println(order2.getItems() + "total is:" + order2.getTotal());
        // System.out.printf("Name: %s\n", order1.name);
        // System.out.println(order4.getItems() + "total is:" + order4.getTotal());
        
        // System.out.println(order1.getReady());



    }
}
