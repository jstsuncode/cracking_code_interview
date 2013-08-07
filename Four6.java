// 4.6
// Write an algorithm to find the 'next' node (i.e. in-order successor) of a given node
// in a binary search tree.  You may assume that each node has a link to its parent.
import java.util.ArrayList;

public class Four6 {
		public Four6() {
		}

		public static BNode getNextNode(BNode node) {
				// you want to get left-most right node
				// if no right node, traverse up parent

				if (node == null) return null;
	
				if (node.right != null) {
						BNode b = node.right;
						while (b.left != null) {
								b = b.left;
						}
						return b;
				}
				else {
						// while (n is a right child of n.parent) {
						// 	n = n.parent; // Gop up
						// }
						// return n.parent

						BNode q = node;
						BNode x = q.parent;
						while (x != null && x.left != q) {
								q = x;
								x = x.parent;
						}
						return x;
				}		 
		}	

		public static void main(String[] args) {
				Four6 cn = new Four6();

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

				ArrayList<BNode> list = new ArrayList<BNode>();
				BNode.getAllNodes(head, list);
				for (int j = 0; j < list.size(); j++) {
						BNode b = list.get(j);
						BNode next = Four6.getNextNode(b);
						String nextV = (next!=null) ? next.value+"" : "null";
						System.out.println("nextNode of "+b.value+" is "+nextV);
				}

		}
}
