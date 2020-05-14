/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.human.service;

import com.udea.human.dao.IPersonDAO;
import com.udea.human.model.Persona;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
public class PersonaService {
    
        @Autowired
    private IPersonDAO dao;
    
    public Persona save(Persona t) {return dao.save(t);}
    public Persona update(Persona t) {return dao.save(t);}
    public void delete(Persona t) {dao.delete(t);}
    public Iterable<Persona> list() {return dao.findAll();}
    public Optional<Persona> listId(long id) {return dao.findById(id);}

    
    
}
