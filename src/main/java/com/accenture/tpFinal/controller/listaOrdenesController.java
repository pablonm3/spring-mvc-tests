package com.accenture.tpFinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.tpFinal.model.Orden;
import com.accenture.tpFinal.model.Propietario;
import com.accenture.tpFinal.service.EmpleadoService;
import com.accenture.tpFinal.service.OrdenService;
import com.accenture.tpFinal.service.PropietarioService;

@Controller
public class listaOrdenesController {

	@Autowired
	OrdenService ordenService;
	
	@Autowired
	EmpleadoService empleadoService;
	
	@Autowired
	PropietarioService propietarioService;
	

	
	@RequestMapping(path = "/tablas/detalleOrden/{id}")
	public ModelAndView detalleOrden(@PathVariable("id")int id){
		Orden o= null;
		try{
		 o = ordenService.get(id);
		}
		catch(org.hibernate.ObjectNotFoundException er){
			o = null;
		}
		return new ModelAndView("ordenes","orden", o);
	}
	
	@RequestMapping(path = "/ordenes", method=RequestMethod.GET)
	public ModelAndView lista(){
		List<Orden> ordenes = ordenService.listar();
		return new ModelAndView("ordenes","listaOrdenes", ordenes);
	}


	@RequestMapping(path = "/propietario/{dni}", method=RequestMethod.GET)
	public ModelAndView propietario(@PathVariable("dni")int dni){
		ModelAndView model = new ModelAndView("propietario");
		List<Orden> ordenes = ordenService.listarSegunPropietario(dni);
		Propietario p = propietarioService.get(dni);
		model.addObject("listaOrdenes", ordenes);
		model.addObject("propietario", p);
		return model;
	}
	
	@RequestMapping(path = "costos/{id}", method=RequestMethod.GET)
	public ModelAndView verCostos(@PathVariable("id")int id){
		ModelAndView model = new ModelAndView("costos");
		Orden o = ordenService.get(id);
		model.addObject("valorHora", empleadoService.getValorHora());
		model.addObject("orden", o);
		return model;
	}
	
}
