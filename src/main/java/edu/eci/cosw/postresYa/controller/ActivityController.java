/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.controller;
import edu.eci.cosw.postresYa.Exceptions.PostreException;
import edu.eci.cosw.postresYa.model.Actividad;
import edu.eci.cosw.postresYa.stub.Stub;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2095499
 */
@RestController
@RequestMapping(value="/actividades")
public class ActivityController {
    
    
    @Autowired
    Stub stub;
    /**
     * Constructor del controlador de postres
     */
    public ActivityController(){

    }
   
    /**
     * busca la lista de postres en el stub
     * @return un conjunto con los postres, en caso de que no tenga ningun postre devolvera un conjunto vacio
     */
    @RequestMapping(method = RequestMethod.GET)
    public Set<Actividad> getPostre() {
        

        return stub.getPostres();
    }
    
 
   
    
    /**
     * Añade un postre nuevo (el código de este no esta utilizado) a la lista de postres del stub
     * @param postre
     * @throws PostreException 
     */
    @RequestMapping (method = RequestMethod.POST)
    public void postPostre(@RequestBody Actividad postre) throws PostreException {
        stub.addPostre(postre);
    }
    

    
    
    
    /**
     * Busca la imagen a un postre asociado por medio de un código dado
     * @param code
     * @return ResponseEntity 
     */
    @RequestMapping(value="/{code}/picture", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getPostrePicture(@PathVariable String code){
        
      
        try{
        return ResponseEntity.ok().contentType(MediaType.parseMediaType("image/jpg")).body(new InputStreamResource(stub.getPostrePicture(code)));
        }catch(Exception e){
            
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }    
    }
    
    
}
