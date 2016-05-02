/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.stub;

import edu.eci.cosw.postresYa.Exceptions.PostreException;
import edu.eci.cosw.postresYa.model.Actividad;
import java.io.BufferedInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.net.MalformedURLException;
import java.util.Iterator;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

/**
 *
 * @author 2095499
 */
@Service
public class StubActividad implements Stub{
   // private List<Postre> postres= new ArrayList<>();
   
    private static LinkedHashSet<Actividad> postres;
    private static LinkedHashMap<String, Actividad> postresMap;
    private static LinkedHashMap<String, String> postresImages;
    
    /**
     * El constructor del StubPostre instancia un nuevo objeto postre
     * y los almacena en memoria
     * @throws PostreException 
     */
    public StubActividad() throws PostreException {
        postres= new LinkedHashSet<>();
        postresMap= new LinkedHashMap<>();
        postresImages= new LinkedHashMap<>();
        Actividad prueba=new Actividad("vocales", "se deben enseñar las vocales con las que sean mas facil de escribir, en el siguiente orden i u e o a");
        postres.add(prueba);
        postresMap.put(prueba.getName(), prueba);
        postresImages.put(prueba.getName(),"src/main/resources/static/app/images/Postre1.png");
    }
    
    /**
     * 
     * @return un conjunto de postres
     */
    @Override
    public Set<Actividad> getPostres() {
        return postres;
    }
   
    /**
     * Añade un postre al stub, en caso de que no se pueda registrar se envía una excepción (PostreException)
     * @param Postre postre 
     * @throws PostreException 
     */
    @Override
    public void addPostre(Actividad postre) throws PostreException{
       
        postres.add(postre);
        postresMap.put(postre.getName(), postre);
        postresImages.put(postre.getName(),"src/main/resources/static/app/images/PostreNuevo.png");
    }

    /**
     * Busca un postre por medio del código asociado
     * @param code
     * @return
     * @throws PostreException si el postre a consultar no es encontrado
     */
    @Override
    public Actividad getPostreByCode(String code) throws PostreException{
        
        return postresMap.get(code);
    }
   
    /**Busca la imagen de un postre por medio del código asociado
     * 
     * @param code
     * @return InputStream con la imagen del producto solicitado
     * @throws PostreException si el postre no se encuentra
     */
    @Override
    public InputStream getPostrePicture(String code) throws PostreException {
          
        try {
            return new BufferedInputStream(
                    new FileInputStream(postresImages.get(code)));
            //return postresImages.get(code).openStream();
        } catch (FileNotFoundException ex) {
            
            throw new PostreException(PostreException.postreException);
           
        }      
        
    }
    

    
    

    
}
