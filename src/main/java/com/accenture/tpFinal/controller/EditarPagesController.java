package com.accenture.tpFinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.tpFinal.model.Orden;
import com.accenture.tpFinal.model.OrdenRepuesto;
import com.accenture.tpFinal.model.Repuesto;
import com.accenture.tpFinal.service.OrdenService;
import com.accenture.tpFinal.service.RepuestoService;

@Controller
public class EditarPagesController {

	@Autowired
	OrdenService ordenService;
	
	@Autowired
	RepuestoService repuestoService;
	
	@RequestMapping(path = "editarOrden/{id}", method=RequestMethod.GET)
	public ModelAndView editarOrdenController(@PathVariable("id")int id){
		ModelAndView model = new ModelAndView("editarOrden");
		model.addObject("id", id);
		return model;
	}
	
	@RequestMapping(path = "/abm/agregarRepuesto/{id}", method=RequestMethod.GET)
	public ModelAndView agregarRepuestoPage(@PathVariable("id")int id){
		ModelAndView model = new ModelAndView("abm/agregarRepuesto");
		model.addObject("idOrden", id);
		model.addObject("ordenRepuesto", new OrdenRepuesto());
		List<Repuesto> listaRepuestos = repuestoService.listar();
		model.addObject("listaRepuestos", listaRepuestos);
		return model;
	}


	
	
}

