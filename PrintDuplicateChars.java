package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PrintDuplicateChars {

	public static void main(String[] args) {

		printDuplicateChars("programming");
		printDuplicateChars("java");
	}

	private static void printDuplicateChars(String word) {
		char[] characters = word.toCharArray();

		Map<Character, Integer> charMap = new HashMap<>();

		for (Character ch : characters) {
			if (charMap.containsKey(ch)) {
				charMap.put(ch, charMap.get(ch) + 1);
			} else {
				charMap.put(ch, 1);
			}
		}

		Set<Entry<Character, Integer>> entrySet = charMap.entrySet();
		for (Entry<Character, Integer> entry : entrySet) {
			if (entry.getValue() > 1) {
				System.out.printf("%s : %d\n", entry.getKey(), entry.getValue());
			}
		}
	}
}
