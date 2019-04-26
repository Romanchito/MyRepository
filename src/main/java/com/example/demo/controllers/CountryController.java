package com.example.demo.controllers;

import com.example.demo.entities.Country;
import com.example.demo.services.Interfaces.Serviceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private Serviceable<Country> countryService;

    @Autowired
    public CountryController(Serviceable<Country> countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public  Set<Country> getCountries(){

        return countryService.getAll();
    }
}