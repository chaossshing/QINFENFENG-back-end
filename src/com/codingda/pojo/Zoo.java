package com.codingda.pojo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private static final Zoo instance = new Zoo();
    private  List<Animal> animals = new ArrayList<>();
    private Zoo() {
        animals.add(new Dog("Small Dog", 2, "male"));
        animals.add(new Dog("1", 2, "male"));
    }

    public static Zoo getInstance() {
        return instance;
    }
    public List<Animal> getAnimals(){
        return this.animals;
    }

    public void setAnimals(List<Animal> animals){
        this.animals = animals;
    }
}
