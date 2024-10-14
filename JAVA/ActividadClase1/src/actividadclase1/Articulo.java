/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividadclase1;
import java.util.ArrayList;

/**
 *
 * @author alejandro
 */
public class Articulo {
    private static final float MIN_PRECIO_PARTIDA=500; //Constante
    
    private static int nArticulos=0;//atributos de clase
    private static int nVentas=0;
    
    private String nombre;//atributos instancia
    private float precioPartida;
    private Postor mejorPostor;
    private ArrayList<Postor> postores;
    
    public Articulo(String nombre, float precioPartida){//método articulo
        this.nombre=nombre;
        this.precioPartida=precioPartida;
        this.mejorPostor=null;
        this.postores=new ArrayList<>();
        nArticulos++;
    }
    
    public Articulo(String nombre){
        this(nombre, MIN_PRECIO_PARTIDA);
    }
    
    public void anadirPuja(float puja, Postor postor){//método anadirPuja
        if(puja>=precioPartida){
            this.postores.add(postor);
        }else{
            System.out.println("Puja rechazada");
        }
    }
    
    public void asignarAMejorPostor(){//método asignarAMejorPostor
        if(postores.isEmpty()){
            System.out.println("No hay postores.");
            return;
        }
        
        Postor mejor=postores.get(0);
        for(Postor postor : postores){
            if(postor.getPuja()>mejor.getPuja()){
                mejor = postor;
            }
        }
        
        this.mejorPostor=mejor;
        nVentas++;
        System.out.println("El mejor postor es: " + mejorPostor);
    }
    
    public String toString(){
        String mejorPostorStr = (mejorPostor != null) ? mejorPostor.getNombre() + " con una puja de " + mejorPostor.getPuja() : "No hay mejor postor";
        return "Articulo: " + nombre + 
                "\nPrecio de partida: " + precioPartida + 
                "\nMejor postor: " + mejorPostorStr + 
                "\nNumero de postores: " + postores.size();
    }
    
    public static int getNArticulos(){
        return nArticulos;
    }
    
    public static int getNVentas(){
        return nVentas;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public float getPrecioPartida(){
        return precioPartida;
    }
    
    public Postor getMejorPostor(){
        return mejorPostor;
    }
    
    public ArrayList<Postor> getPostores(){
        return postores;
    }
    
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setPrecioPartida(float precioPartida){
        this.precioPartida=precioPartida;
    }
    
    public void setMejorPostor(Postor mejorPostor){
        this.mejorPostor=mejorPostor;
    }
    
    public void anadirPuja2(float puja, Postor postor){
        if(puja>=precioPartida){
            this.postores.add(postor);
        }
    }
    
    public void asignarAMejorPostor2(){
        if(!postores.isEmpty()){
            Postor mejor = postores.get(0);
            for(Postor postor : postores){
                if(postor.getPuja()>mejor.getPuja()){
                    mejor=postor;
                }
            }
            this.mejorPostor=mejor;
            nVentas++;
        }
    }
}
