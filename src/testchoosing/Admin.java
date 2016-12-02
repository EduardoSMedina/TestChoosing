
package testchoosing;
/**
 * Clase que contiene la contraseña del Admin, con su respectivo setter and getter.
 */
public class Admin {
    Archivo cont;
    String contraseña;
    public Admin(){
        /**
         * El Constructor, busca el archivo Contraseña.txt y obtiene su contenido, guardandolo en un String contraseña.
         */
        this.cont = new Archivo("Contraseña.txt");
        this.contraseña = cont.ObtenerContraseña(contraseña);
    }
    public String getContraseña(){
        return this.contraseña;
    }
    public void setContraseña(String str){
        this.cont.EliminarFichero();
        this.cont.AgregarArchivo(str);
    }
    
}
