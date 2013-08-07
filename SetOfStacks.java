// Used by 3.3
import java.util.ArrayList;

class PlateStack {
		public int count = 0;
		public Node top;

		public PlateStack() {
		}

		public int pop() {
				if (top != null) {
						int item = top.data;
						top = top.next;
						this.count--;
						return item;
				}
				return -1;
		}
		
		public void push(int item) {
				Node t = new Node(item);
				t.next = top;
				top = t;
				this.count++;
		}

		public int peek() {
				return top.data;
		}

		public void printPlateStack() {
				Node.printList(top);
		}

}

public class SetOfStacks
{
		int maxCapacity = -1;
		PlateStack curPlateStack = null;
		
		ArrayList<PlateStack> stacks = new ArrayList<PlateStack>();		

		public SetOfStacks(int maxCapacity) {
				this.maxCapacity = maxCapacity;
		}

		public Object pop() {
				if (this.curPlateStack == null) return null;

				return this.curPlateStack.pop();
		}

		// FOLLOW UP PART
		public Object popAt(int index) {
				if (this.stacks.size() < index) return null;
				return this.stacks.get(index).pop();
		}
		
		public Object peek() {
				if (this.curPlateStack == null) return null;

				return this.curPlateStack.peek();
		}

		public void printState() {				
				for (int i = 0; i < this.stacks.size(); i++) {
						System.out.print("Stack "+ i +":");
						this.stacks.get(i).printPlateStack();
				}
		}

		public void push(int i) {
				if (this.curPlateStack == null || this.curPlateStack.count == maxCapacity) {
						PlateStack s = new PlateStack();
						stacks.add(s);
						this.curPlateStack = s;
				}
				curPlateStack.push(i);
		}
}
