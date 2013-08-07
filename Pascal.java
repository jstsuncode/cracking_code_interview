import java.util.*;

public class Pascal {
		public Pascal() {
		}

		public ArrayList<Integer> getRow(ArrayList<ArrayList<Integer>> map, int n) {
				ArrayList<Integer> row = null;

				if (n == 0 || n == 1)	
						return map.get(n);
				else { 
						ArrayList<Integer> prevRow = getRow(map, n-1);
						row = new ArrayList<Integer>();
						row.add(1);
					
						for (int i = 0; i < prevRow.size() - 1; i++) {
								int l = prevRow.get(i);
								int r = prevRow.get(i+1);
								row.add(l+r);
						}
						row.add(1);
						map.add(row);
						
						return row;
				}				
		}

		public void printPascal(int n) {
				ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();

				ArrayList<Integer> r0 = null;
				ArrayList<Integer> r1 = null;
				r0 = new ArrayList<Integer>();
				r1 = new ArrayList<Integer>();
				r0.add(1);				
				r1.add(1);
				r1.add(1);

				map.add(r0); // Row 0
				map.add(r1); // Row 1

				getRow(map, n);

			 	for (int i = 0; i < map.size(); i++) {
						ArrayList<Integer> row = map.get(i);
						for (int j = 0; j < row.size(); j++) {
								System.out.print(row.get(j) + " ");
						}
						System.out.println();
				}
		}

		public static void main(String[] args) {
				Pascal p = new Pascal();

				int n = (Integer) Integer.parseInt(args[0]);
				if (n > 0) {
					p.printPascal(n-1);
				}	else {
						System.out.println("n must be greater than 0");
				}
		}
}
