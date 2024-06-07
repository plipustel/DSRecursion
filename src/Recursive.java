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
	//		System.out.println(n);
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
	
	public void Divide(int[] arrNums) {
		
		// {1, 3, 7, 2, 5, 8, 4, 3, 5, 9, 8}; -> 11
		
		/*
		 *  Must arrNums.length <= 1, if only arrNums.length < 1, then this will happen:
		 *  
		 *  - In 'leftArray' recursion, this is no problem but NOT for 'rightArray' recursion, since:
		 *    --  When the length of 'leftArray' is '0', the recursion can be terminated, but the recursive(rightArray)
		 *        will cause the problem because the length of 'rightArray' is 1, which mean the condition NEVER found,
		 *        causes the infinite recursion (error)
		 * */
				
		if(arrNums.length <= 1) {
			return;
		}	

		/* When length = 1 -> middle 1/2 = 0 not 0.5*/
		int middle = Math.round(arrNums.length / 2); // 5
		
		
		int[] leftArray = new int[middle]; // 5
		int[] rightArray = new int[arrNums.length - middle]; // 11-5=6
		
			
		for(int i = 0; i < leftArray.length; i++) { // 1...4 (5-1)
			leftArray[i] = arrNums[i]; // 1, 3, 7, 2, 5
		}
		
		for(int i = 0; i < rightArray.length; i++) { // 5..10 (11)
			rightArray[i] = arrNums[middle++]; // 8, 4, 3, 5, 9, 8
		}
		
//		for(int i : leftArray) {
//			System.out.print("L-"+ i + ", ");
//		}
//		System.out.print("|| ");
//		for(int i : rightArray) {
//			System.out.print("R-"+ i + ", ");
//		}
//	
//		System.out.println("");
//		System.out.println("");

		
		Divide(leftArray);
		Divide(rightArray);
		
		for(int i : leftArray) {
			System.out.print("L+"+ i + ", ");
		}
		System.out.print("|| ");
		for(int i : rightArray) {
			System.out.print("R+"+ i + ", ");
		}
	
		System.out.println("");
		System.out.print(leftArray.length + " vs " + rightArray.length);
		System.out.println("");
		
		int l = 0;
		int r = 0;
		int n = 0;
		
		while(l < leftArray.length && r < rightArray.length) {
			System.out.println(leftArray[l] + " < " + rightArray[r] + " ? ");
			if(leftArray[l] < rightArray[r]) {
				arrNums[n] = leftArray[l];
				l++;
				n++;
			} else {
				arrNums[n] = rightArray[r];
				r++;
				n++;	
			}			
		}
		
//		while(l < leftArray.length) {
//			arrNums[n] = leftArray[l];
//			l++;
//			n++;
//		}
//		while(r < rightArray.length) {
//			arrNums[n] = rightArray[r];
//			r++;
//			n++;
//		}
//		
//		for(int j: arrNums) {
//			System.out.print(j + ", ");
//		}
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Recursive Recursion = new Recursive();
		int result = Recursion.Factorial(5);
		//System.out.println(result);
		
		int[] arrNums = {1, 3, 7, 2, 5, 8, 4, 3, 5, 8};
		
		for(int arr: arrNums) {
			System.out.print(arr + ", ");
		}
		System.out.println("\n");
		Recursion.Divide(arrNums);
		for(int arr: arrNums) {
			System.out.print(arr + ", ");
		}
	}

}
