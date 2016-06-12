package com.accenture.tpFinal.model;

import javax.persistence.*;

@Entity
@Table(name = "empleados")
public class Empleado {
	
	private static float VALOR_MANO_OBRA = 150;
	
	@Id
	private int dni;
	
	private String nombre;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="idOrden")
	private Orden ordenACargo;
	
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Orden getOrdenACargo() {
		return ordenACargo;
	}

	public void setOrdenACargo(Orden ordenACargo) {
		this.ordenACargo = ordenACargo;
	}

	public static float getCostoManoObra(){
		return VALOR_MANO_OBRA;
	}
	
}
