package com.bnp.kata.tictactoe;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import com.bnpp.kata.tictactoe.bean.TicTacToe;

public class TicTacToeTest {
	private static final int INDEX_ZERO = 0;
	private static final int INDEX_ONE = 1;

	private TicTacToe ticTacToe;

	@Before
	public void setUp() {
		ticTacToe = new TicTacToe();

	}

	@Test
	public void playerShouldPlaceXInAnyPosition() {
		ticTacToe.addPlayer(INDEX_ONE, INDEX_ONE);
		assertThat(ticTacToe.getPosition(INDEX_ONE, INDEX_ONE), CoreMatchers.is('X'));
	}

	@Test
	public void playersShouldPlayAlternatively() {
		ticTacToe.addPlayer(0, 0);
		assertThat(ticTacToe.getCurrentPlayer(), CoreMatchers.is('X'));
		ticTacToe.addPlayer(1, 1);
		assertThat(ticTacToe.getCurrentPlayer(), CoreMatchers.is('O'));
	}

	@Test
	public void shouldReturnTrueWhenSelectedPositionIsEmpty() {
		assertThat(ticTacToe.checkSelectedPositionIsEmptyOrNot(INDEX_ZERO, INDEX_ZERO), CoreMatchers.is(true));
	}

}
