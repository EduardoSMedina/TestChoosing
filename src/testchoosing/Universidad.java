/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testchoosing;

/**
 * Clase que contiene los atributos de una Universidad, con sus respectivos setter and getter.
 */
public class Universidad {
    String nombre;
    String porcentNem;
    String porcentRanking;
    String porcentLenguaje;
    String porcentMatematica;
    String porcentCiencias;
    String porcentHistoria;
    String ptjcorte;
    public Universidad(){
    this.nombre = "";
    this.porcentNem = "";
    this.porcentRanking = "";
    this.porcentLenguaje = "";
    this.porcentMatematica  = "";
    this.porcentCiencias = "";
    this.porcentHistoria = "";
    this.ptjcorte = "";
    }
    public Universidad(String nom,String nem, String rank, String leng, String mat, String cienc, String hist, String corte){
    this.nombre = nom;
    this.porcentNem = nem;
    this.porcentRanking = rank;
    this.porcentLenguaje = leng;
    this.porcentMatematica  = mat;
    this.porcentCiencias = cienc;
    this.porcentHistoria = hist;
    this.ptjcorte = corte;
    }
    public String getNombre(){
    return this.nombre;
    }
    public void setNombre(String nom){
    this.nombre = nom;
    }
    public String getPorcentNem(){
    return this.porcentNem;
    }
    public void setPorcentNem(String nem){
    this.porcentNem = nem;
    }
    public String getPorcentRanking(){
    return this.porcentRanking;
    }
    public void setPorcentRanking(String rank){
    this.porcentRanking = rank;
    }
    public String getPorcentLenguaje(){
    return this.porcentLenguaje;
    }
    public void setPorcentLenguaje(String leng){
    this.porcentNem = leng;
    }
    public String getPorcentMatematica(){
    return this.porcentMatematica;
    }
    public void setPorcentMatematica(String mat){
    this.porcentMatematica = mat;
    }
    public String getPorcentCiencias(){
    return this.porcentCiencias;
    }
    public void setPorcentCiencias(String cienc){
    this.porcentCiencias = cienc;
    }
    public String getPorcentHistoria(){
    return this.porcentHistoria;
    }
    public void setPorcentHistoria(String hist){
    this.porcentHistoria = hist;
    }
    public String getPuntajeCorte(){
    return this.ptjcorte;
    }
    public void setPuntajeCorte(String corte){
    this.ptjcorte = corte;
    }
    
}
