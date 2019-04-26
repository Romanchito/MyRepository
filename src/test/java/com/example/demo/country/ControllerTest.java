package com.example.demo.country;

import com.example.demo.controllers.CountryController;
import com.example.demo.entities.Country;
import com.example.demo.services.Interfaces.Serviceable;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    @Mock
    private Serviceable<Country> countryService;

    @InjectMocks
    private CountryController countryController = new CountryController(countryService);

    @Test
    public void shouldCallGetCountriesMethod() {
        Set<Country> countries = new HashSet<>();
        countries.add(new Country(1, "Russia" , new HashSet<>()));
        when(countryService.getAll()).thenReturn(countries);
        Assert.assertEquals(countryController.getCountries(), countries);
        verify(countryService).getAll();
    }
}