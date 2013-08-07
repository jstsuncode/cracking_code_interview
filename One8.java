// 1.8
// Assume you have a method isSubstring which checks if one word is a
// substring of another.  Given two strings, s1 and s2, write code to
// check if s2 is a rotation of s1 using only one call to isSubstring
// (e.g. "waterbottle" is a rotation of "erbottlewat").

public class One8 {
		public One8() {
		}

		public static boolean isSubstring(String big, String small) {
				return big.indexOf(small) >= 0;
		}

		public boolean isRotation(String s1, String s2) {
				if (s1.length() != s2.length()) return false;

				String sCat = s1 + s1;
				return One8.isSubstring(sCat, s2);
		}

		public static void main(String[] args) {
				One8 one8 = new One8();

				String[][] test = {
						{"waterbottle", "erbottlewat"},
						{"bath", "ebath"},
						{"bath", "bbbb"},
						{"bath", "thba"}};
				int len = 4;

				for (int i = 0; i < len; i++) {
						String s1 = test[i][0];
						String s2 = test[i][1];
						System.out.println(s1 + "," + s2 + ":" + one8.isRotation(s1, s2));
				}
	
		}
}
