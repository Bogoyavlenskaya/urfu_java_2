package com.example.lab_2.service;

import com.example.lab_2.entity.Parent;
import com.example.lab_2.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {

    @Autowired
    ParentRepository parentRepository;

    public List<Parent> getAllParents(){
        List<Parent> parentList=parentRepository.findAll();
        return parentList;
    }
    public void createParent(Parent parent){
        Parent newParent= Parent.builder()
                .fullname(parent.getFullname())
                .address(parent.getAddress())
                .build();
        parentRepository.save(newParent);
    }
}
