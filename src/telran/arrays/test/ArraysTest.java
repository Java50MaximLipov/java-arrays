package telran.arrays.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import telran.arrays.ArraysInt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

public class ArraysTest {
	private static final int N_ELEMENTS = 1000000;
	private static final int N_RUNS = 1000000;

	@Test
	void initialTest() {
		int[] ar1 = { 1, 2, 3 };
		int[] ar2 = { 1, 2, 3 };
		int[] ar2_3 = ar2;
		assertFalse(ar1 == ar2);
		assertTrue(ar2 == ar2_3);
		assertArrayEquals(ar1, ar2);
		ar2_3[0] = 10;
		ar1[0] = 10;
		assertArrayEquals(ar1, ar2);

	}

	@Test
	void copyOfIntTest() {
		int[] ar1 = { 10, 5, 15 };
		int[] expected1 = { 10, 5, 15 };
		int[] expected2 = { 10, 5 };
		int[] expected3 = { 10, 5, 15, 0, 0 };
		assertArrayEquals(expected1, Arrays.copyOf(ar1, 3));
		assertArrayEquals(expected2, Arrays.copyOf(ar1, 2));
		assertArrayEquals(expected3, Arrays.copyOf(ar1, 5));
	}

	@Test
	void addNumberTest() {
		int[] ar1 = { 10, 5, 15 };
		int number = 20;
		int[] expected = { 10, 5, 15, number };
		assertArrayEquals(expected, ArraysInt.addNumber(ar1, number));
	}

	@Test
	void arraycopyTest() {
		int[] src = { 1, 2, 3, 4, 5, 6, 7 };
		int[] dest = { 10, 20, 30, 40, 50, 60, 70 };
		int[] expected = { 10, 20, 30, 40, 1, 2, 3 };
		System.arraycopy(src, 0, dest, 4, 3);
		assertArrayEquals(expected, dest);
	}

	@Test
	void insertNumberTest() {
		int[] src = { 1, 2, 3, 4, 5, 6, 7 };
		int number = 20;
		int index = 3;
		int[] expected1 = { 1, 2, 3, 20, 4, 5, 6, 7 };
		assertArrayEquals(expected1, ArraysInt.insertNumber(src, index, number));
		number = 30;
		index = 0;
		int[] expected2 = { 30, 1, 2, 3, 4, 5, 6, 7 };
		assertArrayEquals(expected2, ArraysInt.insertNumber(src, index, number));
		number = 40;
		index = 7;
		int[] expected3 = { 1, 2, 3, 4, 5, 6, 7, 40 };
		assertArrayEquals(expected3, ArraysInt.insertNumber(src, index, number));
	}

	@Test
	void removeNumberTest() {
		int[] src = { 1, 2, 3, 4, 5, 6, 7 };
		int index = 3;
		int[] expected1 = { 1, 2, 3, 5, 6, 7 };
		assertArrayEquals(expected1, ArraysInt.removeNumber(src, index));
		index = 0;
		int[] expected2 = { 2, 3, 4, 5, 6, 7 };
		assertArrayEquals(expected2, ArraysInt.removeNumber(src, index));
		index = 4;
		int[] expected3 = { 1, 2, 3, 4, 6, 7 };
		assertArrayEquals(expected3, ArraysInt.removeNumber(src, index));
	}

	@Test
	void binarySearchTest() {

		// int key)
		int[] src = { 10, 20, 30, 40, 50, 60, 70 };
		assertEquals(3, Arrays.binarySearch(src, 40));
		assertEquals(0, Arrays.binarySearch(src, 10));
		assertEquals(6, Arrays.binarySearch(src, 70));
		assertEquals(-1, Arrays.binarySearch(src, 5));
		assertEquals(-4, Arrays.binarySearch(src, 35));
		assertEquals(-8, Arrays.binarySearch(src, 75));
	}

	@Test
	void insertSortedTest() {
		int[] src = { 10, 20, 30, 40, 50, 60, 70 };
		int[] expected1 = { 10, 20, 30, 40, 40, 50, 60, 70 };
		int[] expected2 = { 10, 10, 20, 30, 40, 50, 60, 70 };
		int[] expected3 = { 10, 20, 30, 40, 50, 60, 70, 70 };
		int[] expected4 = { 5, 10, 20, 30, 40, 50, 60, 70 };
		int[] expected5 = { 10, 20, 30, 35, 40, 50, 60, 70 };
		int[] expected6 = { 10, 20, 30, 40, 50, 60, 70, 75 };

		assertArrayEquals(expected1, ArraysInt.insertNumberSorted(src, 40));
		assertArrayEquals(expected2, ArraysInt.insertNumberSorted(src, 10));
		assertArrayEquals(expected3, ArraysInt.insertNumberSorted(src, 70));
		assertArrayEquals(expected4, ArraysInt.insertNumberSorted(src, 5));
		assertArrayEquals(expected5, ArraysInt.insertNumberSorted(src, 35));
		assertArrayEquals(expected6, ArraysInt.insertNumberSorted(src, 75));
	}

	@Test
	void maxIntTest() {
		assertEquals(Integer.MAX_VALUE, getIntMax());
	}

	private int getIntMax() {
		int res = 1;
		while (res > 0) {
			res++;
		}

		return res - 1;
	}

	@Test
	@Timeout(3)
	void maxLongTest() {
		assertEquals(Long.MAX_VALUE, getLongMax());
	}

	private long getLongMax() {
		long res = 1;
		while (res > 0) {
			res *= 2;
		}

		return res - 1;
	}

//tests for HW #3
	@Test
	void muchRepeatedTest() {
		int array[] = new int[N_ELEMENTS];
		for (int i = 0; i < N_ELEMENTS / 2; i++) {
			array[i] = -1;
		}
		for (int i = 0; i < N_RUNS; i++) {
			assertEquals(N_ELEMENTS / 2, ArraysInt.binarySearch(array, 0));
		}
	}

	@Test
	void muchRepeatedSearchTest() {
		int array[] = new int[N_ELEMENTS];
		for (int i = 0; i < N_ELEMENTS / 2; i++) {
			array[i] = -1;
		}
		for (int i = 0; i < N_RUNS; i++) {
			assertEquals(N_ELEMENTS / 2, ArraysInt.searchNumber(array, 0));
		}
	}

	@Test
	void ArraysIntBinarySearchTest() {

		// int key)
		int[] src = { 10, 20, 30, 40, 50, 60, 70 };
		assertEquals(3, ArraysInt.binarySearch(src, 40));
		assertEquals(0, ArraysInt.binarySearch(src, 10));
		assertEquals(6, ArraysInt.binarySearch(src, 70));
		assertEquals(-1, ArraysInt.binarySearch(src, 5));
		assertEquals(-4, ArraysInt.binarySearch(src, 35));
		assertEquals(-8, ArraysInt.binarySearch(src, 75));
	}

	@Test
	void quickSortTest() {
		int array[] = getRandomArray();
		ArraysInt.quickSort(array);
		testSorted(array);
	}

	@Test
	void bubbleSortTest() {
		int array[] = getRandomArray();
		ArraysInt.bubbleSort(array);
		testSorted(array);
	}

	private void testSorted(int[] array) {
		for (int i = 1; i < array.length; i++) {
			assertTrue(array[i - 1] <= array[i]);
		}

	}

	private int[] getRandomArray() {
		int[] res = new int[N_ELEMENTS];
		Random gen = new Random();
		for (int i = 0; i < N_ELEMENTS; i++) {
			res[i] = gen.nextInt();
		}
		return res;
	}
}