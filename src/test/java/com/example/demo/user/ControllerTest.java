package com.example.demo.user;

import com.example.demo.controllers.UserController;
import com.example.demo.entities.Document;
import com.example.demo.entities.Office;
import com.example.demo.entities.User;
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
    private Serviceable<User> userServiceable;

    @InjectMocks
    private UserController userController = new UserController(userServiceable);

    @Test
    public void shouldCallGetUsersMethod() {
        Set<User> users = new HashSet<>();
        users.add(new User(1, "Anton", "Veliev", "Sergeevich" ,
                "manager"  ,  "+19995553535" , true ,
                new Office(), new HashSet<>() , new Document()));
        when(userServiceable.getAll()).thenReturn(users);
        Assert.assertEquals(userController.getUsers(), users);
        verify(userServiceable).getAll();
    }
}
