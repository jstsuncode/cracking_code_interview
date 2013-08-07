// 2.1
// Write code to remove duplicates from an unsorted linked list.
// How would you solve this problem if a temporary buffer is not allowed?

import java.util.*;

public class Two1 {

		public Two1() {
		}

		public Node removeDuplicates(Node head) {
				// one way is to sort, iterate through
				// another way, use a hash table to keep values of keys seen
				// if already seen, delete node

				if (head == null) return head;

				HashMap<Integer, Boolean> ht = new HashMap<Integer, Boolean>();
				
				Node p = head;

				ht.put(p.data, true);

				while (p.next != null) {
						int d = p.next.data;
						if (ht.containsKey(d)) {
								// remove duplicate
								Node n = p.next;
								p.next = p.next.next;								
						} else {
								ht.put(d, true);
								p = p.next;
						}
				}
				return head;
		}		

	 	public Node removeDuplicatesNoBuffer(Node head) {
				if (head == null) return head;

				Node p = head;

				while (p != null) {
						int pd = p.data;
						Node f = p;
						while (f.next != null) {
								int fd = f.next.data;
								if (fd == pd) {
										// remove it
										Node fn = f.next;
										f.next = f.next.next;
								}
								f = f.next;
						}
						p = p.next;
				}
				return head;			

		}

		public static void main(String[] args) {
				Two1 two1 = new Two1();

				int nums[] = {2,3,4,5,6,2,5,10,11,2,5,20,21,3,4,30,31,4,5,6,2,3,40,41};

				Node head = Node.buildList(nums);
			
				System.out.println("BEFORE:");
				Node.printList(head);

				//System.out.println("AFTER:");
				//head = two1.removeDuplicates(head);

				System.out.println("AFTER NO BUFFER:");
				head = two1.removeDuplicatesNoBuffer(head);
				Node.printList(head);
		}
}
