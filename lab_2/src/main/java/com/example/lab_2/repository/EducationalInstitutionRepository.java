package com.example.lab_2.repository;

import com.example.lab_2.entity.EducationalInstitution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationalInstitutionRepository extends JpaRepository<EducationalInstitution,Long> {
}
