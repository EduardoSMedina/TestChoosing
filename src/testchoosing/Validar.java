/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testchoosing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase utilizada para Validar los datos ingresados en los JFrame.
 */
public class Validar {
    public Validar(){
    }
    public boolean ValidarEntero(String str){
     Pattern pattern = Pattern.compile("[0-9]$");
        Matcher mather = pattern.matcher(str);
        if(mather.find() == true) {
            return true;
        } else {
            return false;
        }
    }
    public boolean ValidarItem(String str){
    if(str.equals("Seleccione Universidad")){
        return false;
    } else{
        return true;
        }
    }
    public boolean ValidarContraseña(String str){
    Admin adm = new Admin();
    if(str.equals(adm.getContraseña())){
        return true;
    }else{
        return false;
    }
    }
    public boolean ValidarVacio(String str){
    str=str.replaceAll(" ", "");
        if(str.length()==0){
           return false;
            
        }
        else
        {
            return true;
        }
    }
   public boolean ValidarString(String str){
    Pattern pattern = Pattern.compile("([A-Z,a-z])$");
        Matcher mather = pattern.matcher(str);
        if(mather.find() == true) {
           return true;
        } else {
           return false;
        }
   }
      public boolean ValidarTexto(String str){
    if(ValidarVacio(str)== false || ValidarString(str)== false){
        return false;
    }else{ return true;}
   }
      public boolean ValidarPuntaje(String str){
          if (ValidarEntero(str)== false || Double.parseDouble(str)<0 || Double.parseDouble(str)>850) {
              return false;
          }else{
            return true;
          }
      }
      public boolean ValidarPorcentaje(String nem, String rank, String leng, String mat, String cienc, String hist){
          double suma = 0;
          if(ValidarPuntaje(nem)== true || ValidarPuntaje(rank)== true|| ValidarPuntaje(leng)== true|| ValidarPuntaje(mat)== true|| ValidarPuntaje(cienc)== true|| ValidarPuntaje(hist)== true){
              suma = Double.parseDouble(nem)+Double.parseDouble(rank)+Double.parseDouble(leng)+Double.parseDouble(mat)+Double.parseDouble(cienc)+Double.parseDouble(hist);
              if (suma>100) {
                  return false;
              } else{
                    return true;
                }
          } else{
              return false;
          }
      }  
}
