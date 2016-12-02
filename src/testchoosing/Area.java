
package testchoosing;

/**
 *Contiene atributos principales de un área con sus respectivos setter and getter.
 */
public class Area {
   
    String nombre; 
    String num;
    public Area(){
    this.nombre = "";
    this.num = "";
    }
    public Area(String nom, String num){
    this.nombre = nom;
    this.num = num;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nom){
        this.nombre = nom;
    }
    public String getNumero(){
        return this.num;
    }
    public void setNumero(String num){
        this.num = num;
    }
   
}
