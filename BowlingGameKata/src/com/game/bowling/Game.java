package com.game.bowling;

public class Game {
	
	private int rollCounter = 0;
	private int[] rolls = new int[21];

	public void roll(int...rolls) {
		for (int pinsDown : rolls) {
			roll(pinsDown);
		}
	}
	
	public void roll(int pinsDown) {
		rolls[rollCounter++] = pinsDown;
	}

	public int score() {
		int score = 0;
		int frameCursor = 0;
		for (int frame = 0; frame < 10; frame++) {
			if (isStrike(frameCursor)) {
				score += 10 + bonusScoreForAStrike(frameCursor);
				frameCursor++;
			} else if (isSpare(frameCursor)) { 
				score += 10 + bonusScoreForASpare(frameCursor);
				frameCursor += 2;
			} else {
				score += normalScoreForAFrame(frameCursor);
				frameCursor += 2;
			}
		}
		return score;
	}

	private int bonusScoreForAStrike(int frameCursor) {
		return rolls[frameCursor+1] + rolls[frameCursor+2];
	}

	private int bonusScoreForASpare(int frameCursor) {
		return rolls[frameCursor+2];
	}

	private int normalScoreForAFrame(int frameCursor) {
		return rolls[frameCursor] + rolls[frameCursor+1];
	}

	private boolean isStrike(int frameCursor) {
		return rolls[frameCursor] == 10;
	}

	private boolean isSpare(int frameCursor) {
		return normalScoreForAFrame(frameCursor) == 10;
	}

}
