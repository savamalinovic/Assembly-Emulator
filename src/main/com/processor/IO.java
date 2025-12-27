package com.processor;

import java.util.Scanner;

public class IO {
	
	public static String input() {
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		scanner.close();

		return userInput.trim();
	}

	public static void output(String text) {
		System.out.println(text);
	}

}
