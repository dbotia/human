/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.human.controller;

import com.udea.human.exception.ModelNotFoundException;
import com.udea.human.model.Persona;
import com.udea.human.service.PersonaService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 *
 * @author Lenovo
 */
@RestController
@RequestMapping("/persona")
@CrossOrigin("*")
@Api(value="Employee Management System", description="Operations pertaining to employee in Person Management System")
public class PersonaController {
    
    @Autowired
PersonaService personService;

@ApiOperation(value = "Add a person")
@PostMapping("/save")
public long save(@ApiParam(value = "Employee object store in database table", required = true) @RequestBody Persona person){
personService.save(person);
return person.getIdPerson();
}

@ApiOperation(value = "View a list of available persons", response = List.class) 
@ApiResponses(value = {
@ApiResponse(code = 200, message = "Successfully retrieved list"),
    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
})     
@GetMapping("/listAll")
public Iterable<Persona> listAllPersons(){return personService.list();}

@ApiOperation(value = "Get a person by Id")
@GetMapping("/list/{id}")
public Persona listPersonById(@ApiParam(value = "Employee id from which employee object will retrieve", required = true) @PathVariable("id") int id){
Optional<Persona> person= personService.listId(id);
if(person.isPresent()){
   return person.get();
}

throw new ModelNotFoundException("ID de persona invalido");
}

    
    
}
