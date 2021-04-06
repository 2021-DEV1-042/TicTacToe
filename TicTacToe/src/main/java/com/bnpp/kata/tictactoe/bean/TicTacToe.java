package com.bnpp.kata.tictactoe.bean;

public class TicTacToe {
	private char[][] board = new char[3][3];

	public void play(int row, int column, char inputChar) {
		board[row][column] = inputChar;

	}

	public char getPosition(int row, int column) {
		return board[row][column];
	}
}
