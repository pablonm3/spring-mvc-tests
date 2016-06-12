package com.accenture.tpFinal.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.accenture.tpFinal.data.dao.OrdenesDao;
import com.accenture.tpFinal.data.dao.PropietariosDao;
import com.accenture.tpFinal.data.daoImpl.GenericDao;
import com.accenture.tpFinal.data.daoImpl.OrdenesDaoImpl;
import com.accenture.tpFinal.data.daoImpl.PropietariosDaoImpl;
import com.accenture.tpFinal.model.Orden;
import com.accenture.tpFinal.model.Propietario;
import com.accenture.tpFinal.service.IOrdenService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:WEB-INF/spring-config.xml")
public class testOrdenesDaoImpl{

	private static OrdenesDao ordenDao = new OrdenesDaoImpl();
	
	@Test
	public void testGet() {
		/* VERIFICAR LA CORREPONDENCIA DE LOS DATOS SOLICITADOS
		EN LA BASE DE DATOS*/
		Orden o= ordenDao.get(0);
		assertEquals(o.getMarca(), "audi");
	}
	
}
