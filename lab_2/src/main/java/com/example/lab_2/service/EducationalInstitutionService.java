package com.example.lab_2.service;

import com.example.lab_2.entity.EducationalInstitution;
import com.example.lab_2.repository.EducationalInstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationalInstitutionService {

    @Autowired
    EducationalInstitutionRepository educationalInstitutionRepository;

    public List<EducationalInstitution> getAllEducationalInstitution(){
        List<EducationalInstitution> educationalInstitutionList=educationalInstitutionRepository.findAll();
        return educationalInstitutionList;
    }
    public void createEducationalInstitution(EducationalInstitution educationalInstitution){
        EducationalInstitution newEducationalInstitution= EducationalInstitution.builder()
                .address(educationalInstitution.getAddress())
                .number(educationalInstitution.getNumber())
                .build();
        educationalInstitutionRepository.save(newEducationalInstitution);
    }
}
