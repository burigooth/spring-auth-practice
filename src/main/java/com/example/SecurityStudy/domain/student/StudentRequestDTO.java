package com.example.SecurityStudy.domain.student;

public record StudentRequestDTO(String name, String email, String age) {
    public StudentRequestDTO(Student student){
        this(student.getName(), student.getEmail(), student.getAge());
    }
}
