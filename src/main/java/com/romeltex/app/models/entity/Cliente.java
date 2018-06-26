package com.romeltex.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcliente;
	
	@NotBlank	
	private String nombrecliente;
	
	@NotBlank	
	private String apellidocliente;
	
	@NotNull
	@Min(value = 1)
	private int dnicliente;
	
	@NotBlank	
	private String nombreempresa;
	
	@NotNull
	@Email
	private String correocliente;
	@NotNull
	private String rucempresa;
	@NotNull
	private String pais;
	
	@OneToMany(mappedBy="cliente", fetch=FetchType.LAZY,
			cascade=CascadeType.ALL)
	private List<Orden> ordenes;
	
	public Cliente() {
		ordenes=new ArrayList<>();
	}

	public Long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombrecliente() {
		return nombrecliente;
	}

	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}

	public String getApellidocliente() {
		return apellidocliente;
	}

	public void setApellidocliente(String apellidocliente) {
		this.apellidocliente = apellidocliente;
	}

	public int getDnicliente() {
		return dnicliente;
	}

	public void setDnicliente(int dnicliente) {
		this.dnicliente = dnicliente;
	}

	public String getNombreempresa() {
		return nombreempresa;
	}

	public void setNombreempresa(String nombreempresa) {
		this.nombreempresa = nombreempresa;
	}

	public String getCorreocliente() {
		return correocliente;
	}

	public void setCorreocliente(String correocliente) {
		this.correocliente = correocliente;
	}

	public String getRucempresa() {
		return rucempresa;
	}

	public void setRucempresa(String rucempresa) {
		this.rucempresa = rucempresa;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Orden> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(List<Orden> ordenes) {
		this.ordenes = ordenes;
	}
	
}
