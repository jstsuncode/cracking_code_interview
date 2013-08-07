// 4.2
// Given a directed graph, design an algorithm to find out whether there is a route
// between two nodes.

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

enum GState {
		Unvisited, Visited, Visiting;
}

class GNode {
		public int value;
		GState state = GState.Unvisited;
		public ArrayList<GNode> adjacent = new ArrayList<GNode>();

		public GNode(int value) {
				this.value = value;
		}

		// return list of adjacent that node connects to
		public ArrayList<GNode> getAdjacent() {
				return this.adjacent;
		}

}

class Graph {
		public ArrayList<GNode> nodes = new ArrayList<GNode>();
		public GNode root = null;
		
		public Graph() {
		}

		public ArrayList<GNode> getNodes() {
				return nodes;
		}

		private void bfsh(Queue<GNode> q) {
				while (!q.isEmpty()) {
						GNode n = q.poll();
						n.state = GState.Visited;
						System.out.println("BFS Visited " + n.value);

						for (GNode neighbor : n.getAdjacent()) {
								if (neighbor.state != GState.Visited) {
									q.add(neighbor);
								}
						}
				}
		}

		public void bfs() {
				if (root == null) return;

				this.clearVisitedState();

				// pseudocode
				// pre-order

				// if queue q not empty
				// item = q.pop
  				// print item
	  			// push adjacent vertices to q
				Queue<GNode> q = new LinkedList<GNode>();
				q.add(root);

				bfsh(q);
		}

		private void dfsh(ARStack s) {
				while (!s.isEmpty()) {
						GNode n = (GNode) s.pop();
						n.state = GState.Visited;
						System.out.println("DFS Visited " + n.value);

						for (GNode neighbor : n.getAdjacent()) {
								if (neighbor.state != GState.Visited) {
									s.push(neighbor);
								}
						}
				}
		}

		public void dfs() {
				if (root == null) return;

				this.clearVisitedState();

				// pseudocode
				// pre-order
				
				// if stack s not empty
				// item = s.pop
			 	//	  print item
				//	  push adjacent vertices to s
				ARStack s = new ARStack();
				s.push(root);
				
				dfsh(s);
		}

		private void clearVisitedState() {
				for (GNode g : nodes) { g.state = GState.Unvisited; }
		}

		public boolean hasRouteBFS(GNode src, GNode dest) {
				if (src == null || dest == null) return false;

				if (src == dest) return true;

				this.clearVisitedState();	

				Queue<GNode> q = new LinkedList<GNode>();
				src.state = GState.Visiting;
				q.add(src);				

				//System.out.println("Start at " + src.value);

				while (!q.isEmpty()) {
						GNode g = q.poll();

						//System.out.println("Visited " + g.value);

						for (GNode neighbor : g.getAdjacent()) {

								if (neighbor.state == GState.Unvisited) {
									if (neighbor == dest) {
											//System.out.println("Found path to " + dest.value);
											return true;
									} else {
											neighbor.state = GState.Visiting;
											q.add(neighbor);
									}
								}
						}
						g.state = GState.Visited;						
				}
				return false;
		}

}

public class Four2 {
	public Four2() {
	}

	public static void main(String[] args) {
		Four2 cn = new Four2();

		Graph graph = new Graph();
		for (int i = 0; i < 10; i++) {
				GNode n = new GNode(i+1);
				graph.nodes.add(n);
		}

		// Create edges 

		System.out.println("Create edges between vertices");

		// 1->2 1->3 1->4
		// 2->8 2->7
		// 3->5
		// 5->6
		// 8->9
		// 9->10
		// 10->5 (makes it not a minimum spanning graph)
		int[][] edges = new int[][] {{1,2}, {1,3}, {1,4}, {2,7}, {2,8}, {3,5}, {5,6}, {8,9}, {9,10}, {10,5}};

		ArrayList<GNode> nodes = graph.getNodes();	

		for (int i = 0; i < edges.length; i++) {
				int src = edges[i][0], dest = edges[i][1];
				nodes.get(src-1).adjacent.add(nodes.get(dest-1));
				System.out.println("Created edge from "+src+"->"+dest);				
		}

		// Set root
		graph.root = nodes.get(0);

		// Call BFS
		graph.bfs();

		// Call DFS
		graph.dfs();

		// Check route
		System.out.println("Check if route");

		int[][] routes = new int[][] {{1,10}, {3,6}, {4,8}, {3, 10}, {8, 1}, {2, 7}, {8, 8}, {10, 6}, {8, 6}};

		for (int i = 0; i < routes.length; i++) {
				int src = routes[i][0], dest = routes[i][1];
				System.out.println(src+"->"+dest+": " + graph.hasRouteBFS(nodes.get(src-1), nodes.get(dest-1)));				
		}

	}
}
