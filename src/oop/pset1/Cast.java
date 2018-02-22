package oop.pset1;

import java.util.List;

public class Cast {
    String name;
    int id;
    int gender;
    private int count;

    public Cast(String name, int id, int gender) {
        this.name = name;
        this.id = id;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int isGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void increaseCount(){
        count++;
    }

    public int whatIsTheCount(){
        return count;
    }
}