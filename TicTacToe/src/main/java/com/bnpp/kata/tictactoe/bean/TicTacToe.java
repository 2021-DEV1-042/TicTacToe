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
	private static final String GAME_CONTINOUS = "Game Continues";
	private static final String GAME_DRAW = "The Game is Draw";

	@Autowired
	public Board board;

	public String addPlayer(int row, int column) throws PositionOutOfRangeException, PositionNotAvailableException   {

		if (!board.validateUserInputData(row, column)) {
			throw new PositionOutOfRangeException(INPUT_DATA_EXCEPTION);
		}

		if (!board.checkSelectedPositionIsEmptyOrNot(row, column)) {
			throw new PositionNotAvailableException(POSITION_NOT_EMPTY_EXCEPTION);
		}

		board.addPlayer(row, column);
		String gameResult;
		if (checkWinner()) {
			gameResult = String.valueOf(board.getCurrentPlayer());
		} 
		else if (isGameDraw()) {
			gameResult = GAME_DRAW;
		}else {
			gameResult = GAME_CONTINOUS;
		}
		return gameResult;
	}

	public char getPosition(int row, int column) {
		return board.getPosition(row, column);
	}
	
	public boolean checkWinner() {
		return board.checkColumnsForWin() || board.checkRowsForWin() || board.checkDiagonalsForWin();
	}
	
	public boolean isGameDraw() {
		return board.checkIfBoardFullyOccupied();
	}
}
