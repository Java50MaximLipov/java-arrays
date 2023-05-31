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

//	HW-02
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
		index = 6;
		int[] expected3 = { 1, 2, 3, 4, 5, 6 };
		assertArrayEquals(expected3, ArraysInt.removeNumber(src, index));

	}

	@Test
	void binarySearchTest() {
		int[] arraySorted = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		int number = 50;
		assertEquals(4, Arrays.binarySearch(arraySorted, number));
		number = 10;
		assertEquals(0, Arrays.binarySearch(arraySorted, number));
		number = 90;
		assertEquals(8, Arrays.binarySearch(arraySorted, number));
		number = 1;
		assertEquals(-1, Arrays.binarySearch(arraySorted, number));
		assertTrue(Arrays.binarySearch(arraySorted, number) < 0);
	}

	@Test
	void insertSortedTest() {
		int[] arraySorted = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		int number = 50;
		int[] expected1 = { 10, 20, 30, 40, 50, 50, 60, 70, 80, 90 };
		assertArrayEquals(expected1, ArraysInt.insertNumberSorted(arraySorted, number));
		number = 0;
		int[] expected2 = { 0, 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		assertArrayEquals(expected2, ArraysInt.insertNumberSorted(arraySorted, number));
		number = 55;
		int[] expected3 = { 10, 20, 30, 40, 50, 55, 60, 70, 80, 90 };
		assertArrayEquals(expected3, ArraysInt.insertNumberSorted(arraySorted, number));
		number = 5;
		int[] expected4 = { 5, 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		assertArrayEquals(expected4, ArraysInt.insertNumberSorted(arraySorted, number));
		number = 95;
		int[] expected5 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 95 };
		assertArrayEquals(expected5, ArraysInt.insertNumberSorted(arraySorted, number));
		number = -10;
		int[] expected6 = { -10, 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		assertArrayEquals(expected6, ArraysInt.insertNumberSorted(arraySorted, number));

		int[] arrayUnsorted = { 30, 60, 20, 10, 40, 50 };
		number = 55;
		int[] expected7 = { 10, 20, 30, 40, 50, 55, 60 };
		Arrays.sort(arrayUnsorted);
		int[] arrayUnsortedSorted = Arrays.copyOf(arrayUnsorted, arrayUnsorted.length);
		assertArrayEquals(expected7, ArraysInt.insertNumberSorted(arrayUnsortedSorted, number));
	}
}