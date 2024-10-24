/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten_2;
import java.util.Random;

/**
 *
 * @author alejandro
 */
public class Monster {
    private static final int INVALID_POS=-1;
    
    private int row;
    private int col;
    private float strength;
    private int health;
    private Random random;
    
    public Monster(float strength, int health){
        this.strength=strength;
        this.health=health;
        this.row=INVALID_POS;
        this.col=INVALID_POS;
        this.random=new Random();
    }
    
    public boolean dead(){
        return this.health <= 0;
    }
    
    public float attack(){
        return intensity(this.strength);
    }
    
    private float intensity(float strength){
        return random.nextFloat() * strength;
    }
    
    public void setPos(int row, int col){
        this.row=row;
        this.col=col;
    }
    
    public String toString(){
        return "Monster(Position: (" + this.row + ", " + this.col + "), " + 
                "Strength: " + this.strength + ", " + 
                "Health: " + this.health + ")";
    }
    
    public void gotWounded(){
        if(this.health > 0){
            this.health--;
        }
    }
    
    public boolean defend(float receivedAttack){
        return false;
    }
}
