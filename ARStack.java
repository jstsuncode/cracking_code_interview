// Used by Chapter 3
import java.util.ArrayList;
public class ARStack {

		ArrayList ar = new ArrayList();	

		public ARStack() {
		}

		public Object pop() {
				if (ar.size() == 0) return null;
				return ar.remove(ar.size()-1);
		}
		
		public void push(Object item) {
				ar.add(item);
		}

		public Object peek() {
				if (ar.size() == 0) return null;
				return ar.get(ar.size()-1);
		}

		public boolean isEmpty() {
				return (ar.size() == 0);
		}

		public String toString() {
				StringBuilder sb = new StringBuilder();
				for (int i = ar.size()-1; i >= 0; i--) {
						sb.append(ar.get(i).toString());
						if (i != 0) { sb.append("->"); }
				}
				return sb.toString();
		}

}
