import java.util.ArrayList;


public class Order{
    private String name;
    private double total;
    private boolean ready;
    private ArrayList<String> items;

    public Order(){
        this.total = 0;
        this.ready = false;
        this.items = new ArrayList<String>();
    }
    public void setName(String name) {
        this.name = name;
    }
    public void addToList(String name, double price){
        this.items.add(name);
        this.total += price;
    }
     public ArrayList<String> getItems(){
        return this.items;
     }
     public double getTotal(){
        return this.total;
     }

     public void setReady() {
        this.ready = true;
    }
    public boolean getReady() {
        return this.ready;
      }
}