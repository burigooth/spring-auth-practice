package com.example.SecurityStudy.domain.student;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Entity (name = "Student")
@Table (name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String email;

    private String age;

    public Student(StudentRequestDTO response) {
        this.name = response.name();
        this.email = response.email();
        this.age = response.age();
    }
}
