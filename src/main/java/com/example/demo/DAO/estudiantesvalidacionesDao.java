package com.example.demo.DAO;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.estudiante;
import java.util.Optional;;

public interface estudiantesvalidacionesDao extends CrudRepository<estudiante, Long>{
	public Optional<estudiante> findByName(String Name);

}
