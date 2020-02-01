package hangman;

import hangman.controller.GameController;

public class HangmanGameMainClass {
	
	public static void main(String[] args) {		
		GameController gameController = new GameController();
		gameController.doGame();
	}
}
