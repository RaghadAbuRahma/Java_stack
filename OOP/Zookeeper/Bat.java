public class Bat extends Mammal {
    protected int energy = 300;

    public void fly(){
        this.energy-=50;
        System.out.println(" the bat is airborne");
    }
    public void eatHumans(){
        this.energy+=25;
        System.out.println(" the bat eats humans");
    }
    public void attackTown(){
        this.energy-=100;
        System.out.println(" the bat attacks towns");
    }
    public int displayEnergy(){
        System.out.println(this.energy);
        return this.energy;
    }
    
}
