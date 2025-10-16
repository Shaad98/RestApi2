package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("/api/v1/students")
public class MainController {

    @Autowired
    public StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id)
    {
        Optional<Student> student2 = studentService.getStudentById(id);
        if (student2.isPresent()) {
            return ResponseEntity.ok(student2.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Student> getAll() {
        List<Student> students = studentService.getAll();
        return students;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        Optional<Student> student2 = studentService.updateStudentById(id, student);
        if (student2.isPresent()) {
            return ResponseEntity.ok(student2.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
       Student student2 = studentService.saveStudent(student);
       return ResponseEntity.status(HttpStatus.CREATED).body(student2);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteById(@PathVariable int id)
    {
        boolean isStudentExist = studentService.deleteStudentById(id);
        if (isStudentExist) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    
}
