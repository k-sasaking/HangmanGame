package hangman.controller;

import hangman.model.GameMaster;

public class GameController {

	public void doGame() {
		
		GameMaster gm = new GameMaster();
		
		//�@�Q�[���̏�����
		gm.initialize();
		
		// �Q�[���̐ݒ�
		gm.gameSetting();
		
		// �Q�[���J�n
		gm.startGame();
		
		//�Q�[���I��
		gm.finishGame();
		
	}
	
}
