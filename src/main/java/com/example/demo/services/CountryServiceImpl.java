package com.example.demo.services;

import com.example.demo.entities.Country;
import com.example.demo.entities.User;
import com.example.demo.services.Interfaces.Serviceable;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Set;

@Service
public class CountryServiceImpl implements Serviceable<Country> {

    @Override
    public Set<Country> getAll() {
        Set<Country> countriesList = new HashSet<>();
        Set<User> usersList = new HashSet<>();

        countriesList.add(new Country(0,  "Russia", usersList));
        return countriesList;
    }

    @Override
    public Country getById(Integer id) {
        return null;
    }

    @Override
    public Boolean update(Country item) {
        return null;
    }

    @Override
    public Boolean save(Country item) {
        return null;
    }
}
