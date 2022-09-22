package com.zanchenko.alexey.sfgclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T, ID> {

    protected Map<ID, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(ID id, T object){ // i am just saying object there because we really don't know what is coming in
    // because of the generics
        map.put(id, object);
        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){ // Lambda goodness
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }
}
