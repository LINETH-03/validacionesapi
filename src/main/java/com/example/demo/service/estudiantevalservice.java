package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.estudiante;

public interface estudiantevalservice {
	public List<estudiante> listar();
	
	public estudiante foundbyId(long Id);
	public estudiante foundbyname(String Name);
	public void create(estudiante Student);
	public void refresh(long Id, estudiante Student);
	public void delete(long Id);


}
