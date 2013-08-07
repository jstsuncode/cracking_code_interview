// Used by Chapter 3

public class Queue {
		public Node first, last;		

		public Queue() {
		}

		public void enqueue(int item) {
				if (first == null) {
						last = new Node(item);
						first = last;
				} else {
						last.next = new Node(item);
						last = last.next;
				}
		}

		public Node dequeue() {
				if (first != null) {
						Object item = first.data;
						first = first.next;
						return item;
				}
				return null;
		}

}
