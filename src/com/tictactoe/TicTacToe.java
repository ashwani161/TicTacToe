package com.tictactoe;

import java.util.Scanner;

public class TicTacToe {
	public static char[][] board = { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };

	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe");
		initializeBoard();
		
	}

	public static void initializeBoard() {
		System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("-+-+-");
		System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("-+-+-");
		System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
		System.out.println("-+-+-");
	}

	
}
