package com.company.librarymanagementsystem.bean;

public class Users {
    String name;
    String profession;
    int id;

    public Users(String name, String profession, int id) {
        this.name = name;
        this.profession = profession;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
