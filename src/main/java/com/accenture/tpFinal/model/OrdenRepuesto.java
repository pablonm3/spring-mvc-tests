package com.accenture.tpFinal.model;

import javax.persistence.*;

@Entity
@Table(name = "ordenRepuesto")
public class OrdenRepuesto {

	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="idRepuesto")
	private Repuesto repuesto;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	
	
	public OrdenRepuesto(){}
	
	public OrdenRepuesto(Repuesto repuesto, int cantidad, Orden orden) {
		this.repuesto = repuesto;
		this.cantidad = cantidad;
		this.orden = orden;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + id;
		result = prime * result + ((orden == null) ? 0 : orden.hashCode());
		result = prime * result + ((repuesto == null) ? 0 : repuesto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdenRepuesto other = (OrdenRepuesto) obj;
		if (cantidad != other.cantidad)
			return false;
		if (id != other.id)
			return false;
		if (orden == null) {
			if (other.orden != null)
				return false;
		} else if (!orden.equals(other.orden))
			return false;
		if (repuesto == null) {
			if (other.repuesto != null)
				return false;
		} else if (!repuesto.equals(other.repuesto))
			return false;
		return true;
	}


	private int cantidad;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getSubtotal() {
		return cantidad * repuesto.getPrecio();
	}


	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="idOrden")
	private Orden orden;

	public Repuesto getRepuesto() {
		return repuesto;
	}

	public void setRepuesto(Repuesto repuesto) {
		this.repuesto = repuesto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public void aumentarCantidad(int cant){
		cantidad += cant;
	}
	
	
}
