package com.accenture.tpFinal.data.daoImpl;

import java.util.List;

import com.accenture.tpFinal.data.dao.OrdenesDao;
import com.accenture.tpFinal.model.Orden;
import com.accenture.tpFinal.model.Propietario;

public class OrdenesDaoImpl extends GenericDao implements OrdenesDao{

	public Orden get(int id){
		return get(Orden.class, id);
	}
	
	public List<Orden> listar(){
		return listar(Orden.class);
	}
	
	public void add(Orden o){
		super.add(o);
	}
	
	public void borrar(Orden o){
		super.borrar(o);
	}
	
	public void modificar(Orden o){
		super.modificar(o);
	}
	
	public List<Orden> listar(Propietario p){
		return listar(Orden.class, "where dniPropietario = " + p.getDni());
	}

	
	
}
