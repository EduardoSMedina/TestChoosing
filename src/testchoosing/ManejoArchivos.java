
package testchoosing;
import java.util.ArrayList;

/**
 * Clase que Maneja todos los ArrayList y Archivos.txt . Adquiriendo, calculando y mostrando los resultados pedidos por los JFrame. 
 */


public class ManejoArchivos {
   ArrayList<Area> areas;
   ArrayList<Carrera>carreras;
   ArrayList<Preferencia>preferencias;
   ArrayList<String> resp;
   ArrayList<String> carr;
   ArrayList<String> areasSelected;
   Archivo area;
   Archivo carrera;
   Archivo pref;
   Archivo res;
   Validar valid;
   public ManejoArchivos(){  
   /**
    * En el Constructor se inicia los ArrayList, obteniendo la información de sus respectivos archivos.txt .
    */    
   this.area = new Archivo("Areas.txt");
   this.areas = new ArrayList<Area>();
   this.areas = area.ObtenerArea(this.areas);
   this.carrera = new Archivo("Carreras.txt");
   this.carreras = new ArrayList<Carrera>();
   this.carreras = carrera.ObtenerListaCarreras(this.carreras);
   this.preferencias = new ArrayList<Preferencia>();
   this.pref = new Archivo("Preferencias.txt");
   this.preferencias = pref.ObtenerPreferencias(this.preferencias);
   this.resp = new ArrayList<String>();
   this.res = new Archivo("Respuestas.txt");
   this.resp = res.ObtenerRespuestas(this.resp);
   this.carr = new ArrayList<String>();
   this.valid = new Validar();
   this.areasSelected = new ArrayList<String>();
   }
 
  public String ObtenerAreaPreferencia(String pref, String resp){
      /**
       * Éste método Obtiene la respuesta del Test, y en caso de ser Si, retorna el número de Area de la preferencia mostrada.En caso de ser No, retorna 0.
       */
      
      String str = "0";
      if(resp.equals("Si")){
          str = getAreaPreferencia(pref);
      }
      return str;
  }
    public String getAreaPreferencia(String pref){
        /**
         * Busca la preferencia escojida dentro del ArrayList y retorna el número de área de dicha preferencia.
         */
        for (int i = 0; i < this.preferencias.size(); i++) {
          if(this.preferencias.get(i).getNombre().equals(pref)){
          return this.preferencias.get(i).getNumArea();
          }
      }
        return "";
  }
    
    public String ObtenerNomAreaPreferencia(String str){
        /**
         * Busca el número de área ingresado en el ArrayList areas, y retorna el nombre de área de dicho número.
         */
        for (int i = 0; i < this.areas.size(); i++) {
            if(this.areas.get(i).getNumero().equals(getAreaPreferencia(str))){
                return this.areas.get(i).getNombre();
            }
        }
        return "";
    }
    public boolean VerificarRespDistintoCero(){
        /**
         * Verifica si existe alguna respuesta distinta a cero en el ArrayList resp.
         */
        for (int i = 0; i < this.resp.size(); i++) {
            if(this.resp.get(i).equals("0")){
             
            }else{
                return true;
            }
        }
            return false;
        
    }
   public void VerAreaMayor(){
       /**
        * Busca las áreas más repetidas, según el ArrayList respuestas, y crea un nuevo ArrayList areasSelected con dichas áreas.
        */
       String num="";
       int contmayor = 0;
       for (int i = 0; i < this.areas.size(); i++) {
           num = this.areas.get(i).getNumero();
          if(contarRepeticiones(num,this.resp)>contmayor){
           contmayor = contarRepeticiones(num,this.resp);    
           this.areasSelected.clear();
           this.areasSelected.add(num);
           }else{
              if(contarRepeticiones(num,this.resp)== contmayor){
                  this.areasSelected.add(num);
              }
          }   
       }
   }
   public int contarRepeticiones(String n, ArrayList<String> str){
       /**
        * Retorna cuantas veces esta repetido un número en un ArrayList.
        */
   int cont = 0;
       for (int i = 0; i < str.size(); i++) {
           if(Integer.parseInt(str.get(i))== Integer.parseInt(n)){
           cont++;
           }
       }
         return cont;
   }
 
