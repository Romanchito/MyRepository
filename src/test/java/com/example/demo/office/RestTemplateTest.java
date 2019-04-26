package com.example.demo.office;

import com.example.demo.entities.Country;
import com.example.demo.entities.Office;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RestTemplateTest {

    private final String url = "http://localhost:8989/api/offices";
    private final RestTemplate test = new RestTemplate();

    @Test
    public void returnSetOfOffices() {
        ResponseEntity<Office[]> countries = test.getForEntity(url  + "/list", Office[].class);
        Assert.assertEquals(countries.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(countries.getBody().length, 1);
        Assert.assertEquals(countries.getBody()[0].getName(), "GAZPROM");
    }

    @Test
    public void returnOfficeById() {
        ResponseEntity<Office> office = test.getForEntity(url + "/{id}", Office.class, 1);
        Assert.assertEquals(office.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(office.getBody().getName(), "TTT");
        Assert.assertEquals(office.getBody().getAddress(), "Moscow Red house");
        Assert.assertEquals(office.getBody().getPhone(), "88005553535");
        Assert.assertEquals(office.getBody().getActive(), true);
    }


    @Test
    public void updateOffice() {
        HttpEntity<Office> request = new HttpEntity<>(new Office());
        ResponseEntity<String> response = test.postForEntity(url + "/update", request, String.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertTrue(response.getBody(), true);
    }


    @Test
    public void saveOffice() {
        HttpEntity<Office> request = new HttpEntity<>(new Office());
        ResponseEntity<String> response = test.postForEntity(url + "/save", request, String.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertTrue(response.getBody(), true);
    }
}
