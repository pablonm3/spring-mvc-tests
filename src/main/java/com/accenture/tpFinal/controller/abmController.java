package com.accenture.tpFinal.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.tpFinal.model.Orden;
import com.accenture.tpFinal.model.Repuesto;
import com.accenture.tpFinal.service.OrdenRepuestoService;
import com.accenture.tpFinal.service.OrdenService;
import com.accenture.tpFinal.service.RepuestoService;

@Controller
public class abmController {

	@Autowired
	OrdenService ordenService;
	
	@Autowired
	RepuestoService repuestoService;
	
	@RequestMapping(path = "/abm/finalizarOrden/{id}")
	public ModelAndView finalizarAction(@PathVariable("id")int id){
		ModelAndView model = new ModelAndView("redirect:/ordenes");
		ordenService.finalizar(id);
		return model;
	}    
	
	@RequestMapping(path ="/abm/addHorasTrabajo", method=RequestMethod.POST)
	public ModelAndView addHorasTrabajoAction(@RequestParam("id") int id, @RequestParam("horas") int horas){
		Orden o = ordenService.get(id);
		ModelAndView model = new ModelAndView("/abm/sumarHorasTrabajo");
		model.addObject("orden", o);
		model.addObject("id", id);
		o.sumarHorasTrabajo(horas);
		ordenService.commitUpdate(o);
		return model;
	}  
	
	@RequestMapping(path ="/abm/sumarHorasTrabajo/{id}", method=RequestMethod.GET)
	public ModelAndView addHorasTrabajo(@PathVariable("id")int id){
		ModelAndView model = new ModelAndView("/abm/sumarHorasTrabajo");
		model.addObject("id", id);
		return model;
	}   
	
	@RequestMapping(path ="abm/addRepuestoAction")
	public ModelAndView agregarRepuestoAction(@RequestParam("idOrden") int idOrden,
						@RequestParam("cantidad") int cantidad, @RequestParam("idRepuesto") int idRepuesto){
		ModelAndView model = new ModelAndView("abm/agregarRepuesto");
		model.addObject("idOrden", idOrden);
		List<Repuesto> listaRepuestos = repuestoService.listar();
		model.addObject("listaRepuestos", listaRepuestos);
		ordenService.updateOrdenRepuesto(idOrden, cantidad, idRepuesto);
		
		return model;
	}    
	

	
	
}
