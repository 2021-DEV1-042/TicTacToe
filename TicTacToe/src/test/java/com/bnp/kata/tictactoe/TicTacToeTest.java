package com.bnp.kata.tictactoe;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import com.bnpp.kata.tictactoe.bean.TicTacToe;

public class TicTacToeTest {

	@Test
	public void playerShouldPlaceXInAnyPosition() {
		TicTacToe ticTacToe = new TicTacToe();
		ticTacToe.addPlayer(1, 1);
		assertThat(ticTacToe.getPosition(1, 1), CoreMatchers.is('X'));
	}
	
	@Test
	public void playersShouldPlayAlternatively() {
		TicTacToe ticTacToe = new TicTacToe();
		ticTacToe.addPlayer(0, 0);
		assertThat(ticTacToe.getCurrentPlayer(), CoreMatchers.is('X'));
		ticTacToe.addPlayer(1, 1);
		assertThat(ticTacToe.getCurrentPlayer(), CoreMatchers.is('O'));
	}

}
