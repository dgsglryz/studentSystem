package com.davidguleryuz.studentsystem.service;

import com.davidguleryuz.studentsystem.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);

    public List<Student> getAllStudents();

    Student get(Integer id);

    void delete(Integer id);

    Student update(Student student, Integer id);
}
