public class Phone extends Devices{

    public void makeCall(){
        System.out.println("You made a call.");
        battery-=5;
        status();
        
    }

    public void PlayGame(){
        System.out.println("You play a game.");
        battery-=20;
        status();


    }
    public void Charge(){
        System.out.println("You charge your phone");
        battery+=50;
        status();


    }
    

}