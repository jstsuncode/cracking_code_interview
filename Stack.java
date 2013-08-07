// Used by Chapter 3

public class Stack {
		public Node top;		

		public Stack() {
		}

		public int pop() {
				if (top != null) {
						int item = top.data;
						top = top.next;
						return item;
				}
				return null;
		}
		
		public void push(int item) {
				Node t = new Node(item);
				t.next = top;
				top = t;
		}

		public int peek() {
				return top.data;
		}
}
