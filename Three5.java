// 3.5
// Implement a MyQueue class which implements a queue using two stacks

class MyQueue {
		ARStack stack1 = new ARStack();
		ARStack stack2 = new ARStack();

		int lastAction = 0;  // 0 = push, 1 = pop

		public void enqueue(Object newItem) {
				// pop off all items on stack2 and push to stack1
				// push new item to stack1
				if (lastAction == 0) {
						stack1.push(newItem);
				} else {
						while (stack2.peek() != null) {
							stack1.push(stack2.pop());
						}
						stack1.push(newItem);
						lastAction = 0;
				}

		}

		public Object dequeue() {
				if (lastAction == 1) {
						return stack2.pop();
				} else {
						// pop off all the items on stack1 and push to stack2
						// the top of stack2 will be the dequeued element
						while (stack1.peek() != null) {
								stack2.push(stack1.pop());
						}
						lastAction = 1;
						return stack2.pop();
				}
		}

		public String toString() {
				return "Stack1: " + stack1.toString() + ", Stack2: " + stack2.toString();
		}	

}

public class Three5 {
		public Three5() {
		}

		public static void main(String[] args) {
				MyQueue q = new MyQueue();

				for (int i = 0; i < 30; i++) {
						q.enqueue(i);
				}

				System.out.println("q = " + q.toString());

				for (int i = 0; i < 5; i++) {
						Integer front = (Integer) q.dequeue();
						System.out.println(front + " dequeued");
				}

				System.out.println("q = " + q.toString());


				for (int i = 30; i < 40; i++) {
						q.enqueue(i);
				}

				System.out.println("q = " + q.toString());

				for (int i = 0; i < 5; i++) {
						Integer front = (Integer) q.dequeue();
						System.out.println(front + " dequeued");
				}

				System.out.println("q = " + q.toString());

				System.out.println("POP the rest");
				Integer o = (Integer) q.dequeue();
				while (o != null) {
						System.out.println(o + " dequeued");
						o = (Integer) q.dequeue();
				}


		}
}
