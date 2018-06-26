package com.romeltex.app.models.entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idempleado;
	@NotNull
	private String nombreempleado;
	@NotNull
	private String apellidoempleado;
	@NotNull
	private String direccionempleado;
	@NotNull
	private String telefono;
	@NotNull
	@Email
	private String correoempleado;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	private TipoEmpleado tipoempleado;

	public Long getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(Long idempleado) {
		this.idempleado = idempleado;
	}

	public String getNombreempleado() {
		return nombreempleado;
	}

	public void setNombreempleado(String nombreempleado) {
		this.nombreempleado = nombreempleado;
	}

	public String getApellidoempleado() {
		return apellidoempleado;
	}

	public void setApellidoempleado(String apellidoempleado) {
		this.apellidoempleado = apellidoempleado;
	}

	public String getDireccionempleado() {
		return direccionempleado;
	}

	public void setDireccionempleado(String direccionempleado) {
		this.direccionempleado = direccionempleado;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoempleado() {
		return correoempleado;
	}

	public void setCorreoempleado(String correoempleado) {
		this.correoempleado = correoempleado;
	}

	public TipoEmpleado getTipoempleado() {
		return tipoempleado;
	}

	public void setTipoempleado(TipoEmpleado tipoempleado) {
		this.tipoempleado = tipoempleado;
	}
	
	
	
	
}
