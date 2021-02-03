package com.company.librarymanagementsystem.services;

import com.company.librarymanagementsystem.bean.Book;
import com.company.librarymanagementsystem.bean.Student;
import com.company.librarymanagementsystem.dao.BookDao;
import com.company.librarymanagementsystem.dao.StudentDao;
import com.company.librarymanagementsystem.dao_impl.BookDaoImplimentation;
import com.company.librarymanagementsystem.dao_impl.StudentDaoImplementation;
import com.company.main.Main;

import java.util.LinkedList;
import java.util.Scanner;


public class Library {

    public static LinkedList<Book> bookList = new LinkedList<>();
    public static LinkedList<Student> studentList = new LinkedList<>();

    public static int bookCount = bookList.size();
    public static int studentCount = studentList.size();

    public static Student studentSession;
    public static final int MAX_NO_OF_BOOKS = 5;

    StudentDao studentDao = new StudentDaoImplementation();
    BookDao bookDao = new BookDaoImplimentation();

    Scanner input = new Scanner(System.in);

    String choice;

    public void loginCode() {
        System.out.println("Welcome to the Library Management System");
        System.out.println("---------------------------------------------------------------------------------");

        while (true) {
            System.out.println("If you are librarian enter 1, or enter 2 if student: ");
            Scanner sc = new Scanner(System.in);
            int who = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the user name and password to login - ");
            System.out.print("User Name : ");
            String name = sc.nextLine();
            System.out.print("Password : ");
            String pwd = sc.nextLine();
            if (name.equalsIgnoreCase("Sumit") && pwd.equals("101") && who == 1) {
                System.out.println("Congratulations " + name + " !!! You are logged in");
                Library lib = new Library();
                lib.showMenuForLibrarian();
            }
            else if(who == 2){
                for(Student student : studentList){
                    if(name.equalsIgnoreCase(student.getName()) && Integer.parseInt(pwd) == student.getId()) {
                        System.out.println("Congratulations " + student.getName() + " !!! You are logged in");
                        studentSession = student;
                        showMenuForStudents();
                    }
                }
            }
            else {
                System.out.println("Sorry! wrong credentials entered! Try again");
            }

        }
    }

    public void showMenuForLibrarian() {
        System.out.println("1, add new books");
        System.out.println("2, view all books");
        System.out.println("3, search for a book");
        System.out.println("4, delete books");
        System.out.println("5, the number of books");
        System.out.println("6, Add a student");
        System.out.println("7, Search for a student");
        System.out.println("8, View all registered students");
        System.out.println("#, return to the main menu");
        System.out.println("$, log out of the sysetm");
        System.out.println("@, exit the system");
        while (true) {
            System.out.print("Please enter your selection:");
            choice = input.nextLine();
            switch (choice) {
                case "1" -> addBookInList();
                case "2" -> viewAllBooks();
                case "3" -> searchBook();
                case "4" -> delBook();
                case "5" -> getBookCount();
                case "6" -> addStudent();
                case "7" -> searchForAStudent();
                case "8" -> getStudentList();
                case "@" -> quitSystem();
                case "#" -> showMenuForLibrarian();
                case "$" -> loginCode();
                default -> illegalInput();
                }
            }
    }

    private void getStudentList() {
        for(Student student : studentDao.getAllStudents()){
            System.out.println(student);
        }
    }

    private void searchForAStudent() {
        System.out.println("Enter student id: ");
        String id = input.nextLine();
        System.out.println(studentDao.getStudent(Integer.parseInt(id)));
    }

    private void quitSystem(){
        System.out.println("The system is quitting!");
        System.exit(0);
    }

    private void addStudent() {
        System.out.println("Please enter all the fields required for the Student correctly: ");
        System.out.println("Student name : ");
        String name = input.nextLine();
        System.out.println("Student address : ");
        String address = input.nextLine();
        System.out.println("Student RollNo : ");
        String rollNo = input.nextLine();
        System.out.println("Age : ");
        while (!input.hasNextInt()) {//Will run till an integer input is found
            System.out.println("Only number input is allowed!");
            System.out.print("Price: ");
            input.next();
        }
        int age = input.nextInt();
        input.nextLine();
        studentDao.addStudent(studentList.size()+1, name, address, rollNo, age);
        System.out.println("Student created successfully!!\nYour Id is "+studentCount+". Please remember it");
    }

