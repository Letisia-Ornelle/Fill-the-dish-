package home.home2;

public class Recipe {
    private String name;
    private String imgSrc;
    private String description;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getImgSrc(){
        return imgSrc;
    }

    public void setImgSrc(String imgSrc){
        this.imgSrc = imgSrc;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
