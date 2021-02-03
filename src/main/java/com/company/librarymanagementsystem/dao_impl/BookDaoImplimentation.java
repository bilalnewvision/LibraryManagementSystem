package com.company.librarymanagementsystem.dao_impl;

import com.company.librarymanagementsystem.bean.Book;
import com.company.librarymanagementsystem.bean.Student;
import com.company.librarymanagementsystem.dao.BookDao;

import java.util.List;
import java.util.Scanner;

import static com.company.librarymanagementsystem.services.Library.*;

public class BookDaoImplimentation implements BookDao {

    Scanner input = new Scanner(System.in);

    @Override
    public List<Book> viewAllBooks() {
        return bookList;
    }

    @Override
    public void addBook( int id , String name, String author, String subject, int price) {
        Book book = new Book( id , name, author, subject, price);
        bookList.add(book);
        bookCount = bookList.size();
    }

    @Override
    public void searchBookBySubject(String subject) {
        boolean flag = false;
        for (Book b : bookList) {
            if (b.getSubject().equalsIgnoreCase(subject)) {
                System.out.println(b);
                flag = true;
            }
        }

        if (!flag)
            System.out.println("Books not found!!");
    }

    @Override
    public void searchBookByName(String  name) {
        boolean flag = false;
        for (Book b : bookList) {
            if (b.getBookName().equalsIgnoreCase(name) || b.getAuthor().equalsIgnoreCase(name)) {
                System.out.println(b);
                flag = true;
            }
        }

        if (!flag)
            System.out.println("Book with this credential doesn't exists!!");
    }

    public Book searchBookById(String id){
        boolean flag = false;
        for (Book b : bookList) {
            if ( b.getBookId() == Integer.parseInt(id) ) {
                System.out.println(b);
                flag = true;
                return b;
            }
        }

        System.out.println("Book with this Id doesn't exists!!");
        return null;
    }

    @Override
    public void issueBook(Book book) {
        book.setAvailable(false);
        book.issuedTo = studentSession;
        System.out.println("Book issue successfull for "+studentSession.getName());
        studentSession.setIssuedToMe(book);
    }

    public boolean getAvailability(Book book){
        return book.isAvailable();
    }

    @Override
    public void returnBook(Book book) {
        book.setAvailable(true);
        book.setIssuedTo(null);
    }

    @Override
    public int getBookCount() {
        return bookList.size();
    }

    @Override
    public void deleteBook(Book book) {
        bookList.remove(book);
    }
}
