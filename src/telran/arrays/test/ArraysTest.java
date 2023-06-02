package telran.arrays.test;

import org.junit.jupiter.api.Test;

import telran.arrays.ArraysInt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class ArraysTest {
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
}