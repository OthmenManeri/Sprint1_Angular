package com.othmen.meuble.entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class meuble {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idMeuble;

@NotNull
@Size (min = 4,max = 15)
private String nomMeuble;

public Type getType() {
	return type;
}
public void setType(Type type) {
	this.type = type;
}
@Min(value = 10)
@Max(value = 10000)
private Double prixMeuble;


@ManyToOne
private Type type;
public meuble() {
super();
}
public meuble(String nomMeuble, Double prixMeuble, Date dateCreation) {
super();
this.nomMeuble = nomMeuble;
this.prixMeuble = prixMeuble;
}
public Long getIdMeuble() {
return idMeuble;
}
public void setIdMeuble(Long idMeuble) {
this.idMeuble = idMeuble;
}
public String getNomMeuble() {
return nomMeuble;
}
public void setNomMeuble(String nomMeuble) {
this.nomMeuble = nomMeuble;
}
public Double getPrixMeuble() {
return prixMeuble;
}
public void setPrixMeuble(Double prixMeuble) {
this.prixMeuble = prixMeuble;
}

@Override
public String toString() {
	return "meuble [idMeuble=" + idMeuble + ", nomMeuble=" + nomMeuble + ", prixMeuble=" + prixMeuble
			+ ", type=" + type + "]";
}
}
