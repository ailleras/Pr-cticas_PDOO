/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author alejandro
 */
public class Weapon {
    private float power;
        private int uses;
        
        public Weapon(float power, int uses){
            this.power=power;
            this.uses=uses;
        }
        
        public float attack(){
            if(uses>0){
                uses--;
                return power;
            }else{
                return 0;
            }
        }
        
        public String toString(){
            return "W[" + power + "," + uses + "]";
        }
        
        public float getPower(){
            return power;
        }
        
        public int getUses(){
            return uses;
        }
        
        public boolean discard(){
            return Dice.discardElement(uses);
        }
}
