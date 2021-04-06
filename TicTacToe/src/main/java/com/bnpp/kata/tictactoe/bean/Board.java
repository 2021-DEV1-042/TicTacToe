package com.bnpp.kata.tictactoe.bean;

import org.springframework.context.annotation.Scope;

@Scope(value="prototype")
public class Board {

	private static final char INDEX_ZERO = 0;
	private static final char INDEX_ONE = 1;
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

	public boolean checkRowsForWin() {
		for (int row = INDEX_ZERO; row < INDEX_THREE; row++) {
			if ((board[row][INDEX_ZERO] != '\0') && (board[row][INDEX_ZERO] == board[row][INDEX_ONE]) && (board[row][INDEX_ONE] == board[row][INDEX_TWO])) {
				if (checkRowColumnContent(board[row][INDEX_ZERO], board[row][INDEX_ONE], board[row][INDEX_TWO])) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkColumnsForWin() {
		for (int column = INDEX_ZERO; column < INDEX_THREE; column++) {
			if ((board[column][INDEX_ZERO] != '\0') && (board[INDEX_ZERO][column] == board[INDEX_ONE][column]) && (board[INDEX_ONE][column] == board[INDEX_TWO][column])) {
				if (checkRowColumnContent(board[INDEX_ZERO][column], board[INDEX_ONE][column],
						board[INDEX_TWO][column])) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean checkRowColumnContent(char c1, char c2, char c3) {
		return ((c1 != '\0') && (c1 == c2) && (c2 == c3));
	}
	
	public boolean checkDiagonalsForWin() {
		boolean isTrue = true;
		return ((checkRowColumnContent(board[INDEX_ZERO][INDEX_ZERO], board[INDEX_ONE][INDEX_ONE], board[INDEX_TWO][INDEX_TWO]) == isTrue)
				|| (checkRowColumnContent(board[INDEX_ZERO][INDEX_TWO], board[INDEX_ONE][INDEX_ONE],
						board[INDEX_TWO][INDEX_ZERO]) == isTrue));
	}
	
	public boolean checkIfBoardFullyOccupied() {
		boolean isFull = true;
		for (int row = INDEX_ZERO; row < INDEX_THREE; row++) {
			for (int column = INDEX_ZERO; column < INDEX_THREE; column++) {
				if (board[row][column] == '\0') {
					isFull = false;
				}
			}
		}
		return isFull;
	}

}
