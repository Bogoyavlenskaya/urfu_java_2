package com.example.lab_2.controller;


import com.example.lab_2.entity.Parent;
import com.example.lab_2.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/parent")

public class ParentController {

    @Autowired
    ParentService parentService;

    @PostMapping
    public void createNewParent(@RequestBody Parent body){
        parentService.createParent(body);
    }

    @GetMapping
    public ResponseEntity<List> getAllChildren(){
        return ResponseEntity.ok(parentService.getAllParents());
    }
}
