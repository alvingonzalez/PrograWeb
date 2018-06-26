package com.romeltex.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "orden")
public class Orden implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idorden;
	
	@Temporal(TemporalType.DATE)
	private Date fechasolicitud;
	
	@Temporal(TemporalType.DATE)
	private Date fechaentrega;
	
	@NotNull
	private String estadoorden;	
		
	@ManyToOne(fetch=FetchType.LAZY)	
	private Cliente cliente;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="empleado_id")
	private Empleado Empleado;

	public Long getIdorden() {
		return idorden;
	}

	public void setIdorden(Long idorden) {
		this.idorden = idorden;
	}

	public Date getFechasolicitud() {
		return fechasolicitud;
	}

	public void setFechasolicitud(Date fechasolicitud) {
		this.fechasolicitud = fechasolicitud;
	}

	public Date getFechaentrega() {
		return fechaentrega;
	}

	public void setFechaentrega(Date fechaentrega) {
		this.fechaentrega = fechaentrega;
	}

	public String getEstadoorden() {
		return estadoorden;
	}

	public void setEstadoorden(String estadoorden) {
		this.estadoorden = estadoorden;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return Empleado;
	}

	public void setEmpleado(Empleado empleado) {
		Empleado = empleado;
	}
	
}
