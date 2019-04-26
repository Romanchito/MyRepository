package com.example.demo.documents_type;

import com.example.demo.entities.Country;
import com.example.demo.entities.Document;
import com.example.demo.entities.DocumentsType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RestTemplateTest {

    private final String url = "http://localhost:8989/api/docs";
    private final RestTemplate test = new RestTemplate();

    @Test
    public void returnSetOfDocuments() {
        ResponseEntity<DocumentsType[]> countries = test.getForEntity(url, DocumentsType[].class);
        Assert.assertEquals(countries.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(countries.getBody().length, 1);
        Assert.assertEquals(countries.getBody()[0].getName(), "Военный билет");
    }
}
