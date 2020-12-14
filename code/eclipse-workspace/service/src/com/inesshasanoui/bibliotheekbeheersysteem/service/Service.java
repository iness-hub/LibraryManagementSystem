package com.inesshasanoui.bibliotheekbeheersysteem.service;

import java.util.List;

import com.inesshasanoui.bibliotheekbeheersysteem.service.exception.ItemException;
import com.inesshasnaoui.bibliotheekbeheersysteem.dao.DaoException;

public interface Service <T> {
	T insert(T obj) ;
    T update(T obj);
    boolean delete(T obj);
    T get(long id);
    List<T> getAll();
  }
