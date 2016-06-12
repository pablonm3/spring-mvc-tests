package com.accenture.tpFinal.data.dao;
import java.util.List;


import com.accenture.tpFinal.model.Repuesto;

public interface RepuestosDao {
	
	public List<Repuesto> listar();
	public Repuesto get(int id);
	
}
