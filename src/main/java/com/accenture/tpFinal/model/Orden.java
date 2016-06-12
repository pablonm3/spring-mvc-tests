package com.accenture.tpFinal.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ordenes")
public class Orden {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	private int horasTrabajadas;
	

	private String patente;
	
	private Date fecha;
	
	private String marca;
	

	private String modelo;
	
	private String detalle;
	
	private float precioFinal;

	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="dniPropietario")
	private Propietario propietario;
	
	@Column(name="estado", columnDefinition="enum('activo','finalizado')")
	public String estado;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "ordenACargo", cascade = CascadeType.ALL)
	private Empleado empleadoACargo;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "orden", fetch = FetchType.EAGER)
	private List<OrdenRepuesto> repuestos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Empleado getEmpleadoACargo() {
		return empleadoACargo;
	}

	
	public float getPrecioFinal() {
		return precioFinal;
	}
	
	public void setPrecioFinal(float precioFinal) {
		this.precioFinal = precioFinal;
	}
	
	public void setEmpleadoACargo(Empleado empleadoACargo) {
		this.empleadoACargo = empleadoACargo;
	}

	public List<OrdenRepuesto> getRepuestos() {
		return repuestos;
	}

	public void setRepuestos(List<OrdenRepuesto> repuestos) {
		this.repuestos = repuestos;
	}

	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public boolean isActivo(){
		return estado.equals("activo");
	}
	
	public boolean finalizar(){
		if(!estado.equals("activo"))
			return false;
		precioFinal = calcularPrecioFinal();
		estado = "finalizado";
		return true;
	}
	
	private float calcularPrecioFinal(){
		float precioF = getCostoManoObra();
		for(OrdenRepuesto or : repuestos){
			precioF += or.getCantidad() * or.getRepuesto().getPrecio();
		}
		return precioF;
	}
	
	public float getCostoManoObra(){
		return horasTrabajadas * Empleado.getCostoManoObra();
	}

	public void sumarHorasTrabajo(int horas){
		horasTrabajadas += horas;
	}
	
	public void addOrdenRepuesto(OrdenRepuesto ordenRepuesto){
		int index = repuestos.indexOf(ordenRepuesto);
		ordenRepuesto.setOrden(this);
		/*
		for(int i=0; i < repuestos.size(); i++){
			if(repuestos.get(i).getRepuesto().equals(ordenRepuesto.getRepuesto())){
				repuestos.get(i).aumentarCantidad(ordenRepuesto.getCantidad());
				System.out.println("coinciden");
				return;
			}
		}*/
		System.out.println("no coinciden");
		repuestos.add(ordenRepuesto);
	}
	
	public OrdenRepuesto getOrdenRepuesto(int idRepuesto){
		for(OrdenRepuesto or : repuestos){
			if(or.getRepuesto().getId() == idRepuesto)
				return or;
		}
		return null;
	}
	
}
