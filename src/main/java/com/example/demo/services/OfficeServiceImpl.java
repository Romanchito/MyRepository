package com.example.demo.services;

import com.example.demo.entities.Office;
import com.example.demo.entities.Organisation;
import com.example.demo.entities.User;
import com.example.demo.services.Interfaces.Serviceable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class OfficeServiceImpl implements Serviceable<Office> {
    @Override
    public Set<Office> getAll() {
        Set<User> users = new HashSet<>();
        Set<Office> offices = new HashSet<>();
        offices.add(new Office(0, "GAZPROM", "", "", true, new Organisation(), users ));
        return offices;
    }

    @Override
    public Office getById(Integer id) {

        Set<User> users = new HashSet<>();
        return new Office(0, "TTT", "Moscow Red house", "88005553535", true, new Organisation(), users );
    }

    @Override
    public Boolean update(Office item) {
        return true;
    }

    @Override
    public Boolean save(Office item) {
        return true;
    }
}
