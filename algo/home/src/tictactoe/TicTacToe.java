package tictactoe;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Let's start the game TIC TAC TOE.");
        System.out.print("Enter the name of Player1: ");
        String play1 = scan.nextLine();
        System.out.print("Enter the name of Player2: ");
        String play2 = scan.nextLine();

        boolean player1 = true;
        boolean gameEnded = false;

        while (!gameEnded) {
            drawBoard(board);

            if (player1) {
                System.out.println(play1 + "'s Turn (X): ");
            } else {
                System.out.println(play2 + "'s Turn (O): ");
            }

            char c = '-';
            if (player1) {
                c = 'X';
            } else {
                c = 'O';
            }


            // input of player will be row number and column number
            int row = 0;
            int col = 0;

            while (true) {
                System.out.print("Enter a row number (0, 1, or 2): ");
                row = scan.nextInt();
                System.out.print("Enter a column number (0, 1, or 2): ");
                col = scan.nextInt();
                if (row < 0 || col < 0 || row > 2 || col > 2) {
                    System.out.println("This position is off the "+
                            "bounds of the board! Try again.");
                } else if (board[row][col] != '-') {
                    System.out.println("Someone has already made a "+
                            "move at this position! Try again.");
                } else {
                    break;
                }
            }



            board[row][col] = c;
            if (playerHasWon(board) == 'X') {
                System.out.println(play1 + " has won!");
                gameEnded = true;
            } else if (playerHasWon(board) == 'O') {
                System.out.println(play2 + " has won!");
                gameEnded = true;
            } else {
                if (boardIsFull(board)) {
                    System.out.println("It's a tie!");
                    gameEnded = true;
                } else {
                    player1 = !player1;
                }
            }
        }
        drawBoard(board);
        scan.close();
    }

    public static void drawBoard(char[][] board) {
        System.out.println("Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static char playerHasWon(char[][] board) {

        // check top to bottom
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] &&
                    board[i][1] == board[i][2] &&
                    board[i][0] != '-') {
                return board[i][0];
            }
        }

        // check left to right
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] &&
                    board[1][j] == board[2][j] &&
                    board[0][j] != '-') {
                return board[0][j];
            }
        }

        // check diagonal 1
        if (board[0][0] == board[1][1] &&
                board[1][1] == board[2][2] &&
                board[0][0] != '-') {
            return board[0][0];
        }

        // check diagonal 2
        if (board[2][0] == board[1][1] &&
                board[1][1] == board[0][2] &&
                board[2][0] != '-') {
            return board[2][0];
        }

        return ' ';
    }

    // check if the board is full
    public static boolean boardIsFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
