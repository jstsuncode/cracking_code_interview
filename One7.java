// 1.7
// Write an algorithm such that if an element is an MxN matrix is 0, its entire row
// and column are set to 0.

public class One7 {

		public One7() {
		}

		public static String coord(int x, int y) {
				return "("+x+","+y+")";
		}

		public void printMatrix(int[][] matrix, int length) {
				System.out.println("Zero out of matrix is ");
				for (int i = 0; i < length; i++) {
						for (int j = 0; j < matrix[i].length; j++) {
								System.out.print(matrix[i][j] + " ");
						}
						System.out.println();
				}
		}

		public void zeroOut(int[][] matrix, int n, int m) {
				// If row or col has a zero, mark it as a zero

				boolean[] rows = new boolean[n];
				boolean[] cols = new boolean[m];

				for (int x = 0; x < n; x++) {
						for (int y = 0; y < m; y++) {
								if (matrix[x][y] == 0) {
										rows[x] = true;
										cols[y] = true;
								}
						}
				}
	
				for (int x = 0; x < n; x++) {
						for (int y = 0; y < m; y++) {
								if (rows[x] || cols[y]) {
										matrix[x][y] = 0;
								}
						}
 				}

		}

		public static void main(String[] args) {
				int[][] matrix = {{3,0,4,5}, {1,2,0,2}, {6,7,8,9}, {10,11,12,13}, {20,21,22,23}};
				int n = 5, m = 4;

				One7 one7 = new One7();
				one7.zeroOut(matrix, n, m);
				one7.printMatrix(matrix, n);
		}

}
