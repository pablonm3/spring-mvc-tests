package com.accenture.tpFinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tpFinal.data.dao.RepuestosDao;
import com.accenture.tpFinal.model.Orden;
import com.accenture.tpFinal.model.Repuesto;

@Service
public class RepuestoServiceImpl implements RepuestoService{

	@Autowired
	RepuestosDao repuestosDao;
	
	public List<Repuesto> listar() {
		return repuestosDao.listar();
	}

	public Repuesto get(int id) {
		return repuestosDao.get(id);
	}
	
	
}
