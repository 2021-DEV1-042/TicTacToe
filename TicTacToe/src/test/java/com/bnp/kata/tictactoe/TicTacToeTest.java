package com.bnp.kata.tictactoe;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bnpp.kata.tictactoe.bean.Board;
import com.bnpp.kata.tictactoe.bean.TicTacToe;
import com.bnpp.kata.tictactoe.exception.PositionNotAvailableException;
import com.bnpp.kata.tictactoe.exception.PositionOutOfRangeException;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TicTacToe.class, Board.class })
public class TicTacToeTest {

	private static final int INDEX_ZERO = 0;
	private static final int INDEX_ONE = 1;
	private static final int INDEX_TWO = 2;
	private static final int INDEX_THREE = 3;

	@Autowired
	private TicTacToe ticTacToe;
	@Autowired
	private Board board;
	
	
	@Test
	public void playerShouldPlaceXInAnyPosition() throws Exception {
		ticTacToe.addPlayer(INDEX_ONE, INDEX_ONE);
		assertThat(ticTacToe.getPosition(INDEX_ONE, INDEX_ONE), CoreMatchers.is('X'));
	}

	@Test
	public void playersShouldPlayAlternatively() {
		board.addPlayer(INDEX_ZERO, INDEX_ZERO);
		assertThat(board.getCurrentPlayer(), CoreMatchers.is('X'));
		board.addPlayer(INDEX_ONE, INDEX_ONE);
		assertThat(board.getCurrentPlayer(), CoreMatchers.is('O'));
	}

	@Test
	public void shouldReturnTrueWhenSelectedPositionIsEmpty() {
		assertThat(board.checkSelectedPositionIsEmptyOrNot(INDEX_ZERO, INDEX_ZERO), CoreMatchers.is(true));
	}

	@Test
	public void shouldReturnTrueWhenPlayerGivenInvalidData() {
		assertThat(board.validateUserInputData(INDEX_TWO, INDEX_ZERO), CoreMatchers.is(true));
	}

	@Test(expected = PositionOutOfRangeException.class)
	public void shouldReturnExceptionWhenPlayerEnterIncorrectInputData() throws PositionOutOfRangeException, PositionNotAvailableException  {
		ticTacToe.addPlayer(INDEX_THREE, INDEX_ZERO);
	}
	
	@Test(expected=PositionNotAvailableException.class)
	public void shouldThroughExceptionWhenUserTryToFillAlreadyOccupiedPosition() throws PositionOutOfRangeException, PositionNotAvailableException  {
		ticTacToe.addPlayer(INDEX_TWO, INDEX_ZERO);
		ticTacToe.addPlayer(INDEX_TWO, INDEX_ZERO);

	}
	
	@Test
	public void gameShouldReturnTrueIfAnyHorizontalRowIsSame()  {
		board.addPlayer(INDEX_ZERO, INDEX_ZERO);
		board.addPlayer(INDEX_TWO, INDEX_ONE);
		board.addPlayer(INDEX_ZERO, INDEX_ONE);
		board.addPlayer(INDEX_ONE, INDEX_TWO);
		board.addPlayer(INDEX_ZERO, INDEX_TWO);
		assertThat(board.checkRowsForWin(), CoreMatchers.is(true));
	}
	
	@Test
	public void gameShouldReturnTrueIfAnyVerticalRowIsSame() throws Exception {
		board.addPlayer(INDEX_ZERO, INDEX_ZERO);
		board.addPlayer(INDEX_TWO, INDEX_TWO);
		board.addPlayer(INDEX_ONE, INDEX_ZERO);
		board.addPlayer(INDEX_ONE, INDEX_TWO);
		board.addPlayer(INDEX_TWO, INDEX_ZERO);
		assertThat(board.checkColumnsForWin(), CoreMatchers.is(true));
	}


}
