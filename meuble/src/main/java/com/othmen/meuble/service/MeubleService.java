package com.othmen.meuble.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.othmen.meuble.entities.Type;
import com.othmen.meuble.entities.meuble;
public interface MeubleService {
meuble saveMeuble(meuble p);
meuble updateMeuble(meuble p);
void deleteMeuble(meuble p);
 void deleteMeubleById(Long id);
meuble getMeuble(Long id);
List<meuble> getAllMeubles();
Page<meuble> getAllMeublesParPage(int page, int size);
List<meuble> findByNomMeuble(String nom);
List<meuble> findByNomMeubleContains(String nom);
List<meuble> findByNomPrix (String nom, Double prix);
List<meuble> findByType (Type type);
List<meuble> findByTypeIdType(Long id);
List<meuble> findByOrderByNomMeubleAsc();
List<meuble> trierMeublesNomsPrix();
}