package com.bnpp.kata.tictactoe.bean;

public class TicTacToe {

	private char[][] board = new char[3][3];
	private char currentPlayer;

	public void addPlayer(int row, int column) {
		currentPlayer = getNextPlayer();
		board[row][column] = currentPlayer;

	}

	public char getPosition(int row, int column) {
		return board[row][column];
	}

	public char getNextPlayer() {
		if ('X' == currentPlayer) {

			return 'O';
		} else {
			return 'X';
		}
	}

	public char getCurrentPlayer() {
		return currentPlayer;
	}
}
