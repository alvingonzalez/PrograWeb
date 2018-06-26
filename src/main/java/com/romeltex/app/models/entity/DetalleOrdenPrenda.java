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
@Table(name = "detalleordenprenda")
public class DetalleOrdenPrenda implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iddetalle;
	@NotNull
	private Long cantidad;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="orden_id")
	private Orden orden;
	
	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="prenda_id")
	private Prenda prenda;

	public Long getIddetalle() {
		return iddetalle;
	}

	public void setIddetalle(Long iddetalle) {
		this.iddetalle = iddetalle;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}
	
}
