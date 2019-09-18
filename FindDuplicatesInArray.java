package com.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FindDuplicatesInArray {

	public static void main(String[] args) {

		Integer[] duplicateNumbers = new Integer[] { 1, 2, 3, 2, 3, 1, 4 };

		System.out.println("Duplicates elements from array using brute force method");
		findDuplicatesByBruteForceMethod(duplicateNumbers);

		System.out.println("Duplicates elements from array using set data structure:");
		findDuplicatesUsingSet(duplicateNumbers);

		System.out.println("Duplicates elements from array using hash table");
		findDuplicatesUsingHashTable(duplicateNumbers);

	}

	// first solution: finding duplicates using brute force method
	private static void findDuplicatesByBruteForceMethod(Integer[] numbers) {

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i].equals(numbers[j])) {
					System.out.println("Found duplicate element in the array: " + numbers[i]);
				}
			}
		}
	}

	/*
	 * This Java method finds the duplicate entries in the array of Integer
	 * elements.
	 * 
	 * @param Integer[] array
	 */
	private static void findDuplicatesUsingSet(Integer[] numbers) {

		HashSet<Integer> set = new HashSet<>();

		for (Integer number : numbers) {

			if (set.add(number) == false) {
				System.out.println("found a duplicate element in array: " + number);
			}
		}
	}

	/*
	 * This method will find the duplicate entries in the array of integers and keep
	 * tracks the count of the repeated elements
	 */
	private static void findDuplicatesUsingHashTable(Integer[] numbers) {

		Map<Integer, Integer> nameAndCount = new HashMap<>();

		for (Integer number : numbers) {
			Integer count = nameAndCount.get(number);

			if (count == null) {
				nameAndCount.put(number, 1);
			} else {
				nameAndCount.put(number, ++count);
			}
		}

		Set<Entry<Integer, Integer>> entrySet = nameAndCount.entrySet();
		for (Entry<Integer, Integer> entry : entrySet) {

			if (entry.getValue() > 1) {
				System.out.println(
						"Duplicate element from array: " + entry.getKey() + " repeated " + entry.getValue() + " times");
			}
		}
	}
}
