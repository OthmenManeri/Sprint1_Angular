package com.othmen.meuble.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.othmen.meuble.entities.Type;


@Repository
public interface TypeRepository extends JpaRepository<Type, Long>{

}