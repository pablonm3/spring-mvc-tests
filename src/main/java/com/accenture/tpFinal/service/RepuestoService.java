package com.accenture.tpFinal.service;

import java.util.List;

import com.accenture.tpFinal.model.Orden;
import com.accenture.tpFinal.model.Repuesto;

public interface RepuestoService {

	public List<Repuesto> listar();
	public Repuesto get(int id);
	
}
