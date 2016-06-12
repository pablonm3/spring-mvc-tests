package com.accenture.tpFinal.service;

import com.accenture.tpFinal.model.Empleado;

public class EmpleadoServiceImpl implements EmpleadoService{

	public float getValorHora(){
		return Empleado.getCostoManoObra();
	}
	
}
