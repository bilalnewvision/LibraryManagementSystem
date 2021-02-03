package com.company.librarymanagementsystem.dao_impl;

import com.company.librarymanagementsystem.bean.Book;
import com.company.librarymanagementsystem.bean.Student;
import com.company.librarymanagementsystem.dao.StudentDao;
import static com.company.librarymanagementsystem.services.Library.studentCount;
import static com.company.librarymanagementsystem.services.Library.studentList;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImplementation implements StudentDao {

    //public static List<Student> students;

    @Override
    public List<Student> getAllStudents() {
        return studentList;
    }

    @Override
    public Student getStudent(int id) {
        return studentList.get(id-1);
    }

    @Override
    public void updateStudent(Student student) {
        studentList.get(student.getId()).setName(student.getName());
        System.out.println("Student: Roll No " + student.getRollNo() + ", updated in the database");
    }

    @Override
    public void deleteStudent(Student student) {
        studentList.remove(student.getId()-1);
        System.out.println("Student: Roll No " + student.getRollNo() + ", deleted from database");
    }

    @Override
    public void addStudent(int id, String name, String rollNo, String address, int age) {
        Student student = new Student(id, name, rollNo, address, age);
        studentList.add(student);
        studentCount = studentList.size();
    }

    @Override
    public void accountInfo(Student student) {
        System.out.println(student);
        System.out.println("Books i have :");
        System.out.println(booksIssuedToMe(student));
    }

    @Override
    public ArrayList booksIssuedToMe(Student student) {
        return student.getListOfIssuedBoks();
    }

    @Override
    public int totalBooksIssued(Student student) {
        return student.getListOfIssuedBoks().size();
    }
}
