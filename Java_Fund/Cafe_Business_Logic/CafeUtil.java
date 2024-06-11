import java.util.ArrayList;

public class CafeUtil {
    public int getStreakGoal(){
    int sum = 0; 
    for (int i =1; i<=10; i++ ){
        sum+=i;
    }


    System.out.println(sum);
    return sum;
}
    
    public double getOrderTotal(double[] prices){
    double sum=0.0;
    for(int i=0; i<prices.length; i++){
        sum+= prices[i];
    }
        System.out.println(sum);
        return sum;
    }

    public void displayMenu(ArrayList<String> menuItems){
        for (int i=0; i<menuItems.size(); i++){
            System.out.println(i + " " + menuItems.get(i));

        }
    }

    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String username = System.console().readLine();
        customers.add(username);
        System.out.println("Hello " + username);


        
    }


    

}