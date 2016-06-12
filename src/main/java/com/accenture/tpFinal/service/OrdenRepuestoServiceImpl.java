package com.accenture.tpFinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tpFinal.data.dao.OrdenRepuestoDao;
import com.accenture.tpFinal.model.OrdenRepuesto;

@Service
public class OrdenRepuestoServiceImpl implements OrdenRepuestoService{

	@Autowired
	OrdenRepuestoDao ordenRepuestoDao;
	
	public void saveOrUpdate(OrdenRepuesto or){
		ordenRepuestoDao.saveOrUpdate(or);
	}
	
	
}
