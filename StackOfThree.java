// Used by 3.1
import java.util.ArrayList;

class StackData {
		public int pos;
		public int count = 0;
		public int size = 10;
		
		public StackData(int p) {
				this.pos = p;
		}
}

public class StackOfThree {

		private ArrayList gArray = new ArrayList(30);

		StackData[] stacks = {
				new StackData(0),
				new StackData(10),
				new StackData(20)
		};
		
		public Object pop(int num) {
				StackData sd = stacks[num];
				if (sd.count == 0) return null;

				int topIdx = sd.pos + sd.count - 1;
				Object o = gArray.get(topIdx);
				gArray.set(topIdx, null);
				sd.count--;

			 	return o;			
		}
		
		public Object peek(int num) {
				StackData sd = stacks[num];
				if (sd.count == 0) 
					return null;
				
				int topIdx = sd.pos + sd.count - 1;
				return gArray.get(topIdx);
		}
	
		public void push(int num, Object o) {
				StackData sd = stacks[num];

				if (sd.count < sd.size) {
						gArray.set(sd.pos+sd.count, o);
						sd.count++;
				} else {
						// need to insert in extra elements in arraylist
						ArrayList ar = new ArrayList(10);
						for (int i = 0; i < 10; i++) { ar.add(null); };

						gArray.addAll(sd.pos+sd.count, ar);

						gArray.set(sd.pos + sd.count, o);
						sd.count++;
						sd.size += 10;
					
						if (num == 2) return;
						if (num < 2) { 
								// shift elements
								StackData sd2 = stacks[2];
								sd2.pos += 10;
						}
						if (num < 1) {
								// shift elements
								StackData sd1 = stacks[1];
								sd1.pos += 10;
						}
				}
		}
}
