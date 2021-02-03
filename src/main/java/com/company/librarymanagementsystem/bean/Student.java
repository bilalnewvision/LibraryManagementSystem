package com.company.librarymanagementsystem.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class Student extends Users implements Serializable {
    public String rollNo, address;
    public int age;
    public static ArrayList<Book> issuedToMe = new ArrayList<>();

    public Student(int id, String name, String rollNo, String address, int age) {
        super(name,"student", id);
        this.rollNo = rollNo;
        this.address = address;
        this.age = age;
    }

    public ArrayList getListOfIssuedBoks(){
        return issuedToMe;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIssuedToMe(Book book){
        issuedToMe.add(book);
    }

    public void returnIssuedBook(Book book){
        issuedToMe.remove(book);
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id='" + id + '\'' +
                "name='" + name + '\'' +
                ", rollNo='" + rollNo + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
