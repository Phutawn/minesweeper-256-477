package com.lab;
 
import java.util.Scanner;
import java.io.InputStream;
import java.io.IOException;
 
public class Minesweeper {
    static char SAFE_CELL = '.';
    static char MINE_CELL = 'X';
    static int IS_SAFE = 0;
    static int IS_MINE = 1;
    int fieldX, fieldY;
    int[][] cells;
    String fieldFileName;
 
   
    public Minesweeper(String fieldFile) {
        this.fieldFileName = fieldFile;
        initFromFile(fieldFileName);
    }
 
    public Minesweeper(int fieldX, int fieldY) {
        this.fieldX = fieldX;
        this.fieldY = fieldY;
        this.cells = new int[fieldX][fieldY];
        for (int i = 0; i < fieldX; i++) {
            for (int j = 0; j < fieldY; j++) {
                cells[i][j] = IS_SAFE;
            }
        }
    }
 
   
    void displayField() {
        for (int row = 0; row < fieldY; row++) {
            for (int col = 0; col < fieldX; col++) {
                if (cells[row][col] == IS_MINE) {
                    System.out.print(MINE_CELL);
                } else {
                    System.out.print(SAFE_CELL);
                }
            }
            System.out.println();
        }
    }
 
   
    void setMineCell(int x, int y) {
        cells[x][y] = IS_MINE;
    }
 
   
    void initFromFile(String mineFieldFile) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(mineFieldFile);
       
        if (is == null) {
            System.out.println("File not found: " + mineFieldFile);
            return;
        }
 
        Scanner scanner = new Scanner(is);
       
     
        fieldX = scanner.nextInt();
        fieldY = scanner.nextInt();
 
        cells = new int[fieldY][fieldX];
 
 
        scanner.nextLine();
        for (int row = 0; row < fieldY; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < fieldX; col++) {
                if (line.charAt(col) == MINE_CELL) {
                    cells[row][col] = IS_MINE;
                } else {
                    cells[row][col] = IS_SAFE;
                }
            }
        }
 
        scanner.close();
    }
 
    public static void main(String[] args) throws IOException {
     
        Minesweeper game = new Minesweeper("minefield/minefield01.txt");
 
        game.displayField();
    }
}