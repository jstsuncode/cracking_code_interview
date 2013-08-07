// 3.2
// How would you design a stack which, in addition to push and pop, also has a
// function min which returns the minimum element? Push pop and min should all
// operate in O(1) time

public class Three2 {
		public Three2() {
		}

		public static void main(String[] args) {
				StackMin sm = new StackMin();
				int[] items = {5, 7, 9, 3, 6, 12, 15, 4, 1, 17};
				for (int i = 0; i < items.length; i++) {
						sm.push(items[i]);
						System.out.println("peek = " + sm.peek() + ", min = " + sm.min());
				}

				System.out.println("\nPopping\n\n");

				Integer io = null;
				while ((io = sm.pop()) != null) {
					System.out.println("pop = " + io + ", min = " + sm.min());
				}
		}
}
