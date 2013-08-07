// 2.7
// Implement a function to check if a linked list is a palindrome
import java.util.ArrayList;

public class Two7 {
		public Two7() {
		}

		public boolean isPalindrome(Node head)
		{
				Node p = head;
				ArrayList<Integer> arList = new ArrayList<Integer>();
				while (p != null) {
						arList.add(p.data);
						p = p.next;
				}
				int len = arList.size();

				for (int i = 0, j=len-1; i < len/2; i++, j--) {
						if (arList.get(i) != arList.get(j))
								return false;
				}
				return true;
		}

		public static void main(String[] args) {
				Two7 two7 = new Two7();
				int num1[] = {1,3,5,7,9,7,5,3,1};
				int num2[] = {2,4,6,8,10,8,6,4,2};
				int num3[] = {1,3,5,7,9,7,5,2,1};
				
				Node head1 = Node.buildList(num1);
				Node head2 = Node.buildList(num2);
				Node head3 = Node.buildList(num3);

				System.out.println("head1.isPalindrome=" + two7.isPalindrome(head1));	
				System.out.println("head2.isPalindrome=" + two7.isPalindrome(head2));	
				System.out.println("head3.isPalindrome=" + two7.isPalindrome(head3));	

		}
}
