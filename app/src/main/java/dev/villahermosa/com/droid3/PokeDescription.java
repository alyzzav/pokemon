package dev.villahermosa.com.droid3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Villahermosa on 7/9/2017.
 */

public class PokeDescription {
    private String name;
    private String img;
    private String weight;
    private String height;
    private String base_experience;
    private ArrayList type = new ArrayList();

    public PokeDescription(){}

    public PokeDescription(String name, String img, String weight, String height, String base_experience, ArrayList type) {
        this.name = name;
        this.img = img;
        this.weight = weight;
        this.height = height;
        this.base_experience = base_experience;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(String base_experience) {
        this.base_experience = base_experience;
    }

    public ArrayList getType() {
        return type;
    }

    public void setType(ArrayList type) {
        this.type = type;
    }
}
