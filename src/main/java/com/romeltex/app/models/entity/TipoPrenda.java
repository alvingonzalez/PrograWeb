package com.romeltex.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tipoprenda")
public class TipoPrenda implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtipoprenda;
	
	@NotNull
	private String nombreprenda;

	public Long getIdtipoprenda() {
		return idtipoprenda;
	}

	public void setIdtipoprenda(Long idtipoprenda) {
		this.idtipoprenda = idtipoprenda;
	}

	public String getNombreprenda() {
		return nombreprenda;
	}

	public void setNombreprenda(String nombreprenda) {
		this.nombreprenda = nombreprenda;
	}
	
	
}
