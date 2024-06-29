/**
 * ALL ABOUT RECURSION 
 * 
 * @Complexity : 
 * O(n log n) in worst, best and average case
 *
 * @Author Plipus Tel <https://www.plipus.tel.com>
 * @Created June 06, 2024
 * @LastModified See in github log
 * 
 * @Defenition : > Learn the fundamental of Recursive (Divide and Conquer Algorithm) is the strong knowledge to
 *                 implement advanced algorithm (like TREE, GRAPH, BST and so on...)
 *               > It's very crusial and important to uderstand how the recursion is work
 *      
 */

public class Recursion {

	/**
	 * 
	 */
	public Recursion() {
		// TODO Auto-generated constructor stub
	}

	/* POST-ORDER TRAVERSAL */
	public void Recursive(int i) {
		if(i >= 3) {
			return;
		}
		
		i++;
		Recursive(i);
		System.out.println(i);
		
		/* 
		 * WHEN YOU WRITE THE RECURSION LIKE THIS THEN:
		 *
		 * def test(n):
		 *     if > 3:
		 *  	  return
		 *     test(n+1)
		 * 	   print(n)
		 * 
		 * test(1)
		 * 
		 * THIS ILLUSTRATION IS INCORRECT !
		 * Recursive 1: test(1)
		 *              print 1
		 *     Recursive 2: test(2)
		 *                  print 2
		 *             Recursive 3: test(3)
		 *                          print 3
		 *
		 * but...
		 *
		 * THIS IS THE CORRECT ILLUSTRATION
		 * Recursive 1: test(1)
		 *	      Recursive 2: test(2)
		 *	              Recursive 3: test(3)
		 *                print(3)
		 *        print(2)
		 * print(1)
		 * After ALL the recursion is DONE, then go back to execute all the statements beneath it
		 *
		 *	print 3 <-- 1st execution, THIS IS WHY MERGE SORT ALGORITHM (DIVIDE & CONQUER) IS WORK HERE
		 *	print 2 <-- 2nd execution
		 *	print 1 <-- 3rd execution
		 *	
		 *  in desc order respectively !
		 *  
		 *  
		 *  THIS IS CALLED 'POST-ORDER TRAVERSAL'
		 */
	}
	
	public int Factorial(int n) {
		if (n == 1 || n == 0) {
			return 1;
		} else {
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
		
		// GIVEN ARRAY: {1, 3, 7, 2, 5, 8, 4, 3, 5, 8} -> 10
		
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
		int[] rightArray = new int[arrNums.length - middle]; // 11-5 = 6
		
			
		for(int i = 0; i < leftArray.length; i++) { // 1...4 (5-1)
			leftArray[i] = arrNums[i]; // 1, 3, 7, 2, 5
		}
		
		for(int i = 0; i < rightArray.length; i++) { // 5..10 (11)
			rightArray[i] = arrNums[middle++]; // 8, 4, 3, 5, 9, 8
		}

		
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
		

		System.out.print("L:" +leftArray.length + " vs " + "R:" + rightArray.length);
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
		while(l < leftArray.length) {
			arrNums[n] = leftArray[l];
			l++;
			n++;
		}
		while(r < rightArray.length) {
			arrNums[n] = rightArray[r];
			r++;
			n++;
		}
		
		for(int j: arrNums) {
			System.out.print(j + ", ");
		}
		System.out.println("");
		System.out.println("");
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Recursion Recursion = new Recursion();
		int result = Recursion.Factorial(5);
		//System.out.println(result);
		
		int[] arrNums = {1, 3, 7, 2, 5, 8, 4, 3, 5, 8};
		
		System.out.println("1. UNSORTED ARRAY: ");
		for(int arr: arrNums) {
			System.out.print(arr + ", ");
		}
		System.out.println("\n");
		System.out.println("2. DIVIDE & CONQUER ALGORITHM BREAKDOWN:");
		Recursion.Divide(arrNums);
		
		System.out.println("3. SORTED ARRAY: ");
		for(int arr: arrNums) {
			System.out.print(arr + ", ");
		}
		System.out.println("\n");
		System.out.println("4. RECURSION POST-ORDER TRAVERSAL: ");
		Recursion.Recursive(0);
	}

}
