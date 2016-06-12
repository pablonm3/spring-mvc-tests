package com.accenture.tpFinal.service;


import java.util.List;

import com.accenture.tpFinal.model.Orden;
import com.accenture.tpFinal.model.OrdenRepuesto;

public interface OrdenService {
	
	public List<Orden> listar();
	public List<Orden> listarSegunPropietario(int dni);
	public Orden get(int id);
	public boolean finalizar(int id);
	public float getCostoManoObra(int id);
	public void commitUpdate(Orden o);
	public void updateOrdenRepuesto(int idOrden, int cantidad, int idRepuesto);
	
	
}
