package com.bnp.kata.tictactoe;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bnpp.kata.tictactoe.bean.Board;
import com.bnpp.kata.tictactoe.bean.TicTacToe;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TicTacToe.class, Board.class })
public class TicTacToeTest {

	private static final int INDEX_ZERO = 0;
	private static final int INDEX_ONE = 1;

	@Autowired
	private TicTacToe ticTacToe;
	@Autowired
	private Board board;

	@Test
	public void playerShouldPlaceXInAnyPosition() {
		ticTacToe.addPlayer(INDEX_ONE, INDEX_ONE);
		assertThat(ticTacToe.getPosition(INDEX_ONE, INDEX_ONE), CoreMatchers.is('X'));
	}

	@Test
	public void playersShouldPlayAlternatively() {
		board.addPlayer(0, 0);
		assertThat(board.getCurrentPlayer(), CoreMatchers.is('X'));
		board.addPlayer(1, 1);
		assertThat(board.getCurrentPlayer(), CoreMatchers.is('O'));
	}

	@Test
	public void shouldReturnTrueWhenSelectedPositionIsEmpty() {
		assertThat(board.checkSelectedPositionIsEmpty(INDEX_ZERO, INDEX_ZERO), CoreMatchers.is(true));
	}

}
