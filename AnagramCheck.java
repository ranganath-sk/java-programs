package com.example;

import java.util.Arrays;

/*
 * Java program - String anagram example
 * This program checks if two Strings are anagram or not
 */
public class AnagramCheck {

	/*
	 * One way to check if two strings are anagram in Java. This method assumes that
	 * both arguments are not null and in lowercase
	 * 
	 * @return true, if both are anagram
	 */
	private static boolean isAnagramCheck(String word, String anagram) {
		if (word.length() != anagram.length()) {
			return false;
		}

		char[] chars = word.toCharArray();

		for (char ch : chars) {
			int index = anagram.indexOf(ch);

			if (index != -1) {
				anagram = anagram.substring(0, index) + anagram.substring(index + 1, anagram.length());
			} else {
				return false;
			}
		}

		return anagram.isEmpty();
	}

	/*
	 * Another way to check if two strings are anagram or not in Java. This method
	 * assumes both methods are not null and in lowercase
	 * 
	 * @return true, if two strings are anagram
	 */

	private static boolean isAnagramBySort(String word, String anagram) {
		char[] charFromWord = word.toCharArray();
		char[] charFromAnagram = anagram.toCharArray();

		// sort both character array
		Arrays.sort(charFromAnagram);
		Arrays.sort(charFromWord);

		return Arrays.equals(charFromWord, charFromAnagram);
	}

	private static boolean checkAnagram(String firstString, String secondString) {

		char[] characters = firstString.toCharArray();
		StringBuilder sb = new StringBuilder(secondString);

		for (char ch : characters) {
			int index = sb.indexOf("" + ch);

			if (index != -1) {
				sb.deleteCharAt(index);
			} else {
				return false;
			}
		}

		return sb.length() == 0 ? true : false;
	}

	public static void main(String[] args) {
		boolean isAnagram = isAnagramCheck("mary", "army");

		System.out.println(isAnagram);

		boolean isAna = isAnagramBySort("stop", "pots");
		System.out.println(isAna);

		boolean isAnagramAgain = checkAnagram("mosa", "soma");
		System.out.println(isAnagramAgain);
	}
}
