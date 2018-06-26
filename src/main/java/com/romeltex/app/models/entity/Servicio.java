package com.romeltex.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "servicio")
public class Servicio implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idservicio;
	@NotNull
	private String nombreservicio;
	
	
	public Long getIdservicio() {
		return idservicio;
	}
	public void setIdservicio(Long idservicio) {
		this.idservicio = idservicio;
	}
	public String getNombreservicio() {
		return nombreservicio;
	}
	public void setNombreservicio(String nombreservicio) {
		this.nombreservicio = nombreservicio;
	}
	
	
}
