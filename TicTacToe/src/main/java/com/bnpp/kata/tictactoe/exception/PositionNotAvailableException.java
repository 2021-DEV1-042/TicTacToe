package com.bnpp.kata.tictactoe.exception;

public class PositionNotAvailableException extends Exception {

	private static final long serialVersionUID = 1L;
	

	public PositionNotAvailableException(String exceptionMessage) {
		super(exceptionMessage);
		
	}

}
