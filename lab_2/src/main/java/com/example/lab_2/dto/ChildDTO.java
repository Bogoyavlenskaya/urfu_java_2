package com.example.lab_2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChildDTO {
    private String address;
    private Long parent_id;
    private Long educationalInstitution_id;

    public ChildDTO(String address, Long parent_id, Long educationalInstitution_id) {
        this.address = address;
        this.parent_id = parent_id;
        this.educationalInstitution_id = educationalInstitution_id;
    }
}
