// 3.6
// Write a program to sort a stack in ascending order (with biggest items on top).
// You may use additional stacks to hold items, but you may not copy the elements
// into any other data structure (such as an array).  The stack supports the following
// operations: push, pop, peek, and isEmpty.

public class Three6 {
		public Three6() {
		}

		public static ARStack sortStack(ARStack stack) {
				ARStack sorted = new ARStack();
				ARStack tmp = new ARStack();

				while (!stack.isEmpty()) {
						Integer o = (Integer) stack.pop();

						System.out.println("o = " + o);

						if (sorted.isEmpty()) {
								sorted.push(o);
						}
						else {
								boolean bAdded = false;
								while (!sorted.isEmpty()) {
										Integer top = (Integer) sorted.peek();
										if (o > top) {
												sorted.push(o);
												bAdded = true;
												break;
										} else {
												tmp.push(sorted.pop());
										}
								}

								if (!bAdded) {
										sorted.push(o);
								}


								while (!tmp.isEmpty()) {
										sorted.push(tmp.pop());
								}
						}
				}
				return sorted;
		}

		public static ARStack sort2(ARStack stack) {
				ARStack r = new ARStack();
				while (!stack.isEmpty()) {
						Integer tmp = (Integer) stack.pop(); // Step 1

						System.out.println("\n\nSTEP1");
						System.out.println("tmp = " + tmp);
						System.out.println("s=" + stack.toString());
						System.out.println("r=" + r.toString());

						while (!r.isEmpty() && ((Integer)r.peek() > tmp)) {
								// Step 2

								System.out.println("STEP2");
								System.out.println("r.peek() = " + r.peek());

								stack.push(r.pop());

								System.out.println("s=" + stack.toString());
								System.out.println("r=" + r.toString());

						}
						r.push(tmp); // Step 3

						System.out.println("STEP3");
						System.out.println("s=" + stack.toString());
						System.out.println("r=" + r.toString());
				}
				return r;
		}

		public static void main(String[] args) {
				Three6 three6 = new Three6();

				int[] nums = {4, 10, 7, 9, 3, 5};
				ARStack stack = new ARStack();
				for (int i = 0; i < nums.length; i++) {
						stack.push(nums[i]);
				}

				System.out.println("Stack=" + stack.toString());

				//ARStack sortedStack = three6.sortStack(stack);
				ARStack sortedStack = three6.sort2(stack);

				System.out.println("AFTER SORT");
				System.out.println("Stack=" + sortedStack.toString());
				
		}
}
