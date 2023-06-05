package telran.arrays;

import java.util.Arrays;
import java.util.Random;

public class ArraysInt {
	public static int[] addNumber(int[] array, int number) {
		int[] res = Arrays.copyOf(array, array.length + 1);
		res[array.length] = number;
		return res;
	}

	public static int[] insertNumber(int[] array, int index, int number) {
		int[] res = new int[array.length + 1];
		System.arraycopy(array, 0, res, 0, index);
		res[index] = number;
		System.arraycopy(array, index, res, index + 1, array.length - index);
		return res;
	}

	public static int[] removeNumber(int[] array, int index) {
		int[] res = new int[array.length - 1];
		System.arraycopy(array, 0, res, 0, index);
		System.arraycopy(array, index + 1, res, index, res.length - index);
		return res;
	}

	public static int[] insertNumberSorted(int[] arraySorted, int number) {
		int index = Arrays.binarySearch(arraySorted, number);
		if (index < 0) {
			index = -(index + 1);
		}
		return insertNumber(arraySorted, index, number);
	}

	public static int searchNumber(int[] array, int number) {
		// searching for the given number in the given array
		// returns index value for the number if exists, otherwise -1
		int index = 0;
		while (index < array.length && array[index] != number) {
			index++;
		}
		return index < array.length ? index : -1;
	}

// HW-03 - Section Start
	public static int binarySearchNumber(int[] array, int number) {
		int left = 0;
		int right = array.length - 1;
		int middle = right / 2;
		while (left <= right && array[middle] != number) {
			if (number < array[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (left + right) / 2;
		}
		return left <= right ? getFirstIndexOf(array, middle, number) : -left - 1;
	}

	public static int getFirstIndexOf(int[] array, int index, int number) {
		while (index >= 0 && array[index] == number) {
			index--;
		}
		return index + 1;
	}

	public static int[] randomArrayGenerator(int min, int max, int length) {
		int[] res = new int[length];
		for (int i = 0; i < length; i++) {
			res[i] = getRandomInt(min, max);
		}
		return res;
	}

	public static boolean isArraySorted(int[] array) {
		boolean res = false;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] <= array[i + 1]) {
				res = true;
			}
		}
		return res;
	}
//HW-03 - Section End	

	public static void quickSort(int[] array) {
		Arrays.sort(array); // O[N*LogN]
	}

	public static void bubbleSort(int[] array) {
		int length = array.length;
		boolean flSorted = false;
		do {
			length--;
			flSorted = true;
			for (int i = 0; i < length; i++) {
				if (array[i] > array[i + 1]) {
					swap(array, i, i + 1);
					flSorted = false;
				}
			}
		} while (!flSorted);
	}

	private static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	private static int getRandomInt(int min, int max) {
		Random gen = new Random();
		return gen.nextInt(min, max + 1);
	}
}