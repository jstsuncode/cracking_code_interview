// 4.4
// Given a binary tree, design an algorithm which creates a linked list of all the
// nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked lists.

import java.util.LinkedList;

class Tuple {
		public BNode bNode;
		public int curLevel;

		public Tuple(BNode bNode, int iLevel) {
				this.bNode = bNode;
				this.curLevel = iLevel;
		}

}

public class Four4 {
		public Four4() {
		}

		public static void getDepthListH(BNode head, int initLevel, LinkedList<LinkedList<BNode>> list) 
		{
				if (head == null) return;
				
				LinkedList<Tuple> q = new LinkedList<Tuple>();

				q.add(new Tuple(head, initLevel));

				while (!q.isEmpty()) {

						Tuple t = q.pop();
						BNode b = t.bNode;
						int curLevel = t.curLevel;

						System.out.println("b="+b.value+",curLevel="+curLevel);

						LinkedList<BNode> items = null;
						if (list.size() <= curLevel) {
								items = new LinkedList<BNode>();
								list.add(items);
						} else {
								items = list.get(curLevel);
						}
						items.add(t.bNode);

						if (b.left != null) {
								q.push(new Tuple(b.left, curLevel+1));
						}
						if (b.right != null) {
								q.push(new Tuple(b.right, curLevel+1));
						}
				}	
		}
		public static LinkedList<LinkedList<BNode>> getDepthList(BNode head) {
				LinkedList<LinkedList<BNode>> list = new LinkedList<LinkedList<BNode>>();
 				Four4.getDepthListH(head, 0, list); 
				return list;
		}

		public static void printDepthList(LinkedList<LinkedList<BNode>> list) {
				int i = 0;
				for (LinkedList<BNode> depthList : list) {
						System.out.print("Level "+i+": ");
						for (BNode b : depthList) {
								System.out.print(" " + b.value);
						}
						System.out.println();
						i++;
				}
		}


		public static void main(String[] args) {
			Four4 cn = new Four4();

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
			//int numLevels = (int) Math.ceil(Math.log(n)) + 1;
			//	BNode.printTree(head, numLevels);

			System.out.println("\n DEPTH LIST \n");

			LinkedList<LinkedList<BNode>> list = Four4.getDepthList(head);
			Four4.printDepthList(list);
	}
}
