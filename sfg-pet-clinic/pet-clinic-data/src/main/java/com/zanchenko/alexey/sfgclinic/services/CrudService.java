package com.zanchenko.alexey.sfgclinic.services;

import java.util.Set;

public interface CrudService<T, ID> { //Notice that we are using generics here
    // So we are using Java generics so when we implement this, we'll
    //specify the generics that we want.

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
