package grid.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LevelsTest {

	@Test
	public void testLevelValidity() {
		// Level 1
		for (int i = 0; i < 10; i++) {
			int[] tiles = Levels.getTiles(1);
			int score = (int) Math.pow(2, tiles[0]) * (int) Math.pow(3, tiles[1]);
			assertTrue(score >= 24 && score <= 48);
		}

		// Level 2
		for (int i = 0; i < 10; i++) {
			int[] tiles = Levels.getTiles(2);
			int score = (int) Math.pow(2, tiles[0]) * (int) Math.pow(3, tiles[1]);
			assertTrue(score >= 54 && score <= 96);
		}

		// Level 3
		for (int i = 0; i < 10; i++) {
			int[] tiles = Levels.getTiles(3);
			int score = (int) Math.pow(2, tiles[0]) * (int) Math.pow(3, tiles[1]);
			assertTrue(score >= 108 && score <= 192);
		}

		// Level 4
		for (int i = 0; i < 10; i++) {
			int[] tiles = Levels.getTiles(4);
			int score = (int) Math.pow(2, tiles[0]) * (int) Math.pow(3, tiles[1]);
			assertTrue(score >= 216 && score <= 324);
		}

		// Level 5
		for (int i = 0; i < 10; i++) {
			int[] tiles = Levels.getTiles(5);
			int score = (int) Math.pow(2, tiles[0]) * (int) Math.pow(3, tiles[1]);
			assertTrue(score >= 384 && score <= 648);
		}

		// Level 6
		for (int i = 0; i < 10; i++) {
			int[] tiles = Levels.getTiles(6);
			int score = (int) Math.pow(2, tiles[0]) * (int) Math.pow(3, tiles[1]);
			assertTrue(score >= 648 && score <= 972);
		}

		// Level 7
		for (int i = 0; i < 10; i++) {
			int[] tiles = Levels.getTiles(7);
			int score = (int) Math.pow(2, tiles[0]) * (int) Math.pow(3, tiles[1]);
			assertTrue(score >= 1152 && score <= 1728);
		}

		// Level 8
		for (int i = 0; i < 10; i++) {
			int[] tiles = Levels.getTiles(8);
			int score = (int) Math.pow(2, tiles[0]) * (int) Math.pow(3, tiles[1]);
			assertTrue(score >= 2187 && score <= 3456);
		}
	}
}