   public void CrearRespuestasTxt(){
       /**
        * Crea un nuevo archivo con los datos del ArrayList resp.
        */
       Archivo arch = new Archivo("Respuestas.txt");
       for (int i = 0; i < this.resp.size(); i++) {
           arch.AgregarArchivo(this.resp.get(i));
       }
   }
  
   public String getNumArea(String ar){
       /**
        * Retorna el número de área, de un área ingresada.
        */
       for (int i = 0; i < this.areas.size(); i++) {
           if(this.areas.get(i).getNombre().equals(ar)){
               return this.areas.get(i).getNumero();
           }
       }
       return "";
   }
   
   public int getLargoAreasEscogidas(){
       /**
        * Retorna el largo del ArrayList areasSelected.
        */
   VerAreaMayor();
   return this.areasSelected.size();
   }
  
   public int getLargoPreferenciasCarreras(String ar){
       /**
        * Retorna el largo de la lista de carreras, que contienen el área ingresada.
        */
       this.carr.clear();
       this.carr = ObtenerCarrera(ar);   
      return this.carr.size();
   
   }
   public ArrayList<String> ObtenerCarrera(String ar){
       /**
        * Retorna un nuevo ArrayList, con los datos del Nombre de las carreras, que contienen el área ingresada.
       */
       ArrayList<String> array = new ArrayList<String>();
       for (int i = 0; i < this.carreras.size(); i++) {
           if(this.carreras.get(i).getArea().equals(ar)){
           array.add(this.carreras.get(i).getNombre());
    }
       }
    
    return array;
   }
   public String ObtenerNombreArea(String num){
       /**
        * Obtiene el nombre del número de área ingresado.
        */
       String str= "";
       for (int i = 0; i < this.areas.size(); i++) {
           if(this.areas.get(i).getNumero().equals(num)){
           str = this.areas.get(i).getNombre();
           }
       }
       return str;
   }
   public String getPuntaje(String car,String uni, String nem, String rank, String mat, String leng, String cienc, String hist){
       /**
        * Obtiene los datos ingresados de una carrera, con el nombre, busca sus porcentajes, y retorna el puntaje ponderado.
        */
       String porcNem = "", porcRank = "", porcMat = "", porcLeng = "", porcCienc = "", porcHist= "";
       if(this.valid.ValidarPuntaje(nem)== false || this.valid.ValidarPuntaje(rank)== false|| this.valid.ValidarPuntaje(mat) == false || this.valid.ValidarPuntaje(leng) == false || this.valid.ValidarPuntaje(cienc)== false || this.valid.ValidarPuntaje(hist)== false|| this.valid.ValidarItem(uni) == false){
       return "Error";
       }else{
       for (int i = 0; i < this.carreras.size(); i++) {
           if (this.carreras.get(i).getNombre().equals(car)){
               for (int j = 0; j < this.carreras.get(i).universidades.size(); j++) {
                   if(this.carreras.get(i).universidades.get(j).getNombre().equals(uni)){
                        porcNem = this.carreras.get(i).universidades.get(j).getPorcentNem();
                        porcRank = this.carreras.get(i).universidades.get(j).getPorcentRanking();
                        porcMat = this.carreras.get(i).universidades.get(j).getPorcentMatematica();
                        porcLeng = this.carreras.get(i).universidades.get(j).getPorcentLenguaje();
                        porcCienc = this.carreras.get(i).universidades.get(j).getPorcentCiencias();
                        porcHist = this.carreras.get(i).universidades.get(j).getPorcentHistoria();
                   }
               }
           }
       }
       return String.valueOf(CalcularPuntaje(nem,rank,mat,leng,cienc,hist,porcNem,porcRank,porcMat,porcLeng,porcCienc,porcHist));
   } 
   }
   public Double CalcularPuntaje(String nem, String rank, String mat, String leng, String cienc, String hist, String porcNem, String porcRank, String porcMat, String porcLeng,String porcCienc, String porcHist){
       /**
        * Calcúla y Retorna el puntaje psu ponderado.
        */
       double promedio = (Double.parseDouble(nem)*Double.parseDouble(porcNem)+Double.parseDouble(rank)*Double.parseDouble(porcRank)+Double.parseDouble(mat)*Double.parseDouble(porcMat)+Double.parseDouble(leng)*Double.parseDouble(porcLeng)+Double.parseDouble(cienc)*Double.parseDouble(porcCienc)+Double.parseDouble(hist)*Double.parseDouble(porcHist))/100;
       return promedio;
   }
   public int ObtenerLargoUniversidad(String str){
       /**
        * Retorna el largo del ArrayList universidad, de una carrera ingresada.
        */
       for (int i = 0; i < this.carreras.size(); i++) {
           if(this.carreras.get(i).getNombre().equals(str)){
               return this.carreras.get(i).universidades.size();
           }
       }
       return 0;
   }
   public String ObtenerUniversidad(int num, String str){
       /**
        * Retorna el nombre de la Universidad, según el nombre de carrera y posición de la universidad requerida.
        */
       for (int i = 0; i < this.carreras.size(); i++) {
           if (this.carreras.get(i).getNombre().equals(str)) {
               return this.carreras.get(i).universidades.get(num).getNombre();
           }
       }
       return "";
   }
  

