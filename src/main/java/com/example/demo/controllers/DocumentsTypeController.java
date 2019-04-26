package com.example.demo.controllers;

import com.example.demo.entities.DocumentsType;
import com.example.demo.services.Interfaces.Serviceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/docs")
public class DocumentsTypeController {
    private Serviceable<DocumentsType> documentsTypeService;

    @Autowired
    public DocumentsTypeController(Serviceable<DocumentsType> countryService) {
        this.documentsTypeService = countryService;
    }

    @GetMapping
    public Set<DocumentsType> getDocumentsTypes(){

        return documentsTypeService.getAll();
    }
}
