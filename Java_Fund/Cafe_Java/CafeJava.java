public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffePrice = 2.5;
        double lattePrice = 4;
        double cappuccinoPrice = 3.5;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = true;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = false;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        // System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //

        // Cindhuri order 
        System.out.println(isReadyOrder1);


        // Sam Order
        if(isReadyOrder4 == true ){
            System.out.println(customer4 + readyMessage);
        }
        else {
            System.out.println(customer4 + pendingMessage);
        }

        System.out.println(displayTotalMessage + cappuccinoPrice);

        // Sam just ordered 2 lattes 
        System.out.println(displayTotalMessage + 2*lattePrice);

        if (isReadyOrder4 == true ){
                System.out.println(customer2 + readyMessage);
            }
            else {
                System.out.println(customer2 + pendingMessage);
            }


        // Jimmy Order
        System.out.println(displayTotalMessage+ (lattePrice-dripCoffePrice));





    














    }
}
