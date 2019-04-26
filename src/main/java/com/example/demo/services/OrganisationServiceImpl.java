package com.example.demo.services;

import com.example.demo.entities.Office;
import com.example.demo.entities.Organisation;
import com.example.demo.services.Interfaces.Serviceable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class OrganisationServiceImpl implements Serviceable<Organisation> {
    @Override
    public Set<Organisation> getAll() {
        Set<Office> offices = new HashSet<>();
        Set<Organisation> organisations = new HashSet<>();
        organisations.add(new Organisation(0,"ALOX" , "Alien Of Xenon" , "1231441" ,
                "12312312" , "123 Moscow street Talya 43 5-4" ,
                "+79883556666" , true , offices));
        return organisations;
    }

    @Override
    public Organisation getById(Integer id) {
        Set<Office> offices = new HashSet<>();
        return new Organisation(0,"ALOX" , "Alien Of Xenon" , "1231441" , "12312312" , "123 Moscow street Talya 43 5-4" ,
                "+79883556666" , true , offices);
    }

    @Override
    public Boolean update(Organisation item) {
        return true;
    }

    @Override
    public Boolean save(Organisation item) {
        return true;
    }
}
