package com.bnpp.kata.tictactoe.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bnpp.kata.tictactoe.exception.PositionNotAvailableException;
import com.bnpp.kata.tictactoe.exception.PositionOutOfRangeException;

@Component
@Scope(value = "prototype")
public class TicTacToe {
	
	private static final String INPUT_DATA_EXCEPTION = "The given  input data is not in the range of 0 to 2 ";
	private static final String POSITION_NOT_EMPTY_EXCEPTION = "The given position is occupied by another player";

	@Autowired
	public Board board;

	public void addPlayer(int row, int column) throws PositionOutOfRangeException, PositionNotAvailableException   {

		if (!board.validateUserInputData(row, column)) {
			throw new PositionOutOfRangeException(INPUT_DATA_EXCEPTION);
		}

		if (!board.checkSelectedPositionIsEmptyOrNot(row, column)) {
			throw new PositionNotAvailableException(POSITION_NOT_EMPTY_EXCEPTION);
		}

		board.addPlayer(row, column);
	}

	public char getPosition(int row, int column) {
		return board.getPosition(row, column);
	}

}
