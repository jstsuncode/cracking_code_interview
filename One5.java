import java.util.*;

public class One5 {

		public One5() {
		}

		public String compress(String s) {
				if (s == null || s.length() <= 2)
						return s;

				StringBuilder sb = new StringBuilder();

				char curChar = 0;
				int curCharCount = 0;
				for (int i = 0; i < s.length(); i++) {
						char c = s.charAt(i);
						if (c == curChar) {
								curCharCount++;
						} else {
								if (curChar != 0) {
										sb.append(curChar);
										sb.append(curCharCount);
								}
								curChar = c;
								curCharCount = 1;
						}
				}
				sb.append(curChar);
				sb.append(curCharCount);

				String sRet = sb.toString();
				if (sRet.length() > s.length()) {
						sRet = s;
				}
				return sRet;

		}

		public static void main(String[] args) {

				One5 one5 = new One5();

				String[] in = {"aabcccccaaa", "a", "", "bb", "aaa", "abbbc", "aabbbcc"};
				for (String w : in) {
					String sRet = one5.compress(w);
					System.out.println("Compressed of s is " + sRet);
				}


		}
}
