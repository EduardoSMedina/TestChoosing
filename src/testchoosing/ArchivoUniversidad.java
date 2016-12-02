
package testchoosing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Clase para crear, eliminar y  obtener la información de los Archivos .txt de las diferentes carreras.
 */
public class ArchivoUniversidad {
    File file;
     public ArchivoUniversidad(String str){
      this.file = new File(str);
     }
     public void AgregarArchivo(String str){
         try{ 
                FileWriter fw;
                BufferedWriter bw;
           if (this.file.exists()){
                 fw = new FileWriter(this.file,true);
                 bw = new BufferedWriter(fw);
                 bw.newLine();
                 bw.write(str);
           } else{
              fw = new FileWriter(this.file);
              bw = new BufferedWriter(fw);
              bw.write(str);
           }
            bw.close();
            fw.close();
         }catch(Exception e){
             System.out.println(e);
         }
    }
     public void EliminarFichero(){
         if(this.file.exists()){
        this.file.delete();
               
         }
     }
     public ArrayList <Universidad> ObtenerUniversidad(ArrayList <Universidad>  arrayList) { 
        /**
         * Obtiene segun la Carrera que escojamos, el nombre de las Universidades, con sus respectivos porcentajes de puntajes y puntaje de corte.
         */
        try{
        if(this.file.exists()){
            FileReader fr = new FileReader(this.file);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
            String [] contacto=linea.split("%");
            Universidad clas = new Universidad(contacto[0],contacto[1],contacto[2],contacto[3],contacto[4],contacto[5],contacto[6],contacto[7]); //El orden es nombre de Universidad,nem,ranking,leng,mat,cienc,hist,puntajeCorte.
            arrayList.add(clas);
            }
            fr.close();
            br.close();
        }
        }catch(Exception e){
            System.out.println(e);
        }
        
        return arrayList;
    }    
}
