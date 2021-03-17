package com.tictactoe;

import java.util.Scanner;

public class TicTacToe {
	public static char[][] board = { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };

	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe");
		initializeBoard();
		chooseMove();
		displayBoard();
		selectBoard();
	}

	public static void initializeBoard() 
	{
		System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("-+-+-");
		System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("-+-+-");
		System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
		System.out.println("-+-+-");
	}

	public static void chooseMove() {
		System.out.println("Enter your move:");
		Scanner sc = new Scanner(System.in);
		String Move = sc.nextLine();
		if (Move.equalsIgnoreCase("X") || Move.equalsIgnoreCase("O")) {
			System.out.println("Enter row number:");
			int row = sc.nextInt();
			System.out.println("Enter column number:");
			int col = sc.nextInt();
			if (board[row - 1][col - 1] == 'X' || board[row - 1][col - 1] == 'O') {
				System.out.println("The place is already is filled");
				chooseMove();
			} else
				board[row - 1][col - 1] = Move.toUpperCase().toCharArray()[0];
		} else {
			System.out.println("Enter your valid move,either X or O");
		}
	}

	public static void displayBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				/*
				 * if (j == board[i].length - 1) System.out.print(board[i][j]); else
				 */
				System.out.print(board[i][j] + "   ");
			}
			System.out.println();
		}
	}
	public static void selectBoard() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Where would you like to play? (1-9)");
		String userInput = sc.nextLine();
		System.out.println(userInput);
		switch(userInput) {
			case "1":
				board[0][0] = 'X';
				break;
			case "2":
				board[0][1] = 'X';
				break;
			case "3":
				board[0][2] = 'X';
				break;
			case "4":
				board[1][0] = 'X';
				break;
			case "5":
				board[1][1] = 'X';
				break;
			case "6":
				board[1][2] = 'X';
				break;
			case "7":
				board[2][0] = 'X';
				break;
			case "8":
				board[2][1] = 'X';
				break;
			case "9":
				board[2][2] = 'X';
				break;
				default:
					System.out.println(" ");
				}
		displayBoard();
	}

}
