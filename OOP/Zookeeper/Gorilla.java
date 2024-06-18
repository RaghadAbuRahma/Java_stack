public class Gorilla extends Mammal {

    public void throwSomething(){
        this.energy-=5;
        System.out.println("gorilla has thrown something");
        
    }
    public void eatBananas(){
        this.energy+=10;
        System.out.println("gorilla eats banana");
        
    }
    public void climb(){
        this.energy-=10;
        System.out.println("gorilla has climbed a tree");
    }
    
}
