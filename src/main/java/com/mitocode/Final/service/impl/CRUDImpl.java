package com.mitocode.Final.service.impl;

import com.mitocode.Final.exception.ModelNotFoundException;
import com.mitocode.Final.repo.IGenericRepo;
import com.mitocode.Final.service.ICRUD;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {
    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        //obj.setId(id);
        getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT FOUND" + id));
        return getRepo().save(t);
    }

    @Override
    public List<T> readAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T readById(ID id) throws Exception {
        return getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT FOUND" + id));
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT FOUND" + id));
        getRepo().deleteById(id);
    }
}
