// 2.5
// Write code to partition a linked list, where each node contains a single digit
// The digits are stored in reverse order, such that the 1's digit is at the
// head of the list.  Write a function that adds the two numbers and returns the sum
// as a linked list.

public class Two5 {
		
		public Two5() {
		}

		public int getValRL(Node a) {
				if (a == null) return 0;
				int sum = 0;
				int pow = 1;

				Node p = a;
				while (p != null) {
						int iVal = p.data;
						sum += iVal * pow;
						pow = pow*10;

						p = p.next;
				}
				return sum;
		}

		public Node addLinkedListRL(Node a, Node b) {
				int valA = this.getValRL(a);
				int valB = this.getValRL(b);
				int sumC = valA + valB;

				System.out.println("valA = " +valA+",valB = " + valB);

				int rem = sumC % 10;
				int div = sumC / 10;

				Node head = null;
				Node tail = new Node(rem);
				while (div > 0) {
						rem = div % 10;
						div = div / 10;
	 					head = new Node(rem);
						head.next = tail;

						tail = head;						
				}
				rem = div % 10;

				if (rem > 0) {
						head = new Node(rem);
						head.next = tail;
				}

				return head;
		}


		public int getVal(Node a) {
				if (a == null) return 0;
				Node p = a;

				int pow = 10;
				int sum = 0;

				while (p != null) {

						sum += p.data * pow/10;

						pow = pow * 10;
						p = p.next;
				}
			
				return sum;
		}

		public Node addLinkedListLR(Node a, Node b) {
				int valA = this.getVal(a);
				int valB = this.getVal(b);
				int sumC = valA + valB;

				int rem = sumC % 10;
				int div = sumC / 10;

				Node head = new Node(rem);
				Node prev = head;
				while (div > 0) {
						rem = div % 10;
						div = div / 10;
	 					Node n = new Node(rem);
						prev.next = n;

						prev = prev.next;						
				}

				return head;
		}

		public Node addLinkedListLR2(Node a, Node b) {
				Node p1 = a;
				Node p2 = b;
			
				int ia = 0, ib = 0, sum = 0;
				int digit = 0, carry = 0;
				int pow = 10;

				Node head = null;
				Node prev = null;

				while (p1 != null || p2 != null) {
						ia = 0; ib = 0;

						if (p1 != null) {
								ia = p1.data;
								p1 = p1.next;
						}

						if (p2 != null) {
								ib = p2.data;
								p2 = p2.next;
						}

						digit = ((ia + ib) % 10) + carry;
						carry = ((ia + ib) >= 10) ? 1 : 0;
						Node n = new Node(digit);
						if (head == null) { 
							head = n;
						}
						else {
								prev.next = n;
						}
						prev = n;
				}
				return head;
		}

		public static void main(String[] args) {
				Two5 two5 = new Two5();

				int nums1[] = {7, 1, 9, 7};
				int nums2[] = {5, 9, 2};

				Node i1 = Node.buildList(nums1);
				Node i2 = Node.buildList(nums2);

				//System.out.println("SUM1");
				//Node sum = two5.addLinkedListLR(i1, i2);
				//Node.printList(sum);

				//System.out.println("SUM2");
				//Node sum = two5.addLinkedListLR2(i1, i2);
				//Node.printList(sum);

				System.out.println("SUM RL");
				Node sum = two5.addLinkedListRL(i1, i2);
				Node.printList(sum);

		}

}
