package telran.arrays.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import telran.arrays.*;

class InterviewTasksTest {

	private static final int N_NUMBERS = 1_000_000;

	@Test
	void getMaxWithNegativeTest() {
		short[] array = { 1, 1, 1, -1, 20, 100, 200, 100 - 100, -100, -20, -40, 80 };
		short[] array1 = { -40, 1, -40, -6, 2, 3, 40 };
		short[] array2 = { 40, 1, 2, 3, 40, -30 };
		assertEquals(100, InterviewTasks.getMaxWithNegativePresentation(array));
		assertEquals(40, InterviewTasks.getMaxWithNegativePresentation(array1));
		assertEquals(-1, InterviewTasks.getMaxWithNegativePresentation(array2));
	}

	@Test
	void sortTest() {
		short[] array = getRandomArray();
		InterviewTasks.sort(array);
		assertEquals(N_NUMBERS, array.length);
		for (int i = 1; i < array.length; i++) {
			assertTrue(array[i - 1] <= array[i]);
		}
	}

	private short[] getRandomArray() {
		short[] res = new short[N_NUMBERS];
		for (int i = 0; i < N_NUMBERS; i++) {
			res[i] = (short) (Math.random() * Short.MAX_VALUE);
		}
		return res;
	}

	@Test
	void isSumTwoTest() {
		short[] array = { 30000, 1, 5, 2, 10000, 0, 500, 0 };
		short[] array1 = { 30000, 1, 5, 2, 10000, 0, 500, 0, Short.MAX_VALUE };
		assertTrue(InterviewTasks.isSumTwo(array, (short) 30000));
		assertTrue(InterviewTasks.isSumTwo(array, (short) 7));
		assertFalse(InterviewTasks.isSumTwo(array, (short) 30003));
		assertFalse(InterviewTasks.isSumTwo(array, (short) 8));
		assertTrue(InterviewTasks.isSumTwo(array1, Short.MIN_VALUE));
	}

}