package com.game.bowling;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GameTest {
	Game game;

	@Before
	public void setUp() {
		game = new Game();
	}
	
	@Test
	public void canScoreGutterGame() {
//		roll(20, 0);
		game.roll(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
		assertThat(game.score(), is(0));
	}
	
	@Test
	public void canScoreGameOfOnes() {
//		roll(20, 1);
		game.roll(1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1);
		assertThat(game.score(), is(20));
	}
	
	@Test
	public void canScoreSpareFollowedByThree() {
//		game.roll(5);
//		game.roll(5);
//		game.roll(3);
//		roll(17, 0);
		game.roll(5,5, 3,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
		assertThat(game.score(), is(16));
	}
	
	@Test
	public void canScoreStrikeFollowedByThreeThenThree() {
		game.roll(10, 3,3, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
		assertThat(game.score(), is(22));
	}
	
	@Test
	public void canScorePerfectGame() {
		game.roll(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);		
		assertThat(game.score(), is(300));
	}
}