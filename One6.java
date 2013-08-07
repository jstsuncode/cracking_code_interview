// 1.6
// Given an image represented by an NxN matrix, where each pixel in the image is
// 4 bytes, write a method to rotate the image by 90 degrees.  Can you do this in place?

public class One6 {
		public One6() {
		}

		public static String coord(int x, int y) {
				return "("+x+","+y+")";
		}

		public void rotateMatrix(int[][] matrix, int n) {

				// rotating a matrix by 90 degrees

				// rotate in layers
				// for i 0 to N-1
				//  tmp = top[i]
				//  top[i] = left[i]
				//  left[i] = bottom[i]
				// 	bottom[i] = right[i]
				//  right[i] = tmp[i]

				for (int layer = 0; layer < n/2; layer++) {

						int first = layer;
						int last = n-1-layer;

						System.out.println("Loop: first="+first+", last="+last);

						for (int i = first; i < last; i++) {
								int offset = i - first;

								System.out.println("Inner: offset="+offset+", top="+this.coord(first,i)+
																	 ", left="+this.coord(last-offset,first)+", bot="+this.coord(last,last-offset)+", rt="+this.coord(i,last));

								// save top
								int top = matrix[first][i];

																

								// left->top
								matrix[first][i] = matrix[last-offset][first];
								
								// bottom->left
								matrix[last-offset][first] = matrix[last][last-offset];

								// right->bottom
								matrix[last][last-offset] = matrix[i][last];

								//top->right
								matrix[i][last] = top;

								//System.out.println("AFTER");
								//this.printMatrix(matrix, n);
						}
				}

		}

		public void printMatrix(int[][] matrix, int length) {
				System.out.println("Rotation of matrix is ");
				for (int i = 0; i < length; i++) {
						for (int j = 0; j < matrix[i].length; j++) {
								System.out.print(matrix[i][j] + " ");
						}
						System.out.println();
				}
		}

		public static void main(String[] args) {
				int[][] matrix = {{2,3,4,5,6}, {12, 13, 14, 15,16}, {22, 23, 24, 25, 26}, {32, 33, 34, 35, 36}, {42, 43, 44, 45, 46}};
				int n = 5;
				One6 one6 = new One6();
				one6.rotateMatrix(matrix, n);
				one6.printMatrix(matrix, n);
		}
}
