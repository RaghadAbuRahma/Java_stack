public class Painting extends Art{
    private String paintType; 


    public Painting(String title, String author, String description){
        super(title, author, description);
        this.paintType = paintType; 
    }



    public void setPaintType(String paintType) {
        this.paintType = paintType;
    }
    public String getPaintType() {
        return paintType;
    }


    public  void viewArt(){
        System.out.println("Title: " + this.getTitle() + ",  Author: " + this.getAuthor()+ ",  description: " + this.getDescription() + ",  PaintType: " + this.paintType);
    }

   
   
    
}
