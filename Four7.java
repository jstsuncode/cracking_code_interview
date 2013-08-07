// 4.7
// Design an algorithm and write code to find the first common ancestor of two
// nodes in a binary tree.  Avoid storing additional nodes in a data structure.
// NOTE: This is not necessarily a binary search tree.

// Wrote solution from book
class Result {
		public BNode node;
		public boolean isAncestor;
		public Result(BNode n, boolean isAnc) {
				node = n;
				isAncestor = isAnc;
		}
}

public class Four7 {
		public Four7() {
		}

		static String dbg(BNode b) {
				if (b == null) return "null";
				return b.value + "";
		}

		// We recurse throught the entire tree with a function called commonAncestor
		// This function returns values as follows:
		//  - Returns p, if root's subtree includes p (and not q).
		//  - Returns q, if root's subtree includes q (and not p).
		//  - Returns null, if neither p nor q are in root's subtree.
		//  - Else returns the common ancestor of p and q
		//
		// Finding the common ancestor of p and q in the final case is easy.
		// When commonAncestor(n.left, p, q) and commonAncestor(n.right, p, q)
		// both return non-null values (indicating that p and q were found in 
		// different subtrees), then n will be the common ancestor.
		public static Result commonAncestorHelper(BNode root, BNode p, BNode q, String indent) {

				System.out.println(indent+"root="+dbg(root)+",p="+dbg(p)+",q="+dbg(q));

				if (root == null) {
						System.out.println(indent+"\t1) root is null");
						return new Result(null, false);
				}
				if (root == p && root == q) {
						System.out.println(indent+"\t2) root is both p and q");
						return new Result(root, true);
				}

				System.out.println(indent+"\t2.5) Check Left...");
				Result rx = Four7.commonAncestorHelper(root.left, p, q, indent+"\t");
				if (rx.isAncestor) { // Found common ancestor
						System.out.println(indent+"\t3) rx:"+dbg(rx.node));
						return rx;
				}

				System.out.println(indent+"\t3.5) Check Right...");
				Result ry = Four7.commonAncestorHelper(root.right, p, q, indent+"\t");
				if (ry.isAncestor) { // Found common ancestor
						System.out.println(indent+"\t4) ry:"+dbg(ry.node));
						return ry;
				}

				if (rx.node != null && ry.node != null) {
						System.out.println(indent+"\t5) root:"+dbg(root));
						return new Result(root, true); // This is the common ancestor
				} else if (root == p || root == q) {
						/* If we're currently at p or q, and we also found one of
						 * those nodes in a subtree, then this is try an ancestor
						 * and the flag should be true. */
						boolean isAncestor = rx.node != null || ry.node != null ? true: false;

						System.out.println(indent+"\t6) root:"+dbg(root));

						return new Result(root, isAncestor);
				} else {
						BNode n = rx.node != null ? rx.node : ry.node;
						System.out.println(indent+"\t7) n:"+dbg(n));
						return new Result(n, false);
				}

		}

		public static BNode commonAncestor(BNode root, BNode p, BNode q) {
				Result r = Four7.commonAncestorHelper(root, p, q, "");
				if (r.isAncestor) {
						return r.node;
				}
				return null;
		}	

		public static void main(String[] args) {
				Four7 cn = new Four7();

				// Not a bst since 8 is to right of 10.
				System.out.println("\tnotBST3");
				BNode notBST3 = new BNode(10, 0, null);
				notBST3.left = new BNode(5, 1, notBST3);
				notBST3.right = new BNode(12, 1, notBST3);
				notBST3.left.left = new BNode(3, 2, notBST3.left);
				notBST3.left.right = new BNode(14, 2, notBST3.left); // causes not being bst
				notBST3.right.left = new BNode(11, 2, notBST3.right);
				notBST3.right.right = new BNode(13, 2, notBST3.right);
				BNode.printTree(notBST3, 3);

				BNode cA = Four7.commonAncestor(notBST3, notBST3.left, notBST3.right.right);
				System.out.println("\tcommonAncestor of 5, 13 is " + dbg(cA));

		}
}
