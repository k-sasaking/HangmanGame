package hangman.controller;

import hangman.model.GameMaster;

public class GameController {

	public void doGame() {
		
		GameMaster gm = new GameMaster();
		
		//　ゲームの初期化
		gm.initialize();
		
		// ゲームの設定
		gm.gameSetting();
		
		// ゲーム開始
		gm.startGame();
		
		//ゲーム終了
		gm.finishGame();
		
	}
	
}
