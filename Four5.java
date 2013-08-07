// 4.5
// Implement a function to check if a binary tree is a binary search

public class Four5 {
		public Four5() {
		}

		public static boolean isBinarySearchTree(BNode head) {
				return Four5.isBinarySearchTree(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}

		public static boolean isBinarySearchTree(BNode head, int iMin, int iMax) {
				if (head == null)
					return true;
				
				if (head.value <= iMin) {
						System.out.println("Failed since "+head.value+" less than or equal to "+iMin);
						return false;
				}

				if (head.value > iMax) {
						System.out.println("Failed since "+head.value+" greater than "+iMax);
						return false;
				}
		
				if (!Four5.isBinarySearchTree(head.left, iMin, head.value) || 
						!Four5.isBinarySearchTree(head.right, head.value, iMax)) {
						return false;	
				}

				return true;
		}


		public static void main(String[] args) {
				Four5 cn = new Four5();

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

				// Is a binary search tree	
				System.out.println("head:");
				BNode head = BNode.createBinarySearchTree(nums);
				int numLevels = (int) Math.ceil(Math.log(n)) + 1;
				BNode.printTree(head, numLevels);
			
				// Not a bst since 5 is to left of 4.
				System.out.println("notBST");
				BNode notBST = new BNode(4, 0);
				notBST.left = new BNode(5, 1);
				notBST.right = new BNode(6, 1);
				BNode.printTree(notBST, 2);

				// Not a bst since 8 is to right of 10.
				System.out.println("notBST2");
				BNode notBST2 = new BNode(7, 0);
				notBST2.left = new BNode(4, 1);
				notBST2.right = new BNode(10, 1);
				notBST2.left.left = new BNode(2, 2);
				notBST2.left.right = new BNode(5, 2);
				notBST2.right.left = new BNode(9, 2);
				notBST2.right.right = new BNode(8, 2); // causes not being bst
				BNode.printTree(notBST2, 3);

				// Not a bst since 14 is to left of 10.
				System.out.println("notBST3");
				BNode notBST3 = new BNode(10, 0);
				notBST3.left = new BNode(5, 1);
				notBST3.right = new BNode(12, 1);
				notBST3.left.left = new BNode(3, 2);
				notBST3.left.right = new BNode(14, 2); // causes not being bst
				notBST3.right.left = new BNode(11, 2);
				notBST3.right.right = new BNode(13, 2);
				BNode.printTree(notBST3, 3);

				// Not a bst since 25 is to left of 20.
				System.out.println("notBST4");
				BNode notBST4 = new BNode(20, 0);
				notBST4.left = new BNode(10, 1);
				notBST4.right = new BNode(30, 1);
				notBST4.left.right = new BNode(25, 2);
				BNode.printTree(notBST4, 3);

				// Not a bst since 15 is to right of 20.
				System.out.println("notBST5");
				BNode notBST5 = new BNode(20, 0);
				notBST5.left = new BNode(10, 1);
				notBST5.right = new BNode(30, 1);
				notBST5.right.left = new BNode(15, 2);
				BNode.printTree(notBST5, 2);				

				System.out.println("\nisBinarySearch head:");System.out.println(Four5.isBinarySearchTree(head));
				System.out.println("\nisBinarySearch notBST:");System.out.println(Four5.isBinarySearchTree(notBST));
				System.out.println("\nisBinarySearch notBST2:");System.out.println(Four5.isBinarySearchTree(notBST2));
				System.out.println("\nisBinarySearch notBST3:");System.out.println(Four5.isBinarySearchTree(notBST3));
				System.out.println("\nisBinarySearch notBST4:");System.out.println(Four5.isBinarySearchTree(notBST4));
				System.out.println("\nisBinarySearch notBST5:");System.out.println(Four5.isBinarySearchTree(notBST5));
		}
}
