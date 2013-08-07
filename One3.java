// Given two strings, write a method to decide if one is a permutation of the other.
import java.util.*;

// Naive way to answer question.
// Sort both strings and compare them
// 2 * O (n log n)

public class One3 {
		public One3() {
		}

		public boolean isPermutation(String a, String b) {

				if (a.length() != b.length())
						return false;

				HashMap<Character, Integer> ht = new HashMap<Character, Integer>();

				// increment count for letters for a
				for (int i = 0; i < a.length(); i++) {
						char c = a.charAt(i);
						if (!ht.containsKey(c)) {
								ht.put(c, 1);
						} else {
								int newcount = ht.get(c) + 1;
								ht.put(c, newcount);
						}
				}

				// decrement count for letters for b
				for (int j = 0; j < b.length(); j++) {
						char c = b.charAt(j);
						if (!ht.containsKey(c)) {
								return false;
						} else {
								int newcount = ht.get(c) - 1;
								if (newcount < 0)
										return false;
								ht.put(c, newcount);
						}
				}

				
				return true;
		}

		public void printResults(String a, String b) {
				boolean ret = this.isPermutation(a, b);
				if (ret) {
						System.out.println(a + " and " + b + " ARE permutations"); 
				} else {
						System.out.println(a + " and " + b + " ARE NOT permutations");
				}
		}

		public static void main(String[] args) {
				One3 one3 = new One3();
				one3.printResults("aadd", "ddbbc");
				one3.printResults("aacdd", "ddbbc");
				one3.printResults("cbbdd", "bddbc");
		}

}
