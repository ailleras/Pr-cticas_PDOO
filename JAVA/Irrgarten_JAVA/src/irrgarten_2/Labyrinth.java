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
public class Labyrinth {
    // Atributos
    private int nRows;                  
    private int nCols;                  
    private Monster[][] monsters;        
    private Player[][] players;          
    private char[][] state;              

    public Labyrinth(int nRows, int nCols) {
        this.nRows = nRows;
        this.nCols = nCols;
        this.monsters = new Monster[nRows][nCols];
        this.players = new Player[nRows][nCols];
        this.state = new char[nRows][nCols];

        initializeLabyrinth();
    }

    private void initializeLabyrinth() {
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                state[i][j] = '-'; 
            }
        }        
        state[1][1] = 'X'; 
        state[nRows - 1][nCols - 1] = 'E'; 
    }

    public boolean haveAWinner() {
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (players[i][j] != null && state[i][j] == 'E') {
                    return true;
                }
            }
        }
        return false; 
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                sb.append(state[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    
    public boolean addMonster(int row, int col, Monster monster) {
        if (posOK(row, col) && emptyPos(row, col)) {
            monsters[row][col] = monster; 
            monster.setPos(row, col); 
            state[row][col] = 'M'; 
            return true;
        }
        return false;
    }

    public boolean posOK(int row, int col) {
        return row >= 0 && row < nRows && col >= 0 && col < nCols;
    }

    public boolean emptyPos(int row, int col) {
        return state[row][col] == '-';
    }

    public boolean monsterPos(int row, int col) {
        return state[row][col] == 'M';
    }

    public boolean exitPos(int row, int col) {
        return state[row][col] == 'E';
    }

    public boolean combatPos(int row, int col) {
        return state[row][col] == 'C';
    }

    public boolean canStepOn(int row, int col) {
        return posOK(row, col) && (emptyPos(row, col) || monsterPos(row, col) || exitPos(row, col));
    }

    public void updateOldPos(int row, int col) {
        if (posOK(row, col)) {
            if (state[row][col] == 'C') {
                state[row][col] = 'M'; 
            } else {
                state[row][col] = '-'; 
            }
        }
    }

    public int[] dir2Pos(int row, int col, Directions direction) {
        int[] newPos = new int[2];
        switch (direction) {
            case UP:
                newPos[0] = row - 1;
                newPos[1] = col;
                break;
            case DOWN:
                newPos[0] = row + 1;
                newPos[1] = col;
                break;
            case LEFT:
                newPos[0] = row;
                newPos[1] = col - 1;
                break;
            case RIGHT:
                newPos[0] = row;
                newPos[1] = col + 1;
                break;
        }
        return newPos;
    }

    public int[] randomEmptyPos() {
        Random rand = new Random();
        int row, col;
        do {
            row = rand.nextInt(nRows);
            col = rand.nextInt(nCols);
        } while (!emptyPos(row, col));
        return new int[]{row, col}; 
    }
    
    public void spreadPlayers(ArrayList<Player> players) {
    }

    public Monster putPlayer(Directions direction, Player player) {
        return null;
    }

    public void addBlock(Orientation orientation, int startRow, int startCol, int length) {
    }

    public ArrayList<Directions> validMoves(int row, int col) {
        return new ArrayList<>();
    }

    public Monster putPlayer2D(Player player) {
        return null;
    }
}
