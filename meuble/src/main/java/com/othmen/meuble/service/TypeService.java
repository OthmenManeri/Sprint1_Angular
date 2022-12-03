package com.othmen.meuble.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.othmen.meuble.entities.Type;


public interface TypeService {

    List <Type> findAll();
    
    Type saveType(Type c);
    Type updateType(Type c);
    void deleteType(Type c);
     void deleteTypeById(Long id);
     Type getType (Long idType);

	Page<Type> getAllTypeParPage(int page, int size);

}