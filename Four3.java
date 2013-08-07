// 4.3
// Given a sorted (increasing order) array, write an algorithm to create a binary
// search tree with minimal height

public class Four3 {
	public Four3() {
	}
	
	public static void main(String[] args) {
		Four3 cn = new Four3();

		int idx = 0;
		int n = 63;
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
				//idx += Math.max(1, (int) Math.floor(Math.random()*5));
				++idx;
				nums[i] = idx;
				System.out.print(nums[i] + ",");
		}

		System.out.println("\n ===== \n");

		BNode head = BNode.createBinarySearchTree(nums);
		int numLevels = (int) Math.ceil(Math.log(n)) + 1;
		BNode.printTree(head, numLevels);
	}
}
