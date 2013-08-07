// Implement an algorithm to delete a node in the middle of a singly linked list,
// given only access to that node
// EXAMPLE
// Input: the node c from the linked list a -> b -> c -> d -> e
// Result: nothing is returned, but the new linked list looks like a->b->d->e

public class Two3 {
		public Two3() {
		}

		public Node deleteNode(Node head, Node c) {
				if (head == null) return head;
				
				Node p = head;
				if (p == c) {
						head = head.next;
						return head;
				}
			
				while (p.next != null) {
						if (p.next == c) {
								Node d = p.next;
								p.next = p.next.next;
						}
						p = p.next;
						if (p == null)
								break;
				}

				if (p == c) {
						p.next = null;					
				}
				return head;
		}

		public Node deleteNodeSingle(Node c) {
				if (c.next != null) {
						Node n = c.next;
						c.data = n.data;
						c.next = n.next;
						n.next = null;
				}
				return c;
		}

		public static void main(String[] args) {
				Two3 two3 = new Two3();

				int nums[] = {1,2,3,4,5};
				int items[] = {3,4,1,2,5};

			 	for (int i = 0; i < items.length; i++) {
					Node head = Node.buildList(nums);
					Node c = Node.findNode(head, items[i]);

					System.out.println("c = " + c.data);

					//head = two3.deleteNode(head, c);

					two3.deleteNodeSingle(c);					

					Node.printList(head);
				}
		}
}
