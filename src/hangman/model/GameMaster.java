package hangman.model;

import java.util.Random;
import java.util.Scanner;

import hangman.template.Templates;
import hangman.view.ConsoleView;

public class GameMaster {
	/** 
	 * ゲームマスター
	 * ゲームの進行を担当するクラスです。
	 * */
	
	/* フィールド */
	private String[] ANSWERS = {"apple", "banana", "lemon"};
	private String answer; // 答え
	private String question; // 問題
	private User user; // ユーザー
	private Hangman hangman; // hangman
	private ConsoleView view;
	
	
	/* メソッド */
	/* ゲームの初期化 */
	public void initialize() {
		
		// ゲーム開始を表示
		view = new ConsoleView();
		view.setTemplate(Templates.initialMessage);
		
		// 初期化処理
		hangman = new Hangman();
		// 答えの設定
		answer = ANSWERS[new Random().nextInt(ANSWERS.length)];
		// 問題設定
		question = answer.replaceAll(".", "_");
	}
	
	/* ゲームの設定 */
	public void gameSetting() {
		// ユーザー設定
		view.setTemplate(Templates.userSettingMessage);
		Scanner sc = new Scanner(System.in);
		user = new User(sc.nextLine());
	}
	
	/* ゲーム開始  */
	public void startGame() {
		
		// 問題を表示
		resultOutput();
		
		while(!isFinish()) {
			// ｱﾙﾌｧﾍﾞｯﾄ入力してください。
			char inputCharacter = userInput();
			
			// 存在チェック処理
			check(inputCharacter);
			
			//　表示処理
			resultOutput();
		}
		
	}
	
	/* ユーザー入力 */
	private char userInput() {
		boolean isCharacter = false;
		char[] result = null;
		
		// キャラクターチェック
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
		
		// 文字が含まれているかチェック
		if(answer.indexOf(inputChar) != -1) {
			
			int index = 0;
			StringBuilder newQuestion = new StringBuilder(question);
			
			// 含まれていた場合、該当するｱﾙﾌｧﾍﾞｯﾄを表示
			for(char answerChar : answer.toCharArray()) {
				
				if(answerChar == inputChar) {
					newQuestion.setCharAt(index, inputChar);
				}
				index++;
			}
			
			question = newQuestion.toString();
			
		} else {
			// 含まれていなかった場合、首を吊る
			if(hangman.hasNext())
				hangman.next();
		}
		
	}
	
	private void resultOutput() {
		// hangmanの表示
		hangman.view();
		
		// 問題の表示
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
	
	/* ゲームの終了処理 */
	public void finishGame() {
		
		if(hangman.hasNext()) {
			view.setTemplate(Templates.clearMessage);
		} else {
			view.setTemplate(Templates.gameOverMessage);			
		}
		view.setTemplate(Templates.finishMessage);
		
	}

}
