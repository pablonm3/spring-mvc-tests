package com.accenture.tpFinal.data.daoImpl;



import java.util.Collections;
import java.util.List;

import javax.persistence.criteria.AbstractQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.tpFinal.model.Propietario;


public class GenericDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public <T> List<T> listar(Class<T> clase)
	{		
		Session session = sessionFactory.openSession();
		List<T> lista = Collections.checkedList(session.createQuery("from " +
						clase.getName()).list(), clase);
		session.close();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> listar(Class<T> clase, String condition)
	{		
		Session session = sessionFactory.openSession();
		List<T> lista = Collections.checkedList(session.createQuery("from " +
						clase.getName() + " " + condition).list(), clase);
		session.close();
		return lista;
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public <T>void add(T entidad){
	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//Save the employee in database
        session.save(entidad);
        //Commit the transaction
        session.getTransaction().commit();
		session.close();
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public <T>void saveOrUpdate(T entidad){
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//Save the employee in database
        session.saveOrUpdate(entidad);
        //Commit the transaction
        session.getTransaction().commit();
		session.close();
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public <T> void borrar(T entidad){
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.delete(entidad);
		session.getTransaction().commit();
		session.close();
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public <T> void modificar(T entidad){
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.update(entidad);
		session.getTransaction().commit();
		session.close();
	}
	
	public <T> T get(Class <T> clase, int id){
		
		System.out.println("session: " + sessionFactory);
		System.out.println("clase: " + clase + "id: " + id);
		Session session = sessionFactory.openSession();
		T entidad = session.get(clase, id);
		session.close();
		return entidad;
	}
	
	
}
