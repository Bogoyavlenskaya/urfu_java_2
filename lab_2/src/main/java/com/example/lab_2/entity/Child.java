package com.example.lab_2.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "children")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;


    private String age;

    @ManyToOne
    @JoinColumn(name = "educationalinstitution_id")
    private EducationalInstitution educationalinstitution;

}
