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
public class Main {
    public static void main(String[] args){
        Articulo articulo1 = new Articulo("Trofeo",650);
        Articulo articulo2 = new Articulo("Espejo");
        Articulo articulo3 = new Articulo("Coche",1000);
        
        Postor postor1 = new Postor("Juan",2300);
        Postor postor2 = new Postor("Pedro");
        
        float[] pujasJuan = {700, 800};
        float[] pujasPedro = {600, 650};
        
        for(float puja : pujasJuan){
            if(postor1.pujar(articulo1, puja)){
                articulo1.anadirPuja(puja, postor1);
                System.out.println("Juan ha pujado " + puja + " por " + articulo1.getNombre());
            }else{
                System.out.println("Juan no tiene fuciente dinero");
            }
        }
        
        for(float puja : pujasJuan){
            if(postor1.pujar(articulo2, puja)){
                articulo2.anadirPuja(puja, postor1);
                System.out.println("Juan ha pujado " + puja + " por " + articulo2.getNombre());
            }else{
                System.out.println("Juan no tiene suficiente dinero");
            }
        }
        
        for(float puja : pujasJuan){
            if(postor1.pujar(articulo3, puja)){
                articulo3.anadirPuja(puja, postor1);
                System.out.println("Juan ha pujado " + puja + " por " + articulo3.getNombre());
            }else{
                System.out.println("Juan no tiene suficiente dinero");
            }
        }
        
        
        for(float puja : pujasPedro){
            if(postor2.pujar(articulo1, puja)){
                articulo1.anadirPuja(puja, postor2);
                System.out.println("Pedro ha pujado " + puja + " por " + articulo1.getNombre());
            }else{
                System.out.println("Pedro no tiene suficiente dinero");
            }
        }
        
        for(float puja : pujasPedro){
            if(postor2.pujar(articulo2, puja)){
                articulo2.anadirPuja(puja, postor2);
                System.out.println("Pedro ha pujado " + puja + " por " + articulo2.getNombre());
            }else{
                System.out.println("Pedro no tiene suficiente dinero");
            }
        }
        
        for(float puja : pujasPedro){
            if(postor2.pujar(articulo3, puja)){
                articulo3.anadirPuja(puja, postor2);
                System.out.println("Pedro ha pujado " + puja + " por " + articulo3.getNombre());
            }else{
                System.out.println("Pedro no tiene suficiente dinero");
            }
        }
        
        
        articulo1.asignarAMejorPostor();
        articulo2.asignarAMejorPostor();
        articulo3.asignarAMejorPostor();
        
        if(articulo1.getMejorPostor() != null){
            articulo1.asignarArticulo(articulo1, articulo1.getMejorPostor().getPujas());
        }
        
        if(articulo2.getMejorPostor() != null){
            articulo2.asignarArticulo(articulo2, articulo2.getMejorPostor().getPujas());
        }
        
        if(articulo3.getMejorPostor() != null){
            articulo3.asignarArticulo(articulo3, articulo3.getMejorPostor().getPujas());
        }
        
        
        System.out.println("\nEstado final de los artículos:");
        System.out.println(articulo1);
        System.out.println(articulo2);
        System.out.println(articulo3);

        System.out.println("\nEstado final de los postores:");
        System.out.println(postor1);
        System.out.println(postor2);
    }
}
