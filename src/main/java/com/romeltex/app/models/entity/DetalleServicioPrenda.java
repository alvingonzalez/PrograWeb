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
@Table(name = "detalleservicioprenda")
public class DetalleServicioPrenda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddetalleservicioprenda;
	@NotNull
	private double precioserviciounitario;
	
	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idservicio")
	private Servicio servicio;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idprenda")
	private Prenda prenda;
	
	public Long getIddetalleservicioprenda() {
		return iddetalleservicioprenda;
	}

	public void setIddetalleservicioprenda(Long iddetalleservicioprenda) {
		this.iddetalleservicioprenda = iddetalleservicioprenda;
	}

	public double getPrecioserviciounitario() {
		return precioserviciounitario;
	}

	public void setPrecioserviciounitario(double precioserviciounitario) {
		this.precioserviciounitario = precioserviciounitario;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	
}
