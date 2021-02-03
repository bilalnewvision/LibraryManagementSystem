package com.company.librarymanagementsystem.bean;

import java.io.Serializable;

public class Book implements Serializable {

    public int bookId;
    public String bookName;
    public String author;
    public String subject;
    public int price;
    public boolean isAvailable;
    public Student issuedTo;

    public Book(){}

    public Book(int bookId, String bookName, String author, String subject, int price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.subject = subject;
        this.price = price;
        this.isAvailable = true;
        this.issuedTo = null;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Student getIssuedTo() {
        return issuedTo;
    }

    public void setIssuedTo(Student issuedTo) {
        this.issuedTo = issuedTo;
    }

    @Override
    public String toString() {
        String name = (issuedTo==null) ? "None" : issuedTo.getName();
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", subject='" + subject + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                ", issuedTo=" + name +
                "}\n";
    }
}
