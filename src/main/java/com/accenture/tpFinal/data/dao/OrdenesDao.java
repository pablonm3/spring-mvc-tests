package com.accenture.tpFinal.data.dao;


import java.util.List;
import com.accenture.tpFinal.model.Orden;
import com.accenture.tpFinal.model.Propietario;

public interface OrdenesDao {

		public List<Orden> listar();
		public List<Orden> listar(Propietario p);
		public Orden get(int id);
		public void add(Orden orden);
		public void borrar(Orden orden);
		public void modificar(Orden orden);
}
