package telran.arrays.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static telran.arrays.InterviewTasks.*;

class InterviewTasksTest {

	@Test
	void sortTest() {
		short[] src1 = { 2, 4, 0 };
		short[] exp1 = { 0, 2, 4 };
		assertArrayEquals(exp1, sort(src1));

		short[] src2 = { 40, 1, 2, 3, 40, 30 };
		short[] exp2 = { 1, 2, 3, 30, 40, 40 };
		assertArrayEquals(exp2, sort(src2));

		short[] src4 = getRandomArray(4);
		sort(src4);
		testSorted(src4);
	}

	@Test
	void getMaxWithNegativeTest() {
		short[] array = { 1, 1, 1, -1, 20, 100, 200, 100, -100, -100, -20, -40, 80 };
		short[] array1 = { -40, 1, -40, -6, 2, 3, 40 };
		short[] array2 = { 40, 1, 2, 3, 40, -30 };

		assertEquals(100, getMaxWithNegativePresentation(array));
		assertEquals(40, getMaxWithNegativePresentation(array1));
		assertEquals(-1, getMaxWithNegativePresentation(array2));
	}

	private void testSorted(short[] array) {
		for (int i = 1; i < array.length; i++) {
			assertTrue(array[i - 1] <= array[i]);
		}
	}

	private short[] getRandomArray(int arraySize) {
		short[] res = new short[arraySize];
		for (int i = 0; i < arraySize; i++) {
			res[i] = (short) (Math.random() * Short.MAX_VALUE);
		}
		return res;
	}

}
