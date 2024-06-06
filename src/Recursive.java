/**
 * ALL ABOUT RECURSIVE 
 * 
 * @Complexity : 
 * - O(1) best case 
 * - O(log n) worst case
 *
 * @Author Plipus Tel <https://www.plipus.tel.com>
 * @Created June 06, 2024
 * @LastModified See in github log
 * 
 * @Defenition : > Tree Data Structure is inverted tree, whis has root and nodes
 * 
 * 1. TREE 				   : The fundamental of tree explaining the elements in the tree, root, node, leaf, edges, height, 
 *                           depth... and so on..
 *                           
 * 2. BINARY TREE          : Tree whish has at most 2 nodes
 * 3. BINARY TREE TRAVERSAL: It's about visiting the nodes in the tree, consits of two
 * 
 *    A. BREATH FIRST SEARCH (BFS): Visiting the nodes in the same level of sub tree (branch), in sideways direction
 *    B. DEPTH FIRST SEARCH (DFS): Visitin the nodes from root to the leaf in downwards direction
 *    
 *       DFS consits 3 methods:
 *       1. DFS PreOrder Traversal
 *          - Recursively visiting the sub-tree (branch) from root -> left -> right AND move to 
 *            the another branch root -> left -> right, and so on unit there is not nodes is remaining (Node is NULL)
 *          - Character only print 'root' node, recursively until it all done
 *          
 *       2. DFS InOrder Traversal
 *       
 *          - Typically implemented in Binary Search Tree (BST)
 *          
 *       3. DFS PostOrder Traversal
 *      
 */

public class Recursive {

	/**
	 * 
	 */
	public Recursive() {
		// TODO Auto-generated constructor stub
	}

	public int Factorial(int n) {
		if (n == 1 || n == 0) {
			return 1;
		} else {
			System.out.println(n);
			return n * Factorial(n - 1); // recursive call
		}
		
		/* BREAK DOWN: 
		 * n = 5;
		 * n! = 5 * (5-1) * (4-1) * (3-1) * (2-1) * 1 
		 * n! = 5 * 4 * 3 * 2 * 1 = 120
		 * 
		 * 
		 * Factorial(5):
		 *   is n == 1 or n == 0 ? NO, n=5
		 *   5 * Factorial(5-1):
		 *          is n == 1 or n == 0 ? NO, n=4
		 *          4 * Factorial(4-1):
		 *              is == 1 or n == 0 ? NO, n=3
		 *              3 * Factorial
		 * 
		 * 
		 * 
		 * */
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Recursive recursive = new Recursive();
		int result = recursive.Factorial(5);
		System.out.println(result);
	}

}
