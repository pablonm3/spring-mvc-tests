package com.accenture.tpFinal.data.daoImpl;

import org.springframework.stereotype.Component;

import com.accenture.tpFinal.data.dao.OrdenRepuestoDao;
import com.accenture.tpFinal.model.OrdenRepuesto;

@Component
public class OrdenRepuestoDaoImpl extends GenericDao implements OrdenRepuestoDao{

	public void saveOrUpdate(OrdenRepuesto or){
		super.saveOrUpdate(or);
	}
	
}
