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
@Table(name = "prenda")
public class Prenda implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idprenda;
	@NotNull
	private String marcaprenda;
	
	//private Blob Caracteristicas;
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="prenda_id")
		private TipoPrenda tipoprenda;

	public Long getIdprenda() {
		return idprenda;
	}

	public void setIdprenda(Long idprenda) {
		this.idprenda = idprenda;
	}

	public String getMarcaprenda() {
		return marcaprenda;
	}

	public void setMarcaprenda(String marcaprenda) {
		this.marcaprenda = marcaprenda;
	}

	public TipoPrenda getTipoprenda() {
		return tipoprenda;
	}

	public void setTipoprenda(TipoPrenda tipoprenda) {
		this.tipoprenda = tipoprenda;
	}

	
}
