//===========================================================================================================================
//Program : To find how many pairs of elements of array A sum to X
//===========================================================================================================================
//@author: Karthika, Nevhetha, Kritika
//	Date created: 2016/10/18
//===========================================================================================================================

import java.util.Scanner;
import java.util.TreeMap;

public class HowMany {

	/** Procedure to find how many pairs of elements of array A sum to X
	 * @param A : Array, input
	 * @param X : int, sum target
	 * @return count : int, returns count of pairs of elements of array that sum to X
	 */
	 static int howMany(int[] A, int X) {
		int count = 0;
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		int i = 0;
		//Store elements in the treemap with their count of occurances
		for (int t : A) {
			if(treeMap.containsKey(t)) {
				i = treeMap.get(t);
				treeMap.put(t, i + 1);
			} else {
				treeMap.put(t, 1);
			}
		}
		//For each element which gives another element when subtracted from the sum target,
		//add the count of another element with its count and return the total count
		for (int t : A) {
			if ( t < X - t ) {
				count = count + treeMap.get(X - t); 
			}
		}
		return count;
	 }
	 
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 System.out.println("Enter array size :: ");
		 int n = in.nextInt();
		 int[] A = new int[n];
		 System.out.println("Enter array elements :: ");
		 for (int i = 0; i < n; i++)
		     A[i] = in.nextInt();
		 System.out.println("Enter sum target :: ");
		 int sum = in.nextInt();
		 System.out.println("How may pairs :: " + howMany(A, sum));
	}

}

