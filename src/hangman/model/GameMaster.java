package hangman.model;

import java.util.Random;
import java.util.Scanner;

import hangman.template.Templates;
import hangman.view.ConsoleView;

public class GameMaster {
	/** 
	 * �Q�[���}�X�^�[
	 * �Q�[���̐i�s��S������N���X�ł��B
	 * */
	
	/* �t�B�[���h */
	private String[] ANSWERS = {"apple", "banana", "lemon"};
	private String answer; // ����
	private String question; // ���
	private User user; // ���[�U�[
	private Hangman hangman; // hangman
	private ConsoleView view;
	
	
	/* ���\�b�h */
	/* �Q�[���̏����� */
	public void initialize() {
		
		// �Q�[���J�n��\��
		view = new ConsoleView();
		view.setTemplate(Templates.initialMessage);
		
		// ����������
		hangman = new Hangman();
		// �����̐ݒ�
		answer = ANSWERS[new Random().nextInt(ANSWERS.length)];
		// ���ݒ�
		question = answer.replaceAll(".", "_");
	}
	
	/* �Q�[���̐ݒ� */
	public void gameSetting() {
		// ���[�U�[�ݒ�
		view.setTemplate(Templates.userSettingMessage);
		Scanner sc = new Scanner(System.in);
		user = new User(sc.nextLine());
	}
	
	/* �Q�[���J�n  */
	public void startGame() {
		
		// ����\��
		resultOutput();
		
		while(!isFinish()) {
			// ��̧�ޯē��͂��Ă��������B
			char inputCharacter = userInput();
			
			// ���݃`�F�b�N����
			check(inputCharacter);
			
			//�@�\������
			resultOutput();
		}
		
	}
	
	/* ���[�U�[���� */
	private char userInput() {
		boolean isCharacter = false;
		char[] result = null;
		
		// �L�����N�^�[�`�F�b�N
		while(!isCharacter) {
			view.setTemplate(Templates.typingMessage);
			Scanner sc = new Scanner(System.in);
			result = sc.nextLine().toCharArray();
			
			if(result.length == 1) {
				isCharacter = true;
			} else {
				view.setTemplate(Templates.typingErrorMessage);
			}
		}
		
		return result[0];
	}
	
	private void check(char inputChar) {
		
		// �������܂܂�Ă��邩�`�F�b�N
		if(answer.indexOf(inputChar) != -1) {
			
			int index = 0;
			StringBuilder newQuestion = new StringBuilder(question);
			
			// �܂܂�Ă����ꍇ�A�Y�������̧�ޯĂ�\��
			for(char answerChar : answer.toCharArray()) {
				
				if(answerChar == inputChar) {
					newQuestion.setCharAt(index, inputChar);
				}
				index++;
			}
			
			question = newQuestion.toString();
			
		} else {
			// �܂܂�Ă��Ȃ������ꍇ�A���݂�
			if(hangman.hasNext())
				hangman.next();
		}
		
	}
	
	private void resultOutput() {
		// hangman�̕\��
		hangman.view();
		
		// ���̕\��
		view.setTemplate(question);
		
	}
	
	private boolean isFinish() {
		
		if(!question.contains("_"))
			return true;

		if(!hangman.hasNext()) {
			return true;
		}
		
		return false;
	}
	
	/* �Q�[���̏I������ */
	public void finishGame() {
		
		if(hangman.hasNext()) {
			view.setTemplate(Templates.clearMessage);
		} else {
			view.setTemplate(Templates.gameOverMessage);			
		}
		view.setTemplate(Templates.finishMessage);
		
	}

}
