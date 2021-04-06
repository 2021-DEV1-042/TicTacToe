package com.bnpp.kata.tictactoe.bean;

public class TicTacToe {

	private static final char INDEX_THREE = 3;
	private static final char FIRST_PLAYER_X = 'X';
	private static final char SECOND_PLAYER_O = 'O';
	private char[][] board = new char[INDEX_THREE][INDEX_THREE];
	private char currentPlayer;

	public void addPlayer(int row, int column) {
		currentPlayer = getNextPlayer();
		board[row][column] = currentPlayer;

	}

	public char getPosition(int row, int column) {
		return board[row][column];
	}

	public char getNextPlayer() {

		return (FIRST_PLAYER_X == currentPlayer) ? SECOND_PLAYER_O : FIRST_PLAYER_X;
	}

	public char getCurrentPlayer() {
		return currentPlayer;
	}

	public boolean checkSelectedPositionIsEmptyOrNot(int row, int column) {
		return board[row][column] == '\0';
	}
}
