package com.example.demo.documents_type;

import com.example.demo.controllers.DocumentsTypeController;
import com.example.demo.entities.DocumentsType;
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
    private Serviceable<DocumentsType> documentsTypeServiceable;

    @InjectMocks
    private DocumentsTypeController documentsTypeController = new DocumentsTypeController(documentsTypeServiceable);

    @Test
    public void shouldCallGetDocumentsTypesMethod() {
        Set<DocumentsType> documentsTypes = new HashSet<>();
        documentsTypes.add(new DocumentsType(1,0, "Passport" , new HashSet<>()));
        when(documentsTypeServiceable.getAll()).thenReturn(documentsTypes);
        Assert.assertEquals(documentsTypeController.getDocumentsTypes(), documentsTypes);
        verify(documentsTypeServiceable).getAll();
    }
}
