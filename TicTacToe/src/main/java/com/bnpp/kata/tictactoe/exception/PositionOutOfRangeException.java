package com.bnpp.kata.tictactoe.exception;

public class PositionOutOfRangeException extends Exception {

	
	private static final long serialVersionUID = 1L;

	public PositionOutOfRangeException(String exceptionMessage) {
		super(exceptionMessage);
	}

}
