package com.bnp.kata.tictactoe;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import com.bnpp.kata.tictactoe.bean.TicTacToe;

public class TicTacToeTest {

	@Test
	public void playerShouldPlaceXInAnyPosition() {
		TicTacToe ticTacToe = new TicTacToe();
		ticTacToe.play(1, 1, 'X');
		assertThat(ticTacToe.getPosition(1, 1), CoreMatchers.is('X'));
	}

}
