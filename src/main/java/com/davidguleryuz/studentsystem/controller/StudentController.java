package com.davidguleryuz.studentsystem.controller;

import com.davidguleryuz.studentsystem.model.Student;
import com.davidguleryuz.studentsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/add")
    public String add(@RequestBody Student student)
    {
        studentService.saveStudent(student);
        return "New student is added";
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @GetMapping("/get")
    public ResponseEntity<Student> get(@PathVariable Integer id)
    {
        try {
            Student student = studentService.get(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        }catch (NoSuchElementException e)
        {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Student> update(@RequestBody Student student,@PathVariable Integer id)
    {
        try {
            Student existingStudent=studentService.get(id);
            studentService.saveStudent(existingStudent);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public String delete(Integer id)
    {
        studentService.delete(id);
        return "Deleted Student with id: "+id;
    }
}
