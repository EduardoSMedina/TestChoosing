
package testchoosing;

import java.util.ArrayList;
/**
     * Clase que contiene los atributos de una Carrera, con sus respectivos setter and getter.
     */
public class Carrera {
    
    String nombre;
    ArrayList<Universidad> universidades;
    String area;
    public Carrera(String nom, String ar, ArrayList<Universidad> uni){
    this.nombre = nom;
    this.area = ar;
    this.universidades = uni;
    }
    public String getNombre(){
    return this.nombre;
    }
    public void setNombre(String nom){
    this.nombre = nom;
    }
    public String getArea(){
        return this.area;
    }
    public void setArea(String area){
    this.area = area;
    }
    public ArrayList<Universidad> getUniversidad(){
    return this.universidades;
    }
    public void setUniversidad(ArrayList<Universidad> uni){
    this.universidades = uni;
    }
}
