package com.example.demo.organisation;

import com.example.demo.controllers.OrganisationController;
import com.example.demo.entities.Organisation;
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
    private Serviceable<Organisation> organisationServiceable;

    @InjectMocks
    private OrganisationController organisationController = new OrganisationController(organisationServiceable);

    @Test
    public void shouldCallGetOrganisationMethod() {
        Set<Organisation> organisations = new HashSet<>();
        organisations.add(new Organisation(1, "LDA", "Lando Avenu Locations", "123123123" ,
                "332445"  ,  "Plava Laguna 200 street" , "+19995553535",
                true ,   new HashSet<>()));
        when(organisationServiceable.getAll()).thenReturn(organisations);
        Assert.assertEquals(organisationController.getOrganisation(), organisations);
        verify(organisationServiceable).getAll();
    }
}
