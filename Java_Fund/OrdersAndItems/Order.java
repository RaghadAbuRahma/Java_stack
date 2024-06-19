import java.util.ArrayList;


public class Order{
    private String name;
    public double total;
    private boolean ready;
    private ArrayList<String> items;

    public Order(){
        this.name = "Guest";
        this.items = new ArrayList<String>();
    }
    public Order(String name){
        this.name = "Guest";
        // this.total = 0;
        // this.ready = false;
        this.items = new ArrayList<String>();
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(String name) {
        return this.name;
    }
    public void addItem(Item item){
        this.items.add(item);
    }

    public void setItems(ArrayList<String>items){
        this.items = items;
    }


    public ArrayList<String> getItems(){
        return this.items;
    }
    // public double getTotal(){
    //     return this.total;
    // }

    public void setReady() {
        this.ready = true;
    }
    public boolean getReady() {
        return this.ready;
    }

    public String getStatusMessage(){
        if (this.ready == true){
            return "Your order is ready";
        }
        return "Thank you for waiting. Your order will be ready soon";
    }


    public double getOrderTotal(double price){
        double total = 0;
        for (int i=0; i<this.items.size(); i++){
            total+= this.items.get(i).getPrice();
        }

        
    }
    
    public void display(){


    }

    
}