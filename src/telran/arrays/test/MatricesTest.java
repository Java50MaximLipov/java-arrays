package telran.arrays.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static telran.arrays.MatricesInt.*;

class MatricesTest {

	@Test
	void multiplyConstantTest() {
		int[][] src = { { 1, 10, 20 }, { 30, -10, 15 } };
		int[][] expected = { { 2, 20, 40 }, { 60, -20, 30 } };
		assertArrayEquals(expected, multiplyConstant(src, 2));

	}

// HW-04
	@Test
	void getColumnTest() {
		int[][] src1 = { { 1, 10, 20 }, { 30, -10, 15 } };
		int[] expected1 = { 1, 30 };
		assertArrayEquals(expected1, getColumn(src1, 0));

		int[][] src2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[] expected2 = { 3, 6, 9 };
		assertArrayEquals(expected2, getColumn(src2, 2));

		int[][] src3 = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		int[] expected3 = { 3, 8, 13, 18, 23 };
		assertArrayEquals(expected3, getColumn(src3, 2));

		int[][] src4 = { { 1, 2, 3, 4, 5, 6, 7 }, { 8, 9, 10, 11, 12, 13, 14 }, { 15, 16, 17, 18, 19, 20, 21 },
				{ 22, 23, 24, 25, 26, 27, 28 }, { 29, 30, 31, 32, 33, 34, 35 }, { 36, 37, 38, 39, 40, 41, 42 },
				{ 43, 44, 45, 46, 47, 48, 49 } };
		int[] expected4 = { 6, 13, 20, 27, 34, 41, 48 };
		assertArrayEquals(expected4, getColumn(src4, 5));
	}

	@Test
	void transpMatrixTest() {
		int[][] src1 = { { 1, 10, 20 }, { 30, -10, 15 } };
		int[][] expected1 = { { 1, 30 }, { 10, -10 }, { 20, 15 } };
		assertArrayEquals(expected1, transpMatrix(src1));

		int[][] src2 = { { 2, 4, 6 }, { 8, 10, 12 }, { 14, 16, 18 } };
		int[][] expected2 = { { 2, 8, 14 }, { 4, 10, 16 }, { 6, 12, 18 } };
		assertArrayEquals(expected2, transpMatrix(src2));

		int[][] src3 = { { 5, 9 }, { 7, 11 }, { 13, 17 }, { 19, 23 } };
		int[][] expected3 = { { 5, 7, 13, 19 }, { 9, 11, 17, 23 } };
		assertArrayEquals(expected3, transpMatrix(src3));
	}

}