package com.tictactoe;

import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {
	private static Scanner in = new Scanner(System.in);
	private static Board board = new Board();

	private static boolean gameEnded = false;
	private static boolean player = playerturn();
	private static boolean sessionEnded = false;

	public static void main(String[] args) {
		System.out.println(board);
		while (!sessionEnded) {
			while (!gameEnded) {
				Position position = null;
				if (player) {
					position = makeMove();
					board = new Board(board, position, PlayerSign.Cross);
				} else {
					board = computerMove(board);
				}
				player = !player;
				System.out.println(board);

			}

		}
	}

	private static boolean playerturn() {
		int turn = (int) (Math.random() * 10 % 2);
		if (turn == 0) {
			System.out.println("Player first");
			return true;
		} else {
			System.out.println("Computer first");
			return false;
		}

	}

	private static Board computerMove(Board board) {
		ArrayList<Position> positions = board.getFreePositions();
		Board bestChild = null;
		for (Position p : positions) {
			if ((p.getRow() == 0 && p.getColumn() == 0) || p.getRow() == 2 && p.getColumn() == 0
					|| p.getRow() == 2 && p.getColumn() == 2 || p.getRow() == 0 && p.getColumn() == 2) {
				return new Board(board, p, PlayerSign.Circle);
			}
		}
		for (Position p : positions) {
			if ((p.getRow() == 1 && p.getColumn() == 1)) {
				return bestChild = new Board(board, p, PlayerSign.Circle);
			}
		}
		for (Position p : positions) {
			return bestChild = new Board(board, p, PlayerSign.Circle);
		}

		return bestChild;

	}

	public static Position makeMove() {
		Position position = null;
		while (true) {
			System.out.print("Pick 1,2 or 3 for row: ");
			int row = getColOrRow();
			System.out.print("Pick 1,2 or 3 for column: ");
			int column = getColOrRow();
			position = new Position(column, row);
			if (board.isMarked(position))
				System.out.println("Already marked!");
			else
				break;
		}
		return position;
	}

	private static int getColOrRow() {
		int ret = -1;
		while (true) {
			try {
				ret = Integer.parseInt(in.nextLine());
			} catch (NumberFormatException e) {
			}
			if (ret < 1 | ret > 3)
				System.out.print("\nInvalid input. Please pick 1,2 or 3: ");
			else
				break;
		}
		return ret - 1;
	}
}

final class Position {
	private final int column;
	private final int row;

	public Position(int column, int row) {
		this.column = column;
		this.row = row;
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}
}

enum PlayerSign {
	Cross, Circle
}

enum GameState {
	Incomplete, CrossWin, CircleWin, Draw
}

class Board {
	private char[][] board; // e = empty, x = cross, o = circle.

	public Board() {
		board = new char[3][3];
		for (int y = 0; y < 3; y++)
			for (int x = 0; x < 3; x++)
				board[x][y] = 'e'; // Board initially empty
	}

	public Board(Board from, Position position, PlayerSign sign) {
		board = new char[3][3];
		for (int y = 0; y < 3; y++)
			for (int x = 0; x < 3; x++)
				board[x][y] = from.board[x][y];
		board[position.getColumn()][position.getRow()] = sign == PlayerSign.Cross ? 'x' : 'o';
	}

	public ArrayList<Position> getFreePositions() {
		ArrayList<Position> retArr = new ArrayList<Position>();
		for (int y = 0; y < 3; y++)
			for (int x = 0; x < 3; x++)
				if (board[x][y] == 'e')
					retArr.add(new Position(x, y));
		return retArr;
	}

	public boolean isMarked(Position position) {
		if (board[position.getColumn()][position.getRow()] != 'e')
			return true;
		return false;
	}

	public String toString() {
		String retString = "\n";
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				if (board[x][y] == 'x' || board[x][y] == 'o')
					retString += "[" + board[x][y] + "]";
				else
					retString += "[ ]";
			}
			retString += "\n";
		}
		return retString;
	}

}
