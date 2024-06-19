import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        Item item1 = new Item("String name", 5);
        item1.setName("mocha");
        item1.setPrice(12.5);
        Item item2 = new Item();
        item2.setName("latte");
        item2.setPrice(9.5);
        Item item3 = new Item();
        item3.setName("drip coffee");
        item3.setPrice(11.5);
        Item item4 = new Item();
        item4.setName("cappuccino");
        item4.setPrice(15);

    
        Order order1 = new Order();
        order1.setName("Cindhuri");
        Order order2 = new Order();
        order2.setName("Noah");
        Order order3 = new Order();
        order3.setName("Jimmy");
        Order order4 = new Order();
        order4.setName("Sam");

        order2.addToList(item1.getName(), item1.getPrice());
        order2.addToList(item4.getName(), item4.getPrice());
        order4.addToList(item2.getName(), item2.getPrice());
        for (int i = 0 ; i<2 ; i++){
            order4.addToList(item2.getName(), item2.getPrice());
        }
        order1.setReady();
        order3.setReady();
        
        // Application Simulations
        
        // Use this example code to test various orders' updates
        System.out.printf("Total: %s\n", order1.getTotal());
        System.out.printf("Ready: %s\n", order1.getReady());
        System.out.println(order1);
        System.out.println(order1.getTotal());        
        System.out.println(order2.getItems() + "total is:" + order2.getTotal());
        System.out.printf("Name: %s\n", order1.name);
        System.out.println(order4.getItems() + "total is:" + order4.getTotal());
        
        System.out.println(order1.getReady());



    }
}
