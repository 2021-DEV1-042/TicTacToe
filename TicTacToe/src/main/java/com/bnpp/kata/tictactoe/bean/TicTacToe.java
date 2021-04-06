package com.bnpp.kata.tictactoe.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class TicTacToe {

	@Autowired
	public Board board;

	public void addPlayer(int row, int column) throws Exception {

		if (!board.validateUserInputData(row, column)) {
			throw new Exception("The given  input data is not in the range of 0 to 2 ");
		}

		if (!board.checkSelectedPositionIsEmptyOrNot(row, column)) {
			throw new Exception("The given position is occupied by another player");
		}

		board.addPlayer(row, column);
	}

	public char getPosition(int row, int column) {
		return board.getPosition(row, column);
	}

}
