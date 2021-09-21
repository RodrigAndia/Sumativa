package com.everis.data.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ventas")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//Atributos
	private Long id;
	private Integer prod;
	private Integer cantidad;
	private Integer valor;
	
	//relacion one To many (1 a n)
	@OneToMany(mappedBy = "venta",fetch = FetchType.LAZY)
	private List<Producto> productos;
	
//	//relacion one To many (1 a n)
//	@OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY)
//	private List<Usuario> usuarios;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	//Constructores
	public Venta() {
		super();
	}

	public Venta(Integer prod, Integer cantidad, Integer valor, Date createdAt, Date updatedAt) {
		super();
		this.prod = prod;
		this.cantidad = cantidad;
		this.valor = valor;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getProd() {
		return prod;
	}

	public void setProd(Integer prod) {
		this.prod = prod;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	//Methods
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
}
