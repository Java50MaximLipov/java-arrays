package telran.arrays;

import java.util.Arrays;

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
		// returns array with no number at the given index
		int[] res = new int[array.length - 1];
		System.arraycopy(array, 0, res, 0, index);
		System.arraycopy(array, index + 1, res, index, res.length - index);
		return res;
	}

	public static int[] insertNumberSorted(int[] arraySorted, int number) {
		// takes sorted array and number to insert
		// returns sorted array with the given number at a proper position
		// apply the standard method of the class Arrays int binarySearch(int[]
		// arraySorted, int key)
		int index = Arrays.binarySearch(arraySorted, number);
		if (index < 0) {
			index = -(index + 1);
		}
		return insertNumber(arraySorted, index, number);
	}
}