package com.dreyer.game;

import com.dreyer.connection.Connection;
import java.util.Scanner;

/**
 * 
 * Forca.java
 *
 * @author <a href="henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 29 de set de 2019
 *
 */
public class Forca {
	
	private int life = 6;
	private int howLetters = 6;
	
	private String word;	
	private Connection connection;
	private Scanner scanner;

	public Forca(Connection con) {
		connection = con;
		scanner = new Scanner(System.in);
	}

	public void showForca(int life) {
		if (life == 6) {
			System.out.println("|----------");
			System.out.println("|         |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println(" ");
		}
		if (life == 5) {
			System.out.println("|----------");
			System.out.println("|         |");
			System.out.println("|         O");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println(" ");
		}
		if (life == 4) {
			System.out.println("|----------");
			System.out.println("|         |");
			System.out.println("|         O");
			System.out.println("|         |");
			System.out.println("|");
			System.out.println("|");
			System.out.println(" ");

		}
		if (life == 3) {
			System.out.println("|----------");
			System.out.println("|         |");
			System.out.println("|         O");
			System.out.println("|      ---|");
			System.out.println("|          ");
			System.out.println("|");
			System.out.println(" ");
		}
		if (life == 2) {
			System.out.println("|----------");
			System.out.println("|         |");
			System.out.println("|         O");
			System.out.println("|      ---|---");
			System.out.println("|          ");
			System.out.println("|");
			System.out.println(" ");
		}
		if (life == 1) {
			System.out.println("|----------");
			System.out.println("|         |");
			System.out.println("|         O");
			System.out.println("|      ---|---");
			System.out.println("|        / ");
			System.out.println("|       / ");
			System.out.println(" ");
		}
		if (life == 0) {
			System.out.println("|----------");
			System.out.println("|         |");
			System.out.println("|         O");
			System.out.println("|      ---|---");
			System.out.println("|        / \\");
			System.out.println("|       /   \\");
			System.out.println(" ");
			System.out.println("VOCE PERDEU x_x");
		}
	}

	private void updateStatus() throws Exception {
		connection.sendMessage("getHowLetters()");
		howLetters = Integer.parseInt(connection.reciveMessage());

		connection.sendMessage("getLife()");
		life = Integer.parseInt(connection.reciveMessage());

		connection.sendMessage("getWord()");
		word = connection.reciveMessage();

	}

	public void showStatus() throws Exception {
		System.out.println("Tentativas Restantes: " + howLetters);
		System.out.println("Vida: " + life);
		System.out.println("PALAVRA: " + word);
	}

	public void startedStatus() {
		System.out.println("A palavra tem: " + howLetters + " letras");
		System.out.println("Vida: " + life);
	}

	private void endGame() throws Exception {
		
		if (life > 0) {
			System.out.println("Parabêns você venceu! ;) ");
		}
		
		connection.sendMessage("exit");
		System.out.println(connection.reciveMessage());
		
		connection.closeConection();
		connection.closeConection();
	}

	public void start() throws Exception {

		String letter;
		connection.sendMessage("startGame()");

		if (connection.reciveMessage().equals("started")) {

			updateStatus();
			startedStatus();
			showForca(life);
			while (life > 0 && howLetters > 0) {

				System.out.print("Digite uma letra:");
				letter = scanner.next();
				this.cleanScreen();

				while (letter.charAt(0) == ' ') {
					System.out.print("Digite uma letra:");
					letter = scanner.next();
				}
				connection.sendMessage(Character.toString(letter.charAt(0)).toUpperCase());
				updateStatus();
				showForca(this.life);
				showStatus();
			}
		}
		endGame();
	}

	public void cleanScreen() {
		for (int i = 0; i < 100; ++i) {
			System.out.println();
		}
	}

	public void start(Connection con) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
