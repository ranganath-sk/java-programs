package com.example;

public class StringReverseExample {

	public static void main(String[] args) {

		// original string
		String str = "copy";
		System.out.println("Original String: " + str);

		// reversed string using StringBuffer
		String reversedStr = new StringBuffer(str).reverse().toString();
		System.out.println("Reversed string using StringBuffer: " + reversedStr);

		// reversed string using StringBuilder
		String reverseStrUsingSb = new StringBuilder(str).reverse().toString();
		System.out.println(reverseStrUsingSb);

		// reversed string through iteration
		String rev = reverse(str);
		System.out.println("Reversed string in Java through iteration: " + rev);

		// recursive method to reverse string in Java
		String recursiveStr = recursively(str);
		System.out.println("Reverse string in Java using Recursion: " + recursiveStr);
	}

	private static String reverse(String str) {

		StringBuilder st = new StringBuilder();

		char[] ch = str.toCharArray();

		for (int i = ch.length - 1; i >= 0; i--) {
			st.append(ch[i]);
		}

		return st.toString();
	}

	private static String recursively(String str) {

		if (str.length() < 2) {
			return str;
		}
		return recursively(str.substring(1)) + str.charAt(0);
	}
}
