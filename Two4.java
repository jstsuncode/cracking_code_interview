// 2.4
// Write code to partition a linked list around a value x, such that all nodes less
// than x come before all nodes greater than or equal to x.

public class Two4 {
		public Two4() {
		}

		public Node partition(Node head, int x) {
				if (head == null) return head;

				Node p = head;
				Node before = null;
				Node after = null;
				Node center = null;
				while (p.next != null) {
						if (p.next.data == x) {
								// partition around this element
								before = p;
								after = p.next.next;
								center = p.next;
								break;
						}
						p = p.next;
				}

				if (center == null)
						return head;

				System.out.println("b=" + before.data +", a="+after.data+", c="+center.data);


				p = head;		
				while (p.next != center) {
						int d = p.next.data;
						if (d > x) {
								Node n = p.next;
								p.next = n.next;
								n.next = center.next;
								center.next = n;
						}
						p = p.next;
				}

				Node.printList(head);
				System.out.println("b=" + before.data +", a="+after.data+", c="+center.data);

				p = center;
				while (p.next != null) {
						int d = p.next.data;
						if (d < x) {
								Node n = p.next;

								System.out.println("n=" + n.data);

								p.next = n.next;
								n.next = center;
								before.next = n;
								before = n;			
						} 
						else {
							p = p.next;
						}
				}
				// end case
				if (p != null) {					
					if (p.data < x) {
						 Node n = p;
						 p.next = center;
						 before.next = n;
					}
				}


				return head;
		}

		public static void main(String[] args) {
				Two4 two4 = new Two4();
				int nums[] = {0,3,4,5,17,8,11,6,9,51,15,2,1,33};
				Node list = Node.buildList(nums);

				Node.printList(list);
				System.out.println("partitioning");

				Node group = two4.partition(list, 9);
				Node.printList(group);
		}
}
