package com.accenture.tpFinal.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tpFinal.data.dao.OrdenesDao;
import com.accenture.tpFinal.model.Orden;
import com.accenture.tpFinal.model.OrdenRepuesto;
import com.accenture.tpFinal.model.Propietario;
import com.accenture.tpFinal.model.Repuesto;

@Service
public class OrdenServiceImpl implements OrdenService{

	@Autowired
	OrdenesDao ordenesDao;
	
	@Autowired
	OrdenRepuestoService ordenRepuestoService;
	
	@Autowired
	PropietarioService propietarioService;
	
	@Autowired
	RepuestoService repuestoService;
	
	public List<Orden> listar() {
		return ordenesDao.listar();
	}

	public Orden get(int id) {
		return ordenesDao.get(id);
	}
	
	public List<Orden> listarSegunPropietario(int dni){
		
		Propietario p = propietarioService.get(dni);
		return ordenesDao.listar(p);
		
	}
	public boolean finalizar(int id){
		
		Orden o = ordenesDao.get(id);
		if(o == null)
			return false;
		o.finalizar();
		ordenesDao.modificar(o);
		return true;
	}

	public float getCostoManoObra(int id){
		Orden o = ordenesDao.get(id);
		return o.getCostoManoObra();
	}

	public void commitUpdate(Orden o){
		ordenesDao.modificar(o);
	}
	
	public void updateOrdenRepuesto(int idOrden, int cantidad, int idRepuesto){
		Orden o = get(idOrden);		
		OrdenRepuesto or= o.getOrdenRepuesto(idRepuesto);
		if(or != null){
			or.aumentarCantidad(cantidad);
		}
		else{
			Repuesto repuesto = repuestoService.get(idRepuesto);
			or = new OrdenRepuesto(repuesto, cantidad, o);
		}
		ordenRepuestoService.saveOrUpdate(or);
	}




}
