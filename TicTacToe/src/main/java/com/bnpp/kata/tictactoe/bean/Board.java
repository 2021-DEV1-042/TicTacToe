package com.bnpp.kata.tictactoe.bean;

public class Board {

	private static final char INDEX_ZERO = 0;
	private static final char INDEX_TWO = 2;
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

	public boolean validateUserInputData(int row, int column) {

		return (row > INDEX_TWO || row < INDEX_ZERO || column > INDEX_TWO || column < INDEX_ZERO) ? false : true;
	}

}
