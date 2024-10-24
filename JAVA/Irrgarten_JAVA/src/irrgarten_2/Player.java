/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten_2;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author alejandro
 */
public class Player {
    private static int playerCount=0;
    
    private String name;
    private int row, col;
    private int health;
    private int intelligence;
    private List<Weapon> weapons;
    private List<Shield> shields;
    private int consecutiveHits;
    
    public PLayer(int initialHealth, int intelligence){
        this.name="Player #" + (++playerCount);
        this.health=initialHealth;
        this.intelligence=intelligence;
        this.row=-1;
        this.col=-1;
        this.weapons=new ArrayList<>();
        this.shields=new ArrayList<>();
        this.consecutiveHits=0;
    }
    
    public void resurrect(){
        this.weapons.clear();
        this.shields.clear();
        this.health=100;
        this.consecutiveHits=0;
    }
    
    public void setPos(int row, int col){
        this.row=row;
        this.col=col;
    }
    
    public boolean dead(){
        return this.health <= 0;
    }
    
    public float attack(){
        return this.sumWeapons();
    }
    
    public boolean defend(float receivedAttack){
        return manageHit(receivedAttack);
    }
    
    public String toString() {
        return "Player(Name: " + this.name + ", Position: (" + this.row + ", " + this.col + "), " +
               "Health: " + this.health + ", Intelligence: " + this.intelligence + ", " +
               "Weapons: " + this.weapons.size() + ", Shields: " + this.shields.size() + ", " +
               "Consecutive Hits: " + this.consecutiveHits + ")";
    }
    
    public Weapon newWeapon() {
        Random random = new Random();
        float weaponPower = random.nextFloat() * 10;  
        Weapon weapon = new Weapon(weaponPower);
        this.weapons.add(weapon);
        return weapon;
    }
    
    public Shield newShield() {
        Random random = new Random();
        float shieldPower = random.nextFloat() * 10;  
        Shield shield = new Shield(shieldPower);
        this.shields.add(shield);
        return shield;
    }
    
    public float defensiveEnergy() {
        return this.intelligence + this.sumShields();
    }
    
    public void resetHits() {
        this.consecutiveHits = 0;
    }
    
    public void gotWounded() {
        if (this.health > 0) {
            this.health--;
        }
    }
    
    public void incConsecutiveHits() {
        this.consecutiveHits++;
    }
    
    public float sumWeapons() {
        float totalAttack = 0;
        for (Weapon weapon : weapons) {
            totalAttack += weapon.attack();
        }
        return totalAttack;
    }
    
    public float sumShields() {
        float totalProtection = 0;
        for (Shield shield : shields) {
            totalProtection += shield.protect();
        }
        return totalProtection;
    }
    
    private boolean manageHit(float receivedAttack) {
        return false; 
    }
    
    public Directions move(Directions direction, ArrayList<Directions> validMoves) {
        return null;
    }
    
    public void receiveReward() {
    }
    
    public void receiveWeapon(Weapon w) {
    }
    
    public void receiveShield(Shield s) {
    }
}
