package com.example.demo.controllers;

import com.example.demo.entities.Organisation;
import com.example.demo.services.Interfaces.Serviceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping(value = "/api/organisations")
public class OrganisationController {

    private Serviceable<Organisation> organisationService;

    @Autowired
    public OrganisationController(Serviceable<Organisation> organisationService) {
        this.organisationService = organisationService;
    }
    @GetMapping(value = "/list")
    public Set<Organisation> getOrganisation() {

        return organisationService.getAll();
    }
    @GetMapping(value = "/{id}")
    public Organisation getOrganisationById(@PathVariable("id") Integer id) {

        return organisationService.getById(id);
    }

    @PostMapping(value = "/update")
    public Boolean updateOrganisation(@RequestBody Organisation organisation) {

        return organisationService.update(organisation);
    }

    @PostMapping(value = "/save")
    public Boolean saveOrganisation(@RequestBody Organisation organisation) {

        return organisationService.save(organisation);
    }
}
