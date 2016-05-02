/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.stub;

import edu.eci.cosw.postresYa.Exceptions.PostreException;
import edu.eci.cosw.postresYa.model.Actividad;
import java.io.IOException;
import java.io.InputStream;

import java.util.Set;

/**
 *
 * @author 2095499
 */
public interface Stub {
    Set<Actividad> getPostres();
    void addPostre(Actividad postre) throws PostreException;

    public Actividad getPostreByCode(String code) throws PostreException; 

    public InputStream getPostrePicture(String code) throws PostreException;
    
    
}
