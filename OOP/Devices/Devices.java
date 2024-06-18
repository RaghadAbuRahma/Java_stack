public class Devices{
    protected int battery = 100;

    // public int getBattery() {
    //     return battery;
    // }

    // public void setBattery(int battery) {
    //     this.battery = battery;
    // } 
    
    public void status(){
        System.out.println("Battery remaining: " + this.battery);

    }

}