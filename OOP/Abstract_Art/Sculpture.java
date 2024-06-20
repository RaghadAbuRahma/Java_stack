public class Sculpture extends Art {
    private String material; 

    public Sculpture(String title, String author, String description){
        super(title, author, description);
        this.material = material; 
    }


    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    

    public  void viewArt(){
        System.out.println("Title: " + this.getTitle() + ",  Author: " + this.getAuthor()+ ",  description: " + this.getDescription() + ",  Material: " + this.getMaterial());
    }

}
