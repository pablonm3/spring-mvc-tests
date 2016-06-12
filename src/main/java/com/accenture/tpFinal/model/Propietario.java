package com.accenture.tpFinal.model;



import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "propietarios")
public class Propietario {
	
	@Id
	private int dni;
	
	private String direccion;
	
	private String telefono;
	
	private String nombre;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "propietario")
	private List<Orden>ordenes;

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Orden> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(List<Orden> ordenes) {
		this.ordenes = ordenes;
	}
	
}
