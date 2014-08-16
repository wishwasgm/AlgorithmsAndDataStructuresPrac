import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.

public class AngryChildren {
   static BufferedReader in = new BufferedReader(new InputStreamReader(
         System.in));
   static StringBuilder out = new StringBuilder();

   public static void main(String[] args) throws NumberFormatException, IOException {
      int numPackets = Integer.parseInt(in.readLine());
      int numKids = Integer.parseInt(in.readLine());
      int[] packets = new int[numPackets];
      
      for(int i = 0; i < numPackets; i ++)
      {
         packets[i] = Integer.parseInt(in.readLine());
      }
      
      int unfairness = Integer.MAX_VALUE;
      
       quickSort(packets,0,packets.length-1);
       
       unfairness = calculateUnfairness(packets,numKids);
      
      System.out.println(unfairness);
   }

private static int calculateUnfairness(int[] packets, int numKids) {

	int minVal = Integer.MAX_VALUE;
	
	for (int i = 0; i < packets.length-numKids; i++) {
		
		int min = packets[(numKids-1)+i] - packets[i];
		
		if (min < 0){
			System.out.println(i);
		}
		
		if (minVal > min) {
			minVal = min;
		}
	}
	
	return minVal;

}

private static void quickSort(int[] packets,int pivot, int numOfElements) {
	
	if (pivot < numOfElements) {
 		int q = partition(packets,pivot,numOfElements);
		quickSort(packets, pivot, q);
		quickSort(packets, q+1, numOfElements);
	}
	
	
}

private static int partition(int[] a, int start, int end) {
	int pivot = a[start];
	
	while(start < end && a[start] != a[end]) {
		
		while (a[start] < pivot) {
			start ++;
		}
		
		while (a[end] > pivot) {
			end--;
		}
		
		if (start < end)
		swap(a,start,end);
	}
	
	return start;
}

private static void swap(int[] a, int start, int end) {
	int temp = a[start];
	a[start] = a[end];
	a[end] = temp;
	
}


}
