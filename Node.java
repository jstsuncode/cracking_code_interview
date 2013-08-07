// Used by Chapter 2

public class Node {
		public Node next = null;
		public int data;

		public Node(int d) {
				data = d;
		}
		
		public Node(Object o) {
				data = ((Integer) o).intValue();
		}

		public void appendToTail(int d) {
				Node end = new Node(d);
				Node n = this;
				while (n.next != null) {
						n = n.next;
				}
				n.next = end;
		}
	
		public void printNode() {
				System.out.print(this.data);
				if (this.next != null) {
						System.out.print(" -> ");
						this.next.printNode();
				}
		}

		public static Node buildList(int[] nums) {
				Node head = null;				
				for (int i = 0; i < nums.length; i++) {
						if (head == null) {
								head = new Node(nums[i]);
						} else {
								head.appendToTail(nums[i]);
						}
				}
				return head;
		}

		public static Node findNode(Node head, int d) {
				Node ret = null;

				if (head.data == d) {
						ret = head;
				}
				else if (head.next != null) {
						ret = Node.findNode(head.next, d);
				}
				return ret;
		}

		public static void printList(Node head) {
				if (head == null) return;

				head.printNode();
				System.out.println();
		}

}