   public void AgregarPreferencia(String pref, String area){
       /**
        * Agrega una nueva preferencia al archivo, Preferencias.txt .
        */
       String ar = "", agregar;
       for (int i = 0; i < this.areas.size(); i++) {
           if(this.areas.get(i).getNombre().equals(area)){
           ar = this.areas.get(i).getNumero();
           }
       }
       agregar =pref+"%"+ar;
       this.pref.AgregarArchivo(agregar);
   }
   public void AgregarArea(String str){
       /**
        * Agrega una nueva área al archivo, Area.txt .
        */
       String ar = "";
       int cont = this.areas.size()+1;
       if(ExisteNumArea(String.valueOf(cont))){
           cont++;
       }
       ar =str+"%"+String.valueOf(cont);
       area.AgregarArchivo(ar);
   }
   public boolean ExisteNumArea(String num){
       /**
        * Verifica si existe el número de área.
        */
       for (int i = 0; i < this.areas.size(); i++) {
           if (this.areas.get(i).getNumero().equals(num)) {
               return true;
           }
       }
       return false;
   }
   
   public void AgregarCarrera(String carr, String ar, String uni,String nem,String rank, String leng, String mat, String cienc,String hist, String corte){
       /**
        * Agrega una nueva carrera al archivo, carreras.txt y una universidad al archivo de dicha carrera.
        */
       for (int i = 0; i < this.areas.size(); i++) {
        if(this.areas.get(i).getNombre().equals(ar)){
        ar = this.areas.get(i).getNumero();
    }
       }
   String carre =carr+"&"+ar;
   carrera.AgregarArchivo(carre);
   AgregarUniversidad(carr,uni,nem,rank,leng,mat,cienc,hist,corte);
   }
   public void AgregarUniversidad(String car,String uni, String nem, String rank, String leng, String mat, String cienc, String hist, String corte){
       /**
        * Agrega una nueva Universidad al archivo de la carrera ingresada.
        */
        String univ =uni+"%"+nem+"%"+rank+"%"+leng+"%"+mat+"%"+cienc+"%"+hist+"&"+corte;
        ArchivoUniversidad u = new ArchivoUniversidad(car+".txt");
        u.AgregarArchivo(univ);
   }
   public boolean ExisteUniversidad(String car, String uni){
       /**
        * Verifica si existe una Universidad .
        */
       for (int i = 0; i < this.carreras.size(); i++) {
           if(this.carreras.get(i).getNombre().equals(car)){
               for (int j = 0; j < this.carreras.get(i).universidades.size(); j++) {
                   if(this.carreras.get(i).universidades.get(j).getNombre().equals(uni)){
                   return false;
                   }
               }
           }
       }
       return true;
   }
   public boolean ExisteCarrera(String carr){
       /**
        * Verifica si existe una Carrera .
        */
       for (int i = 0; i < this.carreras.size(); i++) {
           if(this.carreras.get(i).getNombre().equals(carr)){
               return false;
           }
       }
       return true;
   }
   public boolean ExistePreferencia(String pref){
       /**
        * Verifica si existe una Preferencia .
        */
       for (int i = 0; i < this.preferencias.size(); i++) {
           if (this.preferencias.get(i).getNombre().equals(pref)) {
               return false;
           }
       }
       return true;
   }
   public boolean ExisteArea(String ar){
       /**
        * Verifica si existe una Area .
        */
     for (int i = 0; i < this.areas.size(); i++) {
           if (this.areas.get(i).getNombre().equals(ar)) {
               return false;
           }
       }
       return true;
   }
   public void EliminarArea(String ar){
       /**
        * Elimina un área ingresada .
        */
       for (int i = 0; i < this.areas.size(); i++) {
           if (this.areas.get(i).getNombre().equals(ar)) {
               this.areas.remove(i);
           }
       }
       area.EliminarFichero();
       CrearNuevoTxtArea();
   }
   public void CrearNuevoTxtArea(){
       /**
        * Crear un archivo Areas.txt con los datos actualizados.
        */
       String str;
       for (int i = 0; i < this.areas.size(); i++) {
           str = this.areas.get(i).getNombre()+"%"+this.areas.get(i).getNumero();
           area.AgregarArchivo(str);
       }
    }
   public void EliminarPreferencia(String ar){
       /**
        * Elimina una preferencia ingresada .
        */
       for (int i = 0; i < this.preferencias.size(); i++) {
           if (this.preferencias.get(i).getNombre().equals(ar)) {
               this.preferencias.remove(i);
           }
       }
       pref.EliminarFichero();
       CrearNuevoTxtPreferencias();
   }
   public void CrearNuevoTxtPreferencias(){
       /**
        * Crear un archivo Preferencias.txt con los datos actualizados.
        */
       String str;
       for (int i = 0; i < this.preferencias.size(); i++) {
           str = this.preferencias.get(i).getNombre()+"%"+this.preferencias.get(i).getNumArea();
           pref.AgregarArchivo(str);
       }
   }
   public void EliminarCarrera(String ar){
       /**
        * Elimina una carrera ingresada .
        */
       for (int i = 0; i < this.carreras.size(); i++) {
           if (this.carreras.get(i).getNombre().equals(ar)) {
               ArchivoUniversidad uni = new ArchivoUniversidad(this.carreras.get(i).getNombre()+".txt");
               uni.EliminarFichero();
               this.carreras.remove(i);
               
           }
       }
       carrera.EliminarFichero();
       CrearNuevoTxtCarrera();
   }
   public void CrearNuevoTxtCarrera(){
       /**
        * Crear un archivo Carreras.txt con los datos actualizados.
        */
       String str;
       for (int i = 0; i < this.carreras.size(); i++) {
           str = this.carreras.get(i).getNombre()+"%"+this.carreras.get(i).getArea();
           carrera.AgregarArchivo(str);
           ArchivoUniversidad uni = new ArchivoUniversidad(this.carreras.get(i).getNombre()+".txt");
           uni.EliminarFichero();
           for (int j = 0; j < this.carreras.get(i).universidades.size(); j++) {
               str = this.carreras.get(i).universidades.get(j).getNombre()+"%"+this.carreras.get(i).universidades.get(j).getPorcentNem()+"%"+this.carreras.get(i).universidades.get(j).getPorcentRanking()+"%"+this.carreras.get(i).universidades.get(j).getPorcentLenguaje()+"%"+this.carreras.get(i).universidades.get(j).getPorcentMatematica()+"%"+this.carreras.get(i).universidades.get(j).getPorcentCiencias()+"%"+this.carreras.get(i).universidades.get(j).getPorcentHistoria()+"%"+this.carreras.get(i).universidades.get(j).getPuntajeCorte();
               uni.AgregarArchivo(str);
           }
           
       }
   }
   public void GuardarArea(String ar, String nvaAr){
       /**
        * Envía los datos nuevos de una área a su respectiva posición del ArrayList .
        */
       for (int i = 0; i < this.areas.size(); i++) {
           if(this.areas.get(i).getNombre().equals(ar)){
               this.areas.get(i).setNombre(nvaAr);
           }
       }
       area.EliminarFichero();
       CrearNuevoTxtArea();
   }
   public void GuardarPreferencia(String pref, String newPref, String area){
       /**
        * Envía los datos nuevos de una prefrencia a su respectiva posición del ArrayList.
        */
       for (int i = 0; i < this.preferencias.size(); i++) {
           if(this.preferencias.get(i).getNombre().equals(pref)){
               this.preferencias.get(i).setNombre(newPref);
               this.preferencias.get(i).setNumArea(getNumArea(area));
           }
       }
       this.pref.EliminarFichero();
       CrearNuevoTxtPreferencias();
   }
   public int ObtenerNumCarrera(String str){
       /**
        * Retorna la posición de una carrera ingresada.
        */
       for (int i = 0; i < this.carreras.size(); i++) {
           if (this.carreras.get(i).getNombre().equals(str)) {
               return i;
           }
       }
      return 0;
   }
   public String ObtenerNombreAreaCarrera(String str){
       /**
        * Retorna el área de una carrera ingresada.
        */
       for (int i = 0; i < this.carreras.size(); i++) {
           if(this.carreras.get(i).getNombre().equals(str)){
               return ObtenerNombreArea(this.carreras.get(i).getArea());
           }
       }
       return "";
   }
   public int ObtenerPosicionUniversidad(int num, String uni){
       /**
        * Retorna la posición de una Universidad ingresada.
        */
       for (int i = 0; i < this.carreras.get(num).universidades.size(); i++) {
           if(this.carreras.get(num).universidades.get(i).nombre.equals(uni)){
               return i;
           }
       }
       return 0;
   }
   public void GuardarCarrera(String carr, String nvaCarr,String ar, String uni,String newUni, String nem, String rank, String leng, String mat, String cienc, String hist, String corte){
       ar = getNumArea(ar);
       /**
        * Envía los datos nuevos de una carrera a su respectiva posición del ArrayList .
        */
       for (int i = 0; i < this.carreras.size(); i++) {
           if(this.carreras.get(i).getNombre().equals(carr)){
               this.carreras.get(i).setNombre(nvaCarr);
               this.carreras.get(i).setArea(ar);
               for (int j = 0; j < this.carreras.get(i).universidades.size(); j++) {
                   if(this.carreras.get(i).universidades.get(j).getNombre().equals(uni)){
                       this.carreras.get(i).universidades.get(j).setNombre(newUni);
                       this.carreras.get(i).universidades.get(j).setPorcentNem(nem);
                       this.carreras.get(i).universidades.get(j).setPorcentRanking(rank);
                       this.carreras.get(i).universidades.get(j).setPorcentLenguaje(leng);
                       this.carreras.get(i).universidades.get(j).setPorcentMatematica(mat);
                       this.carreras.get(i).universidades.get(j).setPorcentCiencias(cienc);
                       this.carreras.get(i).universidades.get(j).setPorcentHistoria(hist);
                       this.carreras.get(i).universidades.get(j).setPuntajeCorte(corte);
                   }
               }
           }
       }
       this.carrera.EliminarFichero();
       CrearNuevoTxtCarrera();
   }
}
