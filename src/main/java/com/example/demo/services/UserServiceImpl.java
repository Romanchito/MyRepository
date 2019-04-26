package com.example.demo.services;


import com.example.demo.entities.Country;
import com.example.demo.entities.Document;
import com.example.demo.entities.Office;
import com.example.demo.entities.User;
import com.example.demo.services.Interfaces.Serviceable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Service
public class UserServiceImpl implements Serviceable<User> {
    @Override
    public Set<User> getAll() {
        Set<Country> countries = new HashSet<>();
        Set<User> users = new HashSet<>();
        Office office = new Office(0 , "central age","str. Msk 112 dt 34" ,
                "+79874445566" , true ,  null , null  );

        users.add(new User(0, "Dmitry", "Smith", null , "manager" ,
                "+79874445566" , true , office , countries , null));

        users.add(new User(0, "Dmitry", "Lask", null , "junior developer" ,
                "+79874445566" , true , office , countries , null));

        return users;
    }

    @Override
    public User getById(Integer id) {
        Set<Country> countries = new HashSet<>();
        Document document= new Document(id , 0 , "12332" , null , null , null );
        return new User(1 , "Stan" ,"Dmitry", "Lask" , "Petrov"  , "admin" ,
                true , new Office() , countries ,  document);
    }

    @Override
    public Boolean update(User item) {
        return true;
    }

    @Override
    public Boolean save(User item) {
        return true;
    }
}