    public void addBookInList() {
        System.out.println("Please enter all the fields required for the book correctly: ");
        System.out.println("Book name : ");
        String name = input.nextLine();
        System.out.println("Author name : ");
        String author = input.nextLine();
        System.out.println("subject name : ");
        String subject = input.nextLine();
        System.out.println("Price : ");
        while (!input.hasNextInt()) {//Will run till an integer input is found
            System.out.println("Only number input is allowed!");
            System.out.print("Price: ");
            input.next();
        }
        int price = input.nextInt();
        input.nextLine();

        bookDao.addBook(bookDao.getBookCount() + 1, name, author, subject, price);
        System.out.println("Book added successfully with id "+bookDao.getBookCount());
    }

    public void viewAllBooks() {
        for (Book b :bookDao.viewAllBooks() ) {
            System.out.println(b);
        }
    }

    public void searchBook() {
        System.out.print("Enter the name or author of the book: ");
        String name = input.nextLine();
        bookDao.searchBookByName(name);
    }

    public void getBookCount() {
        System.out.println(bookDao.getBookCount());
//        System.out.println("There are a total of " + bookList.size() + " books available in library");
//        bookCount = bookList.size();
    }

    public void delBook() {
        System.out.print("Enter the id of the book: ");
        String id = input.nextLine();
        Book book =  bookDao.searchBookById(id);
        if( book != null ) {
            System.out.print("Do you really want to delete this book (Y/N): ");
            if (input.nextLine().equalsIgnoreCase("Y")) {
                bookDao.deleteBook(book);
                System.out.println("The book is successfully removed from library");
            } else
                System.out.println("Not Deleted");
        }
    }

    public void showMenuForStudents() {
        String choice;
        System.out.println("1, view all books");
        System.out.println("2, search books by subject");
        System.out.println("3, search book by name/author");
        System.out.println("4, request issue book");
        System.out.println("5, return book");
        System.out.println("6, see your account");
        System.out.println("#, return to the main menu");
        System.out.println("$, log out of the sysetm");
        System.out.println("@, exit the system");
        while (true) {
            System.out.print("Please enter your selection:");
            choice = input.nextLine();
            switch (choice) {
                case "1" -> viewAllBooks();
                case "2" -> searchBookBySubject();
                case "3" -> searchBook();
                case "4" -> requestIssueBook();
                case "5" -> returnBook();
                case "6" -> accountInfo();
                case "@" -> quitSystem();
                case "#" -> showMenuForStudents();
                case "$" -> loginCode();
                default -> illegalInput();
            }
        }
    }

    private void illegalInput(){
        System.out.println("illegal selected input, please re-enter - (y / n)!");
        choice = input.nextLine();
        if ("y".equals(choice)) {
            showMenuForLibrarian();
        } else {
            System.out.println("System Security quit!");
            System.exit(0);
        }
    }

    private void accountInfo() {
        //System.out.println(studentSession);
        studentDao.accountInfo(studentSession);
    }

    private void returnBook() {
        System.out.println("Please enter the Book ID of the book you want to return: ");
        String bookId = input.nextLine();
        Book book = bookDao.searchBookById(bookId);
        if (book != null) {
            System.out.println("Do you want the above book to be returned? (Y/N)");
            if (input.nextLine().equalsIgnoreCase("y")) {
                bookDao.returnBook(book);
                return;
            }
            System.out.println("See you again!!");
        }
    }

    private void requestIssueBook() {
        if(studentDao.totalBooksIssued(studentSession) >= MAX_NO_OF_BOOKS){
            System.out.println("Issue limit reached. try after returning your book");
            return;
        }
        System.out.println("Please enter the Book ID of the book you want to issue: ");
        String bookId = input.nextLine();
        Book book = bookDao.searchBookById(bookId);

        if( ! book.isAvailable() ){
            System.out.println("Sorry!! The book is currently issued to someone else.");
            return;
        }
        System.out.println("Do you want the above book to be issued? (Y/N)");
        if(input.nextLine().equalsIgnoreCase("y")){
            bookDao.issueBook(book);
        }
    }

    private void searchBookBySubject() {
        System.out.print("Enter the subject: ");
        String name = input.nextLine();
        bookDao.searchBookBySubject(name);
    }
}
