package com.lab;

import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("===== Minesweeper Game =====");
        System.out.println("1. Load Mine Field from File");
        System.out.println("2. Create New Random Mine Field");
        System.out.print("Choose an option (1 or 2): ");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        Minesweeper game;
        
        if (choice == 1) {
            System.out.print("Enter mine field filename (e.g., 1): ");
            String filename = scanner.nextLine();
            game = new Minesweeper(filename);
        } else {
            System.out.print("Enter field width: ");
            int width = scanner.nextInt();
            System.out.print("Enter field height: ");
            int height = scanner.nextInt();
            System.out.print("Enter number of mines: ");
            int numMines = scanner.nextInt();

            game = new Minesweeper(width, height);
            game.placeRandomMines(numMines);
        }

        System.out.println("\nMine Field:");
        game.displayField();
    }
}
