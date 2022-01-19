package com.example.lab_2.controller;

import com.example.lab_2.dto.ChildDTO;
import com.example.lab_2.entity.Child;
import com.example.lab_2.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/child")
public class ChildController {
    @Autowired
    ChildService childService;

    @PostMapping
    public void createNewChild(@RequestBody Child body){
        childService.createChild(body);
    }

    @GetMapping
    public ResponseEntity<List> getAllChildren(){
        return ResponseEntity.ok(childService.getAllChildren());
    }

    @GetMapping("/change/{id}")
    public void changeAddressAndEducationalInstitution(@RequestBody ChildDTO body, @PathVariable long id){
        childService.changeAddressAndEducationalInstitution(body,id);
    }
}
