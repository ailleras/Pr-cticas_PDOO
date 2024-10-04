/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_java_pdoo;

/**
 *
 * @author alejandro
 */
public class Practica_1 {
    
    public enum Directions{
        LEFT,
        RIGHT,
        UP,
        DOWN
    }
    
    public enum Orientation{
        VERTICAL,
        HORIZONTAL
    }
    
    public enum GameCharacter{
        PLAYER,
        MONSTER
    }
    
    
    
    public class Weapon{
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
        
        public static boolean discard(){
            return discardElement(usesLeft);
        }
    }
    
    
    public class Shield{
        private float protection;
        private int uses;
        
        public Shield(float protection, int uses){
            this.protection=protection;
            this.uses=uses;
        }
        
        public float protect(){
            if(uses>0){
                uses--;
                return protection;
            }else{
                return 0;
            }
        }
        
        public String toString(){
            return "S[" + protection + "," + uses + "]";
        }
        
        public float getProtection(){
            return protection;
        }
        
        public int getUses(){
            return uses;
        }
        
        public static boolean discard(){
            return discardElement(usesLeft);
        }
    }
    
    public class Dice{
        private static final int MAX_USES=5;
        private static final float MAX_INTELLIGENCE=10.0f;
        private static final float MAX_STRENGTH=10.0f;
        private static final float RESURRECT_PROB=0.3f;
        private static final int WEAPONS_REWARD=2;
        private static final int SHIELDS_REWARD=3;
        private static final int HEALTH_REWARD=5;
        private static final int MAX_ATTACK=3;
        private static final int MAX_SHIELD=2;
        
        
        private static Random generator = new Random();
        
        public static int randomPos(int max){
            return generator.nextInt(max);
        }
        
        public static int whoStarts(int nplayers){
            return generator.nextInt(nplayers);
        }
        
        public static float randomIntelligence(){
            return generator.nextFloat()*MAX_INTELLIGENCE;
        }
        
        public static float randomStrength(){
            return generator.nextFloat()*MAX_STRENGTH;
        }
        
        public static boolean resurrectPlayer(){
            return generator.nextFloat() < RESURRECT_PROB;
        }
        
        public static int weaponsReward(){
            return generator.nextInt(WEAPONS_REWARD + 1);
        }
        
        public static int shieldsReward(){
            return generator.nextInt(SHIELDS_REWARD + 1);
        }
        
        public static int healthReward(){
            return generator.nextInt(HEALTH_REWARD + 1);
        }
        
        public static float weaponPower(){
            return generator.nextFloat()*MAX_ATTACK;
        }
        
        public static float shieldPower(){
            return generator.nextFloat()*MAX_SHIELD;
        }
        
        public static int usesLeft(){
            return generator.nextInt(MAX_USES + 1);
        }
        
        public static float intensity(float competence){
            return generator.nextFloat()*competence;
        }
        
        public static boolean discardElement(int usesLeft){
            if(usesLeft >= MAX_USES){
                return false;
            }else if(usesLeft == 0){
                return true;
            }else{
                float probability = (float)*(MAX_USES - usesLeft) / MAX_USES;
                return generator.nextFloat() < probability;
            }
        }
        
    }
    
    public class GameState{
        private String labyrinth;
        private String players;
        private String monsters;
        private int currentPlayer;
        private boolean winner;
        private String log;
        
        
        public GameState(String labyrinth, String players, String monsters, int currentPlayer, boolean winner, String log){
            this.labyrinth=labyrinth;
            this.players=players;
            this.monsters=monsters;
            this.currentPlayer=currentPlayer;
            this.winner=winner;
            this.log=log;
        }
        
        public String getLabyrinth(){
            return labyrinth;
        }
        
        public String getPlayers(){
            return players;
        }
        
        public String getMonsters(){
            return monsters;
        }
        
        public int getCurrentPlayer(){
            return currentPlayer;
        }
        
        public boolean getWinner(){
            return winner;
        }
        
        public String getLog(){
            return log;
        }
        
        
    }
    
    
}
