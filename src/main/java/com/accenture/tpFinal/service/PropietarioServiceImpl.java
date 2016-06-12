package com.accenture.tpFinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tpFinal.data.dao.PropietariosDao;
import com.accenture.tpFinal.model.Propietario;

@Service
public class PropietarioServiceImpl implements PropietarioService{
	
	@Autowired
	PropietariosDao propietariosDao;
	
	public List<Propietario> listar() {
		return propietariosDao.listar();
	}

	public Propietario get(int id){
		return propietariosDao.get(id);
	}

}
