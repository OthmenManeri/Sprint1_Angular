package com.othmen.meuble.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.othmen.meuble.entities.Type;
import com.othmen.meuble.entities.meuble;
@Repository
public interface MeubleRepository extends JpaRepository<meuble, Long> {
	List<meuble> findByNomMeuble(String nom);
	 List<meuble> findByNomMeubleContains(String nom);
	 @Query("select p from meuble p where p.nomMeuble like %:nom and p.prixMeuble > :prix")
	 List<meuble> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	 @Query("select p from meuble p where p.type = ?1")
	 List<meuble> findByType (Type type);
	 List<meuble> findByTypeIdType(Long id);
	 List<meuble> findByOrderByNomMeubleAsc();
	 @Query("select p from meuble p order by p.nomMeuble ASC, p.prixMeuble DESC")
	 List<meuble> trierMeublesNomsPrix();
}