/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten_2;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author alejandro
 */
public class Game {
    // Atributos
    private ArrayList<Player> players;     
    private ArrayList<Monster> monsters;    
    private Labyrinth labyrinth;             
    private Player currentPlayer;            
    private int currentPlayerIndex;          
    private String log;                     
    private Random random;                   

    public Game(int numberOfPlayers, int nRows, int nCols) {
        this.players = new ArrayList<>();
        this.monsters = new ArrayList<>();
        this.labyrinth = new Labyrinth(nRows, nCols);
        this.random = new Random();
        this.log = "";
        initializePlayers(numberOfPlayers);
        currentPlayerIndex = random.nextInt(players.size()); 
        currentPlayer = players.get(currentPlayerIndex); 
        configureLabyrinth(); 
        spreadPlayers(); 
    }

    private void initializePlayers(int numberOfPlayers) {
        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(new Player(i)); 
        }
    }

    public boolean finished() {
        return labyrinth.haveAWinner(); 
    }

    public GameState getGameState() {
        return new GameState(players, monsters, labyrinth);
    }

    void configureLabyrinth() {
    }

    void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size(); 
        currentPlayer = players.get(currentPlayerIndex); 
    }

    void logPlayerWon() {
        log += "El jugador " + currentPlayer + " ha ganado el combate.\n";
    }

    void logMonsterWon() {
        log += "El monstruo ha ganado el combate.\n";
    }

    void logResurrected() {
        log += "El jugador " + currentPlayer + " ha resucitado.\n";
    }

    void logPlayerSkipTurn() {
        log += "El jugador " + currentPlayer + " ha perdido el turno por estar muerto.\n";
    }

    void logPlayerNoOrders() {
        log += "El jugador " + currentPlayer + " no siguió las instrucciones.\n";
    }

    void logNoMonster() {
        log += "El jugador se ha movido a una celda vacía o no le ha sido posible moverse.\n";
    }

    void logRounds(int rounds, int max) {
        log += "Se han producido " + rounds + " de " + max + " rondas de combate.\n";
    }

    private void spreadPlayers() {
        for (Player player : players) {
            int[] pos = labyrinth.randomEmptyPos(); 
            labyrinth.addPlayer(pos[0], pos[1], player); 
        }
    }

    public String getLog() {
        return log;
    }
    
    public boolean nextStep(Directions preferredDirection) {
        return false; 
    }

    public Directions actualDirection(Directions preferredDirection) {
        return preferredDirection; 
    }

    public GameCharacter combat(Monster monster) {
        return null; 
    }

    public void manageReward(GameCharacter winner) {
    }

    public void manageResurrection() {
    }
}
