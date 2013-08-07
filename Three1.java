// 3.1
// Describe how you could use a single array to implement three stacks

public class Three1 {

		

		public static void main(String[] args) {
		
				StackOfThree stack = new StackOfThree();

				for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 25; j++) {
								int val = j+(i+100);
								System.out.println("i="+i+", Pushing val = " + val);
								stack.push(i, val);
						}
				}


				System.out.println("peek 0 = " + stack.peek(0));
				System.out.println("peek 1 = " + stack.peek(1));
				System.out.println("peek 2 = " + stack.peek(2));
		}
}
