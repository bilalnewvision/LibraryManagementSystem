package com.company.main;

import com.company.librarymanagementsystem.bean.Book;
import com.company.librarymanagementsystem.bean.Librarian;
import com.company.librarymanagementsystem.bean.Student;
import com.company.librarymanagementsystem.services.Library;

import java.util.Scanner;

//import static com.company.librarymanagementsystem.services.Library.loginCode;
import static com.company.librarymanagementsystem.services.Library.studentList;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    static Library library = new Library();

    public static void main(String[] args) {

        Book book0 = new Book(1, "Let us C", "Yashwant Kanetkar", "Programming", 200);
        Book book2 = new Book(3, "Let us Java", "Harman Singh", "Programming", 1100);
        Book book1 = new Book(2, "DS Algo", "Vaibhav Mishra", "Algorithms", 450);
        Library.bookList.add(book0);
        Library.bookList.add(book1);
        Library.bookList.add(book2);

        Student Bilal1 = new Student(1,"Bilal", "0613", "Khurai", 22);
        Student Aman2 = new Student(2, "Aman", "0614", "Bhopal", 23);
        studentList.add(Bilal1);
        studentList.add(Aman2);

        Librarian librarian = new Librarian("Sumit", 101);

        library.loginCode();
    }
}
