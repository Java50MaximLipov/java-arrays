package telran.arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InterviewTasks {
	static public boolean isSumTwo(short[] array, short sum) {
		// array of positive numbers or 0
		// {1, 2, 30, 2, 2}. sum = 4
		// helper = {false, true, true, false, false}
		boolean[] helper = new boolean[sum > 0 ? sum + 1 : Short.MAX_VALUE + 1];
		boolean res = false;
		int index = 0;
		while (index < array.length && !res) {
			short num = (short) (sum - array[index]);
			if (num >= 0) {
				if (helper[num]) {
					res = true;
				} else {
					helper[array[index]] = true;
				}
			}
			index++;
		}
		return res;
	}

// HW-04
	public static short[] sort(short[] array) {
		short[] count = new short[Short.MAX_VALUE + 1];
		for (int i = 0; i < array.length; i++) {
			short num = array[i];
			count[num]++;
		}
		int index = 0;
		for (int i = 0; i < count.length; i++) {
			while (count[i] > 0) {
				array[index++] = (short) i;
				count[i]--;
			}
		}
		return array;
	}

	public static short getMaxWithNegativePresentation(short[] array) {
		// FIXME getMaxWithNegativePresentation
		// returns maximal positive number having an negative value with the same abs
		// value, if no such numbers returns -1

		short maxNumber = -1;
		boolean[] isNegativeNumber = new boolean[Math.abs(Short.MIN_VALUE) + 1];
		int index = 0;
		boolean res = false;
		while (index < array.length && !res) {
			short number = array[index];
			if (number < 0) {
				isNegativeNumber[Math.abs(number)] = true;
			} else if (number > 0 && isNegativeNumber[Math.abs(number)]) {
				maxNumber = (short) Math.max(maxNumber, number);
				res = true;
			}
			index++;
		}
		return maxNumber;
	}

}
