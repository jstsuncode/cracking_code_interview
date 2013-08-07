// Implement a algorithm to determine if a string has all unique characters.
// What if you cannot use additional data structures?

// Solution #1
// Sort all the characters in the string
// Then iterate through chars, increment count of chars as you go up
// O(n log n) to sort

// Solution #2
// Use a hash table to count characters while iterating through characters
// If count ever gets > 1, return.

// Solution #3 (no extra storage)
// Compare each character with each other character (similar to swap in bubblesort)

import java.lang.*;
import java.util.*;

public class One1 {

		public One1() {
		}

		// Solution with boolean array
		public boolean isUniqueChars2(String str) {
				if (str.length() > 256) return false;
				
				boolean[] char_set = new boolean[256];
				for (int i = 0; i < str.length(); i++) {
						int val = str.charAt(i);
						if (char_set[val]) {
								// Already found this char in string
								return false;
						}
						char_set[val] = true;
				}
				return true;
		}

		// Solution with bitvector
		// Only works with ascii lower chars 'a' - 'z'
		public boolean isUniqueChars3(String str) {
				if (str.length() > 256) return false;
				
				int checker = 0;
				for (int i = 0; i < str.length(); i++) {
						int val = str.charAt(i) - 'a';
						if ((checker & (1 << val)) > 0) {
								// Already found this char in string
								return false;
						}
						checker |= (1 << val);
				}
				return true;
		}

		// Solution without extra datastructure
		public boolean isUniqueChars4(String str) {
				if (str.length() > 256) return false;
				
				for (int i = 0; i < str.length(); i++) {
						int a = str.charAt(i);
						for (int j = 0; j < str.length(); j++) {
								if (j == i) continue;
								int b = str.charAt(j);
								if (a == b) return false;
						}
				}
				return true;
		}

		public static void main(String[] args) {
				String[] list = new String[3];
				list[0] = "abcdefgh"; // unique
				list[1] = "abcefgah"; // not unique
				list[2] = "bcdefgfffa"; // not unique

				One1 one1 = new One1();
				for (int i = 0; i < list.length; i++) {
						String s = list[i];
						//boolean b = one1.isUniqueChars2(s);
						//boolean b = one1.isUniqueChars3(s);
						boolean b = one1.isUniqueChars4(s);
						System.out.println(s + " >> " + b);
				}
		}
}
