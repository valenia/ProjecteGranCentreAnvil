package com.example.projectegrancentre;

public class ClRestaurant
{
    private String id;
    private String name;
    private String descrip;
    private String type;
    private int img;

    public ClRestaurant(String id, String name, String descrip, String type, int img) {
        this.id = id;
        this.name = name;
        this.descrip = descrip;
        this.type = type;
        this.img = img;
    }

    //Getter nd setter Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //Getter nd setter Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Getter nd setter Descrip
    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    //Getter nd setter Type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = descrip;
    }

    //Getter nd setter Img
    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

}
