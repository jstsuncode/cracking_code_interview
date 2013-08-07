// 2.2
// Implement an algorithm to find the kth to last element of a singly linked list

public class Two2
{
		public Two2() {
		}

		public Node findKthToLast(Node head, int k) {
			if (head == null || k <= 0) return null;

			Node p = head;
			int i = 0;
			for (i = 1; i < k; i++) {
					if (p.next != null) { 
							p = p.next;
					} else {
							break;
					}
			}

			if (i != k) return null;

			Node h = head;
			while (p.next != null) {
					h = h.next;
					p = p.next;
			}

			return h;
		}

		public static void main(String[] args) {
				Two2 two2 = new Two2();
				int[] nums = {0,1,2,3,4,5,6,7,8,9};

				Node head = Node.buildList(nums);
				Node.printList(head);

				int[] fArgs = {7, 1, 2, 9};
				
				for (int i = 0; i < fArgs.length; i++) {
						int k = fArgs[i];
						Node kth = two2.findKthToLast(head, k);
						if (kth != null) { 
							System.out.println("k="+k+", "+k+"th to last="+kth.data);
						} else {
							System.out.println("k="+k+", "+k+"th to last is NULL");
						}
				}				
		}
}
