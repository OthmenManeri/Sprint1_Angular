package com.othmen.meuble.entities;

import org.springframework.data.rest.core.config.Projection;
@Projection(name = "nomProd", types = { meuble.class })
public interface MeubleProjection {
public String getNomMeuble();
}