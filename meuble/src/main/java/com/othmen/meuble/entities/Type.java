package com.othmen.meuble.entities;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@Entity
public class Type {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idType;
private String nomType;
public String descType;

@JsonIgnore
@OneToMany(mappedBy = "type")
private List<meuble> meubles;
public Type() {}
public Type(String nomType, String descType, List<meuble> meubles) 
{
super();
this.nomType = nomType;
this.descType = descType;
this.meubles = meubles;
}
public Long getIdType() {
return idType;
}
public void setIdType(Long idType) {
this.idType = idType;
}
public String getNomType() {
return nomType;
}
public void setNomType(String nomType) {
this.nomType = nomType;
}
public String getdescType() {
return descType;
}
public void setdescType(String descType) {
this.descType = descType;
}

public List<meuble> getMeubles() {
return meubles;
}
public void setMeubles(List<meuble> meubles) {
this.meubles = meubles;
}
@Override
public String toString() {
	return "Type [idType=" + idType + ", nomType=" + nomType + ", descType=" + descType + "]";
}
}