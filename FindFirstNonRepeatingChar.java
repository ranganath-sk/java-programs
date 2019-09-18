package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FindFirstNonRepeatingChar {

	/*
	 * Using LinkedHashMap to find first non repeated character of String Algorithm:
	 * 
	 * Step 1: get character array and loop through it to build a hash table with
	 * char and their count
	 * 
	 * Step 2: loop through LinkedHashMap to find an entry with value 1, that's your
	 * first non repeated character, as LinkedHashMap maintains insertion order
	 */
	private static char getFirstNonRepeatingChar(String string) {
		Map<Character, Integer> counts = new LinkedHashMap<>(string.length());

		for (char c : string.toCharArray()) {
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
		}

		for (Entry<Character, Integer> entry : counts.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}

		throw new RuntimeException("didn't find any non repeated character in a given string");
	}

	private static char firstNonRepeatingChar(String string) {
		Set<Character> repeating = new HashSet<>();
		List<Character> nonRepeating = new ArrayList<>();

		for (int i = 0; i < string.length(); i++) {
			char letter = string.charAt(i);

			if (repeating.contains(letter)) {
				continue;
			}

			if (nonRepeating.contains(letter)) {
				nonRepeating.remove((Character) letter);
				repeating.add(letter);
			} else {
				nonRepeating.add(letter);
			}
		}

		return nonRepeating.get(0);
	}

	public static void main(String[] args) {
		char ch = firstNonRepeatingChar("sssstng");

		System.out.println("First non repeated character in the given string is: " + ch);
	}
}
