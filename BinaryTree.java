// Used by Chapter 4
import java.util.Queue;

public class BinaryTree {
		public BinaryTree left;
		public BinaryTree right;
		public Object value;

		public BinaryTree() {
				this(null, null, null);
		}

		public BinaryTree(Object value) {
			 	this(value, null, null);
		}

		public BinaryTree(Object value, BinaryTree left, BinaryTree right) {
				this.value = value;
				this.left = left;
				this.right = right;
		}

		public static BinaryTree createBinaryTree() {
				int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

				Queue<Integer> q = new Queue<Integer>();
				for (int i = 0; i < nums.length; i++) {
						q.add(nums[i]);
				}

				BinaryTree b = new BinaryTree(1);
				return BinaryTree.createBinaryTree(b, q, null);
		}

		public static BinaryTree createBinaryTree(BinaryTree b, Queue<Integer> q, Queue<BinaryTree> nodes) {
					
				if (q.isEmpty()) {
						Integer i = q.pop();
						b.value = i;

						if (
				}	
			
		}

}
