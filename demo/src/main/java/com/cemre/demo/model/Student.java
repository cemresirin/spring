package com.cemre.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="students")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String name;
    private String department;
}
