
package testchoosing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *    Clase que contiene los métodos para crear, eliminar y obtener información de los archivos.
 */
public class Archivo {
     File file;
     public Archivo(String str){
      this.file = new File(str);
     }
     public void AgregarArchivo(String str){
         /**
          * Agrega una linea de texto a un archivo .txt, definido como parámetro en el constructor.
          */
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
    public ArrayList <Carrera> ObtenerListaCarreras(ArrayList <Carrera>  arrayList) { 
        /**
        * Obtiene los datos de un archivo .txt y los guarda en un ArrayList. Definido para usar con el archivo Carreras.txt y guardarlo en el ArrayList carreras de la Clase ManejoDeArchivos.
        */
        try{
        if(this.file.exists()){
            FileReader fr = new FileReader(this.file);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
            String [] contacto=linea.split("%");
            ArrayList<Universidad> uni = new ArrayList<Universidad>();
            ArchivoUniversidad arch = new ArchivoUniversidad(contacto[0]+".txt");
            uni = arch.ObtenerUniversidad(uni);
            Carrera clas = new Carrera(contacto[0],contacto[1], uni);
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
    public ArrayList <Area> ObtenerArea(ArrayList <Area>  arrayList) { //Contiene la Lista de Areas, con un nombre y el numero asignado a cada Area
        /**
        * Obtiene los datos de un archivo .txt y los guarda en un ArrayList. Definido para usar con el archivo Areas.txt y guardarlo en el ArrayList areas de la Clase ManejoDeArchivos.
        */
        try{
        if(this.file.exists()){
            FileReader fr = new FileReader(this.file);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
            String [] contacto=linea.split("%");
            Area clas = new Area(contacto[0],contacto[1]);
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
    public ArrayList <Preferencia> ObtenerPreferencias(ArrayList <Preferencia>  arrayList) { //Obtiene la preferencia, junto a su numero de Area a la cual pertenece
        /**
        * Obtiene los datos de un archivo .txt y los guarda en un ArrayList. Definido para usar con el archivo Preferencias.txt y guardarlo en el ArrayList preferencias de la Clase ManejoDeArchivos.
        */
        try{
        if(this.file.exists()){
            FileReader fr = new FileReader(this.file);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
            String [] contacto=linea.split("%");
            Preferencia clas = new Preferencia(contacto[0],contacto[1]);
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
    public ArrayList <String> ObtenerRespuestas(ArrayList <String>  arrayList) { //Obtiene la preferencia, junto a su numero de Area a la cual pertenece
        try{
        /**
        * Obtiene los datos de un archivo .txt y los guarda en un ArrayList. Definido para usar con el archivo Respuestas.txt y guardarlo en el ArrayList resp de la Clase ManejoDeArchivos. Este archivo a la hora se ser obtenido, es Eliminado.
        */
        if(this.file.exists()){
            FileReader fr = new FileReader(this.file);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
            arrayList.add(linea);
            }
            fr.close();
            br.close();
        }
        }catch(Exception e){
            System.out.println(e);
        }
        EliminarFichero();
        return arrayList;
    }
    public String ObtenerContraseña(String str){
       /**
        * Obtiene los datos de un archivo .txt y los guarda en un String. Definido para usar con el archivo Contraseña.txt y guardarlo en el String contraseña de la Clase Admin.
        */ 
        try{
        if(this.file.exists()){
            FileReader fr = new FileReader(this.file);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
            str =linea;
            }
            fr.close();
            br.close();
        }
        }catch(Exception e){
            System.out.println(e);
        }
       
        return str;
    }
    
   
}

