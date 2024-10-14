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
public class Postor {
    private static final float MIN_CAPITAL=1000;
    
    private static int numPostor=0;
    
    private String nombre;
    private float dineroDisponible;
    private ArrayList<Articulo> pujas;
    private ArrayList<Articulo> compras;
    
    
    public Postor(String nombre, float dinero){
        this.nombre=nombre;
        this.dineroDisponible=Math.max(dinero, MIN_CAPITAL);
        this.pujas=new ArrayList<>();
        this.compras=new ArrayList<>();
        
        numPostor++;
    }
    
    public Postor(String nombre){
        this(nombre, MIN_CAPITAL);
    }
    
    public boolean pujar(Articulo articulo, float puja){
        if(puja<=dineroDisponible){
            pujas.add(articulo);
            return true;
        }else{
            return false;
        }
    }
    
    public void asignarArticulo(Articulo articulo, float precio){
        compras.add(articulo);
        dineroDisponible -= precio;
    }
    
    public String toString(){
        String pujasStr = pujas.isEmpty() ? "No ha realizado ninguna puja." : "Ha pujado por " + pujas.size() + " articulos";
        String comprasStr = compras.isEmpty() ? "No ha comprado nada." : "Ha comprado " + compras.size() + " articulos";
        
        return "Postor: " + nombre +
                "\nDinero disponible: " + dineroDisponible +
                "\nPujas realizadas: " + pujasStr +
                "\nCompras realizadas: " + comprasStr;
    }
}
