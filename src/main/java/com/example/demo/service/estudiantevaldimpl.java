package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.DAO.estudiantesvalidacionesDao;
import com.example.demo.Exceptions.NotFoundException;
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
		Optional<estudiante> opstudent = estudiantedao.findById(Id);
		if(opstudent.isPresent()) {
			return opstudent.get();
		
		}else {
			
			throw new NotFoundException("Id de Estudiante no encontrado");
		}
	}

	@Override
	public estudiante foundbyname(String Name) {
		Optional<estudiante> opName = estudiantedao.findByName(Name);
		
		if(opName.isPresent()) {
			
			return opName.get();
		}else {
			
			throw new NotFoundException("Estudiante No encontrado");
		}
		
		
	
	}

	@Override
	public void create(estudiante Student) {
		// TODO Auto-generated method stub
		estudiantedao.save(Student);
	}

	@Override
	public void refresh(long Id, estudiante Student) {
		// TODO Auto-generated method stub
		if(estudiantedao.existsById(Id)){
			Student.setId(Id);;
			estudiantedao.save(Student);
		}else {
			
			throw new NotFoundException("Estudiante No encontrado");
		}
		
	}

	@Override
	public void delete(long Id) {
		// TODO Auto-generated method stub
		if(estudiantedao.existsById(Id)) {
			estudiantedao.deleteById(Id);
			
		}else {
			
			throw new NotFoundException("Estudiante No encontrado");
		}
	}
	

}
