package com.example.demo.organisation;

import com.example.demo.entities.Country;
import com.example.demo.entities.Organisation;
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

    private final String url = "http://localhost:8989/api/organisations";
    private final RestTemplate test = new RestTemplate();

    @Test
    public void returnSetOfOrganisation() {
        ResponseEntity<Organisation[]> organisations = test.getForEntity(url  + "/list", Organisation[].class);
        Assert.assertEquals(organisations.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(organisations.getBody().length, 1);
        Assert.assertEquals(organisations.getBody()[0].getName(), "ALOX");
    }

    @Test
    public void returnOrganisationById() {
        ResponseEntity<Organisation> organisation = test.getForEntity(url + "/{id}", Organisation.class, 1);
        Assert.assertEquals(organisation.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(organisation.getBody().getName(), "ALOX");
        Assert.assertEquals(organisation.getBody().getFullName(), "Alien Of Xenon");
        Assert.assertEquals(organisation.getBody().getPhone(), "+79883556666");
        Assert.assertEquals(organisation.getBody().getActive(), true);
    }


    @Test
    public void updateOrganisation() {
        HttpEntity<Organisation> request = new HttpEntity<>(new Organisation());
        ResponseEntity<String> response = test.postForEntity(url + "/update", request, String.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertTrue(response.getBody(), true);
    }


    @Test
    public void saveOrganisation() {
        HttpEntity<Organisation> request = new HttpEntity<>(new Organisation());
        ResponseEntity<String> response = test.postForEntity(url + "/save", request, String.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertTrue(response.getBody(), true);
    }
}
