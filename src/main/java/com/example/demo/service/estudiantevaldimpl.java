package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.DAO.estudiantesvalidacionesDao;
import com.example.demo.entities.estudiante;

public class estudiantevaldimpl  implements estudiantevalservice {
	@Autowired
	estudiantesvalidacionesDao estudiantedao;
	

	@Override
	public List<estudiante> listar() {
		// TODO Auto-generated method stub
		return  (List<estudiante>) estudiantedao.findAll();
	}

	@Override
	public estudiante foundbyId(long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public estudiante foundbyname(String Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(estudiante Student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh(long Id, estudiante Student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long Id) {
		// TODO Auto-generated method stub
		
	}
	

}
