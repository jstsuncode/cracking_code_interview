// 2.6
// Given a circular linked list, implement an algorithm which returns the node at
// the beginning of the loop.
// DEFINITION
// Circular linked list: A (corrupt) linked list in which a node's next pointer points
// to an earlier node, so as to make a loop in the linked list.
// EXAMPLE
// Input: A->B->C->D->E->C [the same C as earlier]
// Output: C

public class Two6 {
		public Two6() {
		}

		public Node findLoopStart(Node head) {
				if (head == null) return null;
				if (head.next == null) return null;
				if (head == head.next) return head;
	
				Node slow = head;
				Node fast = head.next.next;

				int k = 0;
				while (true) {
						System.out.println("slow="+slow.data);
						System.out.println("fast="+fast.data);

						if (slow == fast)
								break;

						slow = slow.next;
						fast = fast.next.next;
						k++;
				}

		}

		public static void main(String[] args) {
				Two6 two6 = new Two6();

				int[] nums = {1,2,3,4,5,6,7,8};
			 	Node head = Node.buildList(nums);
				Node five = Node.findNode(head, 5);
				head.appendToTail(five);  // create circular linked-list repeating element 5

				Node loopStart = two6.findLoopStart(head);
				System.out.println(loopStart.data);	

		}
}
