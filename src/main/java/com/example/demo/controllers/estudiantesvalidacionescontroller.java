package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.FieldError;

import com.example.demo.entities.estudiante;
import com.example.demo.service.estudiantevalservice;

@RestController
@RequestMapping("/estudiantes")
public class estudiantesvalidacionescontroller {
	@Autowired
	 estudiantevalservice estudianteservice;
	@GetMapping()
	public List<estudiante> listadoEstudiantes(){
		
		return estudianteservice.listar();}
	
	@GetMapping("/{variable}")
	public estudiante buscarEstudiante(@PathVariable String e) {
		
		if(e.matches("-?\\d+")) {
			long Id = Long.parseLong(e);
			
			return estudianteservice.foundbyId(Id);	
			
		}else {
			
			return estudianteservice.foundbyname(e);
			
		}
		
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public void crearEstudiante( @RequestBody estudiante Estudiante) {
		estudianteservice.create(Estudiante);
	}
	
	@PutMapping("/{id}")
	public void actualizar(@PathVariable long Id, @RequestBody estudiante Estudiante) {
		estudianteservice.refresh(Id, Estudiante);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable long Id) {
		estudianteservice.delete(Id);
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex){
		
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		
		return errors;
	}
	
	
	
}
