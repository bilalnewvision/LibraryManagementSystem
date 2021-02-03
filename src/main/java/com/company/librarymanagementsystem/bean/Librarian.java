package com.company.librarymanagementsystem.bean;

public class Librarian extends Users{

    //    String name;
    //    int id;

    public Librarian(String name, int id) {
        super(name, "Librarian", id);
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
}
