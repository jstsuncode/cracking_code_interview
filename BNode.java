// Used by Chapter 4

import java.util.LinkedList; // Queue
import java.util.ArrayList;

public class BNode {
		public int value;
		BNode left;
		BNode right;
		public int level;

		BNode parent = null; // Used by 4.6

		public BNode(int v, int level) {
				this.value = v;
				this.level = level;
		}

		public BNode(int v, int level, BNode parent) {
				this.value = v;
				this.level = level;
				this.parent = parent;
		}

		public static BNode createBinarySearch(int left, int right, int[] nums, int level) {
				if (left > right)
						return null;

				int mid = (left+right)/2;
				BNode head = new BNode(nums[mid], level);
				head.left = BNode.createBinarySearch(left, mid-1, nums, level+1);
				head.right = BNode.createBinarySearch(mid+1, right, nums, level+1);

				/////////////////////////////////
				// Used by 4.6
				if (head.left != null) 
						head.left.parent = head;
				
				if (head.right != null)
						head.right.parent = head;
				/////////////////////////////////

				return head;
		}

		public static BNode createBinarySearchTree(int[] nums) {
				return BNode.createBinarySearch(0, nums.length-1, nums, 0);
		}

		public static void getAllNodes(BNode head, ArrayList<BNode> list) {
				if (head == null) return;
				
				LinkedList<BNode> q = new LinkedList<BNode>();
				q.add(head);

				while (!q.isEmpty()) {
						BNode b = q.pop();
						list.add(b);

						if (b.left != null) { q.add(b.left); }
						if (b.right != null) { q.add(b.right); }			
				}

		}

		public static void printTree(BNode head, int numLevels) {
				if (head == null) return;
					
				ArrayList<BNode> list = new ArrayList<BNode>();
				BNode.getAllNodes(head, list);			
	
				for (int i = 0; i <= numLevels; i++) {
						for (int j = 0; j < list.size(); j++) {
								BNode b = list.get(j);
								if (b.level == i) { System.out.print(" " + b.value); }
						}
						System.out.println();
				}
			
		}
}
