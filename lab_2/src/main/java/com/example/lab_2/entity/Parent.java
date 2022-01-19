package com.example.lab_2.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "parents")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String fullname;

    private String address;



}
