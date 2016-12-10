//===========================================================================================================================
//Program : To find length of a longest streak of consecutive integers that occur in array A
//===========================================================================================================================
//@author: Karthika, Nevhetha, Kritika
//	Date created: 2016/10/18
//===========================================================================================================================
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class LongestStreak {
	/** Procedure to find length of a longest streak of consecutive integers that occur in array A
	 * @param A : Array, input
	 * @return longestStreakCount: int, returns a longest streak of consecutive integers
	 */
	static int longestStreak(int[] A) {
		 int prev = 0, curr = 0, count = 1, longestStreakCount = 1;
		 //Store the elements into treeset to eliminate duplicates
		 TreeSet<Integer> treeSet = new TreeSet<>();
		 for (int t : A)
			 treeSet.add(t);
		 
		 Iterator<Integer> it = treeSet.iterator();
		 if (it.hasNext()) 
			 prev = it.next();
		 //Count is incremented when the consequent integers are found else count is reset to 1
		 //count started again when steak is found 
		 while (it.hasNext()) {
			 curr = it.next();
			 if (prev == curr - 1) {
				 count++;
			 } else {
				 longestStreakCount = Math.max(count, longestStreakCount);
				 count = 1;
			 }
			 prev = curr;
		 }

		 longestStreakCount = Math.max(count, longestStreakCount);
		 return longestStreakCount;
	 }
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		 System.out.println("Enter array size :: ");
		 int n = in.nextInt();
		 int[] A = new int[n];
		 for (int i = 0; i < n; i++)
		     A[i] = in.nextInt();
		 System.out.println("\nLongest Streak :: " + longestStreak(A));
	}

}

