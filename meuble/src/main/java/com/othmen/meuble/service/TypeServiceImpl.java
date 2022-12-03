package com.othmen.meuble.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.othmen.meuble.entities.Type;
import com.othmen.meuble.entities.meuble;
import com.othmen.meuble.repos.TypeRepository;


@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List <Type> findAll() {
        return typeRepository.findAll();
    }

	@Override
	public Type saveType(Type c) {
		return typeRepository.save(c);
	}

	@Override
	public Type updateType(Type c) {
		return typeRepository.save(c);
	}

	@Override
	public void deleteType(Type c) {
		typeRepository.delete(c);
	}

	@Override
	public void deleteTypeById(Long idType) {
		typeRepository.deleteById(idType);
	}

	@Override
	public Type getType(Long idType) {
		return typeRepository.findById(idType).get();
	}
	@Override
	public Page<Type> getAllTypeParPage(int page, int size) {
		return typeRepository.findAll(PageRequest.of(page, size));

	}

   
}