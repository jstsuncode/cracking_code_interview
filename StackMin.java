// Used by Chapter 3

class StackMinNode {
		public Integer data;
		public StackMinNode next;
		public int min;

		public StackMinNode(Integer item, int curMin) {
				this.data = item;
				this.min = curMin;
		}
}

public class StackMin {
		public StackMinNode top;
		public int curMin = -1;

		public StackMin() {
		}

		public Integer pop() {
				if (top != null) {
						int item = top.data;
						top = top.next;
						return (Integer) item;
				}
				return null;
		}
		
		public void push(Integer item) {
				if (top == null) {
						top = new StackMinNode(item, item);
						this.curMin = item;
				}
				else
				{
						int newMin = Math.min(item, this.curMin);
						StackMinNode si = new StackMinNode(item, newMin);
						si.next = top;
						top = si;
				}
		}

		public Integer peek() {
				if (top == null) return null;
				return top.data;
		}

		public Integer min() {
				if (top == null) return null;
				return top.min;
		}
}
