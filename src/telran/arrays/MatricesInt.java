package telran.arrays;

public class MatricesInt {
	public static int[][] multiplyConstant(int[][] matrix, int constant) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] *= constant;
			}
		}
		return matrix;
	}

//HW-04
	public static int[] getColumn(int[][] matrix, int column) {
		int[] res = new int[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			res[i] = matrix[i][column];
		}
		return res;
	}

	public static int[][] transpMatrix(int[][] matrix) {
		int[][] res = new int[matrix[0].length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				res[j][i] = matrix[i][j];
			}
		}
		return res;
	}
}