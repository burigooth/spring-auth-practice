package com.example.SecurityStudy.controllers;

import com.example.SecurityStudy.repository.StudentRepository;
import com.example.SecurityStudy.domain.student.Student;
import com.example.SecurityStudy.domain.student.StudentRequestDTO;
import com.example.SecurityStudy.domain.student.StudentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @GetMapping
    public ResponseEntity <List<StudentResponseDTO>> getStudents() {
        var students = repository.findAll();
        var studentsDTO = students.stream().map(StudentResponseDTO::new).toList();
        return ResponseEntity.ok(studentsDTO);
    }

    @PostMapping
    @Transactional
    public ResponseEntity createStudent(@RequestBody StudentRequestDTO response, UriComponentsBuilder uriBuilder){
        var student = new Student(response);
        repository.save(student);

        var uri = uriBuilder.path("/student/{id}").buildAndExpand(student.getId()).toUri();

        return ResponseEntity.created(uri).body(new StudentRequestDTO(student));
    }
}
