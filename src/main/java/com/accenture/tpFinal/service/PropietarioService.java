package com.accenture.tpFinal.service;

import java.util.List;

import com.accenture.tpFinal.model.Propietario;

public interface PropietarioService {

	public List<Propietario> listar();
	public Propietario get(int id);
	
	
	
}
