package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;

    public Optional<Student> getStudentById(int id)
    {
        return studentRepository.findById(id);
    }

    public List<Student> getAll()
    {
        return studentRepository.findAll();
    }

    public Boolean deleteStudentById(int id)
    {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public Optional<Student> updateStudentById(int id,Student student)
    {
        Optional<Student> student2 = studentRepository.findById(id);

        if (student2.isPresent()) {
            student2.get().setName(student.getName()!=null?student.getName():student2.get().getName());
            student2.get().setCity(student.getCity()!=null?student.getCity():student2.get().getCity());
        }
        return student2;
    }

    public Student saveStudent(Student student)
    {
        return studentRepository.save(student);
    }
}
