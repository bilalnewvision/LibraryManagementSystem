package com.company.librarymanagementsystem.dao;

import com.company.librarymanagementsystem.bean.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentDao {
    public List<Student> getAllStudents();
    public Student getStudent(int id);
    public void updateStudent(Student student);
    public void deleteStudent(Student student);
    public void addStudent(int id, String name, String rollNo, String address, int age);
    public void accountInfo(Student student);
    public ArrayList booksIssuedToMe(Student student);
    public int totalBooksIssued(Student student);
}
