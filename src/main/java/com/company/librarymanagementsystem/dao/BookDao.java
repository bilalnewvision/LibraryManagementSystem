package com.company.librarymanagementsystem.dao;

import com.company.librarymanagementsystem.bean.Book;
import com.company.librarymanagementsystem.bean.Student;

import java.util.List;

public interface BookDao {
    public List<Book> viewAllBooks();
    public void addBook(int id, String name, String author, String subject, int price);
    public void searchBookBySubject(String subject);
    public void searchBookByName(String name);
    public Book searchBookById(String id);
    public void issueBook(Book book);
    public void returnBook(Book book);
    public int getBookCount();
    public void deleteBook(Book book);

}
