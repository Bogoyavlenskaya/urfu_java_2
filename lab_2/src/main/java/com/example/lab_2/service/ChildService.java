package com.example.lab_2.service;

import com.example.lab_2.dto.ChildDTO;
import com.example.lab_2.entity.Child;
import com.example.lab_2.entity.EducationalInstitution;
import com.example.lab_2.entity.Parent;
import com.example.lab_2.repository.ChildRepository;
import com.example.lab_2.repository.EducationalInstitutionRepository;
import com.example.lab_2.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildService {
    @Autowired
    ChildRepository childRepository;

    @Autowired
    EducationalInstitutionRepository educationalInstitutionRepository;

    @Autowired
    ParentRepository parentRepository;

    public List<Child> getAllChildren(){
        List<Child> childrenList=childRepository.findAll();
        return childrenList;
    }
    public void createChild(Child child){
        EducationalInstitution educationalInstitution=educationalInstitutionRepository.getById(child.getId());
        Child newChild= Child.builder()
                .parent(child.getParent())
                .age(child.getAge())
                .educationalinstitution(educationalInstitution)
                .build();

        childRepository.save(newChild);
    }
    public void changeAddressAndEducationalInstitution(ChildDTO child, Long id){
        EducationalInstitution educationalInstitution=educationalInstitutionRepository.getById(child.getEducationalInstitution_id());
        Parent parentExist=parentRepository.getById(child.getParent_id());
        Child childExist=childRepository.getById(id);
        childExist.setEducationalinstitution(educationalInstitution);
        parentExist.setAddress(child.getAddress());
        childRepository.save(childExist);
    }

}
