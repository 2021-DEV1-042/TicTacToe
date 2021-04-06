package com.bnpp.kata.tictactoe.bean;

import org.springframework.stereotype.Component;

@Component
public class Board {

	private static final int INDEX_THREE = 3;
	private char[][] board = new char[INDEX_THREE][INDEX_THREE];
	private static final char FIRST_PLAYER = 'X';
	private static final char SECOND_PLAYER = 'O';
	private char currentPlayer;

	public void addPlayer(int row, int column) {

		currentPlayer = getNextPlayer();
		board[row][column] = currentPlayer;
	}

	public char getNextPlayer() {
		if (FIRST_PLAYER == currentPlayer) {

			return SECOND_PLAYER;
		} else {
			return FIRST_PLAYER;
		}
	}

	public char getPosition(int row, int column) {
		return board[row][column];
	}

	public char getCurrentPlayer() {
		return currentPlayer;
	}

	public boolean checkSelectedPositionIsEmpty(int row, int column) {
		return board[row][column] == '\0';
	}

}
