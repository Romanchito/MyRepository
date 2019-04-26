package com.example.demo.controllers;

import com.example.demo.entities.Office;
import com.example.demo.services.Interfaces.Serviceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/api/offices")
public class OfficeController {

    private Serviceable<Office> officeService;

    @Autowired
    public OfficeController(Serviceable<Office> officeService) {
        this.officeService = officeService;
    }

    @GetMapping(value = "/list")
    public Set<Office> getOffices() {

        return officeService.getAll();
    }
    @GetMapping(value = "/{id}")
    public Office getOfficeById(@PathVariable("id") Integer id) {

        return officeService.getById(id);
    }

    @PostMapping(value = "/update")
    public Boolean updateOffice(@RequestBody Office office) {

        return officeService.update(office);
    }

    @PostMapping(value = "/save")
    public Boolean saveOffice(@RequestBody Office office) {

        return officeService.save(office);
    }

}
