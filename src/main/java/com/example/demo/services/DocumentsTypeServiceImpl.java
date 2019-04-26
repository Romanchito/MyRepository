package com.example.demo.services;

import com.example.demo.entities.Document;
import com.example.demo.entities.DocumentsType;
import com.example.demo.entities.User;
import com.example.demo.services.Interfaces.Serviceable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class DocumentsTypeServiceImpl implements Serviceable<DocumentsType> {
    @Override
    public Set<DocumentsType> getAll() {
        Set<Document> documents = new HashSet<>();
        Set<DocumentsType> documentsType = new HashSet<>();
        documentsType.add(new DocumentsType(10 , 0, "Военный билет" , documents));
        return documentsType;
    }

    @Override
    public DocumentsType getById(Integer id) {
        return null;
    }

    @Override
    public Boolean update(DocumentsType item) {
        return null;
    }

    @Override
    public Boolean save(DocumentsType item) {
        return null;
    }
}
