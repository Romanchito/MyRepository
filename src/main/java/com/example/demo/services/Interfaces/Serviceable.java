package com.example.demo.services.Interfaces;

import java.util.List;
import java.util.Set;

public interface Serviceable<T> {

    Set<T> getAll();

    T getById(Integer id);

    Boolean update(T item);

    Boolean save(T item);
}
