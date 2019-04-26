package com.example.demo.office;

import com.example.demo.controllers.OfficeController;
import com.example.demo.entities.Office;
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
    private Serviceable<Office> officeServiceable;

    @InjectMocks
    private OfficeController officeController = new OfficeController(officeServiceable);

    @Test
    public void shouldCallGetOfficesMethod() {
        Set<Office> offices = new HashSet<>();
        offices.add(new Office(1, "Lappas", "District 9 Iohanesburg" , "+19995553535",
                true , null ,  new HashSet<>()));
        when(officeServiceable.getAll()).thenReturn(offices);
        Assert.assertEquals(officeController.getOffices(), offices);
        verify(officeServiceable).getAll();
    }
}

