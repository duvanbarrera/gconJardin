/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.model;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 *
 * @author duvan
 */
public class Actividad {

    private String name;

    private String description;
   


    /**
     * Constructor inicial de postre
     */
    public Actividad(){
        
    }
    

    public Actividad(String name,String description){
        
        
        this.name=name;
      
        this.description=description;
        
    }

    
    /**
     * Busca el valor del nombre del postre
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Cambia el valor del nombre del postre
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }


    
    /**
     * Busca la descripción del postre
     * @return descripcion String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Cambia la descripción del postre
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
}