package com.example.lab_2.controller;


import com.example.lab_2.entity.EducationalInstitution;
import com.example.lab_2.service.EducationalInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/educationalInstitution")
public class EducationalInstitutionController {
    @Autowired
    EducationalInstitutionService educationalInstitutionService;

    @PostMapping
    public void createNewParent(@RequestBody EducationalInstitution body){
        educationalInstitutionService.createEducationalInstitution(body);
    }

    @GetMapping
    public ResponseEntity<List> getAllChildren(){
        return ResponseEntity.ok(educationalInstitutionService.getAllEducationalInstitution());
    }
}
