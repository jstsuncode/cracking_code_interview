// 4.1
// Implement a function to check if a binary tree is balanced.  For this purposes of
// this question, a balanced tree is defined to be a tree such that the heights of the
// two subtrees of any node never differ by more than one

class BTNode {
		public BTNode left;
		public BTNode right;
		public int value;

		public BTNode(int value) {
				this.value = value;
		}

		// Return -1 if not balanced
		// Return 0 if root is null
		public static int checkHeight(BTNode root) {
				if (root == null)	return 0; // Height of 0

				/* Check if left is balanced */
				int leftHeight = checkHeight(root.left);
				if (leftHeight == -1) {
						return -1; // Not balanced
				}

				int rightHeight = checkHeight(root.right);
				if (rightHeight == -1) {
						return -1;  // Not balanced
				}

				/* Check if current node is balanced. */
				int heightDiff = leftHeight - rightHeight;
				if (Math.abs(heightDiff) > 1) {
						return -1; // Not balanced
				} else {
						/* Return height */
						return Math.max(leftHeight, rightHeight) + 1;
				}				
		}

		public static boolean isBalanced(BTNode root) {
				if (checkHeight(root) == -1) {
						return false;
				} else {
						return true;
				}
		}

		public String toString() {
				StringBuilder sb = new StringBuilder();
				sb.append("\n");
				sb.append(value);
				if (left != null) {
						sb.append(left.toString());
				}
				if (right != null) {
						sb.append(right.toString());
				}
				return sb.toString();
		}
}

public class Four1 {
	public Four1() {
	}
	
	public static void main(String[] args) {
		Four1 cn = new Four1();

		BTNode t1_0 = new BTNode(1);
		BTNode t1_1_0 = new BTNode(2);
		BTNode t1_1_1 = new BTNode(3);
		BTNode t1_2_0 = new BTNode(4);
		BTNode t1_2_1 = new BTNode(5);
		BTNode t1_2_2 = new BTNode(6);
		BTNode t1_2_3 = new BTNode(7);
		BTNode t1_3_0 = new BTNode(8);
		BTNode t1_3_1 = new BTNode(9);
		t1_0.left = t1_1_0;
		t1_0.right = t1_1_1;
		t1_1_0.left = t1_2_0;
		t1_1_0.right = t1_2_1;
		t1_1_1.left = t1_2_2;
		t1_1_1.right = t1_2_3;
		t1_2_0.left = t1_3_0;
		t1_2_0.right = t1_3_1;

		System.out.println("t1=" + t1_0.toString());
		System.out.println("Balanced t1 = " + BTNode.isBalanced(t1_0));

		BTNode t2_0 = new BTNode(1);
		BTNode t2_1_0 = new BTNode(2);
		BTNode t2_1_1 = new BTNode(3);
		BTNode t2_2_0 = new BTNode(4);
		BTNode t2_2_1 = new BTNode(5);
		BTNode t2_2_2 = new BTNode(6);
		BTNode t2_2_3 = new BTNode(7);
		BTNode t2_3_0 = new BTNode(8);
		BTNode t2_4_0 = new BTNode(9);
		t2_0.left = t2_1_0;
		t2_0.right = t2_1_1;
		t2_1_0.left = t2_2_0;
		t2_1_0.right = t2_2_1;
		t2_1_1.left = t2_2_2;
		t2_1_1.right = t2_2_3;
		t2_2_0.left = t2_3_0;
		t2_3_0.right = t2_4_0;

		System.out.println("t2=" + t2_0.toString());
		System.out.println("Balanced t2 = " + BTNode.isBalanced(t2_0));

	}
}

