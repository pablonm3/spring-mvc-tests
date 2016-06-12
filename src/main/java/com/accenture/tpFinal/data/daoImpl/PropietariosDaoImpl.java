package com.accenture.tpFinal.data.daoImpl;

import java.util.List;

import com.accenture.tpFinal.data.dao.PropietariosDao;
import com.accenture.tpFinal.model.Propietario;

public class PropietariosDaoImpl extends GenericDao implements PropietariosDao{

	public Propietario get(int id){
		return get(Propietario.class, id);
	}
	
	public List<Propietario> listar(){
		return listar(Propietario.class);
	}
	
	
	public void add(Propietario p){
		super.add(p);
	}
	
	public void borrar(Propietario p){
		super.borrar(p);
	}
	
	public void modificar(Propietario p){
		super.modificar(p);
	}
	
	
}
