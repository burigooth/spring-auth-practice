package com.example.SecurityStudy.domain.student;

public record StudentResponseDTO(String name, String email, String age) {
    public StudentResponseDTO(Student student){
        this(student.getName(), student.getEmail(), student.getAge());
    }
}
