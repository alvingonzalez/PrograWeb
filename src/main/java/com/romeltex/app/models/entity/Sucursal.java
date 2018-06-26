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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sucursal")
public class Sucursal implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idsucursal;
	@NotNull
	private String nombresucursal;
	@NotNull
	private String direccionsucursal;
	@NotNull
	private String localidadsucursal;
	@NotNull
	private String provinciasucursal;
	@NotNull
	private String telefonosucursal;
	@NotNull
	private String emailsucursal;
	@NotNull
	private String horarioatencion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="orden_id")
	private Orden orden;
	
	
	public Orden getOrden() {
		return orden;
	}
	public void setOrden(Orden orden) {
		this.orden = orden;
	}
	public Long getIdsucursal() {
		return idsucursal;
	}
	public void setIdsucursal(Long idsucursal) {
		this.idsucursal = idsucursal;
	}
	public String getNombresucursal() {
		return nombresucursal;
	}
	public void setNombresucursal(String nombresucursal) {
		this.nombresucursal = nombresucursal;
	}
	public String getDireccionsucursal() {
		return direccionsucursal;
	}
	public void setDireccionsucursal(String direccionsucursal) {
		this.direccionsucursal = direccionsucursal;
	}
	public String getLocalidadsucursal() {
		return localidadsucursal;
	}
	public void setLocalidadsucursal(String localidadsucursal) {
		this.localidadsucursal = localidadsucursal;
	}
	public String getProvinciasucursal() {
		return provinciasucursal;
	}
	public void setProvinciasucursal(String provinciasucursal) {
		this.provinciasucursal = provinciasucursal;
	}
	public String getTelefonosucursal() {
		return telefonosucursal;
	}
	public void setTelefonosucursal(String telefonosucursal) {
		this.telefonosucursal = telefonosucursal;
	}
	public String getEmailsucursal() {
		return emailsucursal;
	}
	public void setEmailsucursal(String emailsucursal) {
		this.emailsucursal = emailsucursal;
	}
	public String getHorarioatencion() {
		return horarioatencion;
	}
	public void setHorarioatencion(String horarioatencion) {
		this.horarioatencion = horarioatencion;
	}
	
	
	
}
