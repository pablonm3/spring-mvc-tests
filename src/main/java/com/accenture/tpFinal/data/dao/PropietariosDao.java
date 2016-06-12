package com.accenture.tpFinal.data.dao;

import java.util.List;

import com.accenture.tpFinal.model.Propietario;

public interface PropietariosDao {

	public List<Propietario> listar();
	public Propietario get(int id);
	public void add(Propietario p);
	public void borrar(Propietario p);
	public void modificar(Propietario p);
	
}
