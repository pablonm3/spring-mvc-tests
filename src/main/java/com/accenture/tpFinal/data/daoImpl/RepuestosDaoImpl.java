package com.accenture.tpFinal.data.daoImpl;

import java.util.List;

import com.accenture.tpFinal.data.dao.RepuestosDao;
import com.accenture.tpFinal.model.Repuesto;

public class RepuestosDaoImpl extends GenericDao implements RepuestosDao{

	public List<Repuesto> listar(){
		return listar(Repuesto.class);
	}
	
	public Repuesto get(int id){
		return get(Repuesto.class, id);
	}
	
	
}
