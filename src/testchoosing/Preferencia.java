/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testchoosing;

/**
 * Clase que contiene los atributos de una Preferencia, con sus respectivos setter and getter.
 */
public class Preferencia {
    String nombre;
    String area;
    
    public Preferencia(String pref, String num){
    this.nombre = pref;
    this.area = num;
    }
    public String getNombre(){
    return this.nombre;
    }
    public void setNombre(String pref){
    this.nombre = pref;
    }
    public String getNumArea(){
    return this.area;
    }
    public void setNumArea(String ar){
    this.area = ar;
    }
}
