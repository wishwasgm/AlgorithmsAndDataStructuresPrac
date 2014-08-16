import java.math.BigInteger;
import java.util.Scanner;


public class Halloween {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		 int count = Integer.parseInt(in.next());
	        for (int x=0;x<count;x++) {
	            System.out.println(getPieces(in.next()));
	        }
in.close();
	}

	private static BigInteger getPieces(String string) {
		long givenNum = Long.parseLong(string);
		
		long half = givenNum/2;
		if (givenNum%2==0) {
			return BigInteger.valueOf(half * half);
		} else {
			return BigInteger.valueOf((half+1) * half);
		}	
		
	}

}

