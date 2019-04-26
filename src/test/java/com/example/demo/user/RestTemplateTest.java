package com.example.demo.user;


import com.example.demo.entities.User;
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

    private final String url = "http://localhost:8989/api/users";
    private final RestTemplate test = new RestTemplate();

    @Test
    public void returnSetOfOrganisation() {
        ResponseEntity<User[]> users = test.getForEntity(url  + "/list", User[].class);
        Assert.assertEquals(users.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(users.getBody().length, 2);
        Assert.assertEquals(users.getBody()[0].getFirstName(), "Dmitry");
        Assert.assertEquals(users.getBody()[1].getFirstName(), "Dmitry");

    }

    @Test
    public void returnOrganisationById() {
        ResponseEntity<User> user = test.getForEntity(url + "/{id}", User.class, 1);
        Assert.assertEquals(user.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(user.getBody().getFirstName(), "Stan");
        Assert.assertEquals(user.getBody().getSecondName(), "Dmitry");
        Assert.assertEquals(user.getBody().getMiddleName(), "Lask");
        Assert.assertEquals(user.getBody().getActive(), true);
    }


    @Test
    public void updateOrganisation() {
        HttpEntity<User> request = new HttpEntity<>(new User());
        ResponseEntity<String> response = test.postForEntity(url + "/update", request, String.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertTrue(response.getBody(), true);
    }


    @Test
    public void saveOrganisation() {
        HttpEntity<User> request = new HttpEntity<>(new User());
        ResponseEntity<String> response = test.postForEntity(url + "/save", request, String.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertTrue(response.getBody(), true);
    }
}