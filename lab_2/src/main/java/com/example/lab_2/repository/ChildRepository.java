package com.example.lab_2.repository;

import com.example.lab_2.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepository extends JpaRepository<Child,Long> {
}
