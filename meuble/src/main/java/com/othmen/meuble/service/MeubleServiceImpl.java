package com.othmen.meuble.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.othmen.meuble.entities.Type;
import com.othmen.meuble.entities.meuble;
import com.othmen.meuble.repos.MeubleRepository;
@Service
public class MeubleServiceImpl implements MeubleService {
@Autowired
MeubleRepository meubleRepository;
@Override
public meuble saveMeuble(meuble p) {
	return meubleRepository.save(p);
	}
	@Override
	public meuble updateMeuble(meuble p) {
	return meubleRepository.save(p);
	}
	@Override
	public void deleteMeuble(meuble p) {
	meubleRepository.delete(p);
	}
	 @Override
	public void deleteMeubleById(Long id) {
	meubleRepository.deleteById(id);
	}
	@Override
	public meuble getMeuble(Long id) {
	return meubleRepository.findById(id).get();
	}
	@Override
	public List<meuble> getAllMeubles() {
	return meubleRepository.findAll();
	}
	@Override
	public Page<meuble> getAllMeublesParPage(int page, int size) {
		return meubleRepository.findAll(PageRequest.of(page, size));

	}
	@Override
	public List<meuble> findByNomMeuble(String nom) {
	return meubleRepository.findByNomMeuble(nom);
	}
	@Override
	public List<meuble> findByNomMeubleContains(String nom) {
	return meubleRepository.findByNomMeubleContains(nom);
	}
	@Override
	public List<meuble> findByNomPrix(String nom, Double prix) {
		return meubleRepository.findByNomPrix(nom, prix);
	}
	@Override
	public List<meuble> findByType(Type type) {
	return meubleRepository.findByType(type);
	}
	@Override
	public List<meuble> findByTypeIdType(Long id) {
	return meubleRepository.findByTypeIdType(id);
	}
	@Override
	public List<meuble> findByOrderByNomMeubleAsc() {
	return meubleRepository.findByOrderByNomMeubleAsc();
	}
	@Override
	public List<meuble> trierMeublesNomsPrix() {
	return meubleRepository.trierMeublesNomsPrix();
	}
}