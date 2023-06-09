package telran.arrays.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static telran.arrays.MatricesInt.*;

import java.util.Random;

class MatricesTest {

	@Test
	void multiplyConstantTest() {
		int[][] src = { { 1, 10, 20 }, { 30, -10, 15 } };
		int[][] expected = { { 2, 20, 40 }, { 60, -20, 30 } };
		assertArrayEquals(expected, multiplyConstant(src, 2));

	}

	@Test
	void getColumnTest() {
		int[][] src = { { 1, 10, 20 }, { 30, -10, 15 } };
		int[] expected = { 1, 30 };
		assertArrayEquals(expected, getColumn(src, 0));
	}

	@Test
	void transpMatrixTest() {
		int[][] src = { { 1, 10, 20 }, { 30, -10, 15 } };
		int[][] expected = { { 1, 30 }, { 10, -10 }, { 20, 15 } };
		assertArrayEquals(expected, transpMatrix(src));
	}

}