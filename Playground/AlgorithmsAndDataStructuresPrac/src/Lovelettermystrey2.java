import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lovelettermystrey2 {

	public static void main(String[] args) throws FileNotFoundException {
		
		boolean fileInput = true;
		if (fileInput  ) {
			String inputString ="";

			//Scanner console = new Scanner(System.in);           

			System.out.println("File to be read: ");
			String inputFile = "c:\\input01.txt";

			File file = new File(inputFile);
			Scanner in = new Scanner(file);
			
			int count = Integer.parseInt(in.nextLine());

			int words = 0;
			int lines = 0;
			int chars = 0;
			while(in.hasNextLine())  {
				lines++;
				inputString = in.nextLine();
				int m = solveOperations(inputString);
				System.out.println(m);
				
			}
System.out.println("lines: "+lines);
			in.close();
		}

		else {
			Scanner in = new Scanner(System.in);
			int count = in.nextInt();
			int[] ouput = new int[count];
			for (int x=0;x<count-1;x++) {
				String input = in.next();
				NumOfOpsToPalindrome(input);


			}
			in.close();
		}
	}

	private static int NumOfOpsToPalindrome(String string) {

		int numOps = 0;
		StringBuilder stringBuilder = new StringBuilder(string);
		if (isPalindrome(stringBuilder.toString())) {
			System.out.println(numOps);
			return numOps;
		}
		int strLen = string.length();
		for (int i = strLen-1; i >= 0; i--) {
			int j = (int)string.charAt(i);

			while (j > (int)'a') {
				stringBuilder.setCharAt(i, (char)((int)(stringBuilder.charAt(i))-1));
				numOps++;

				if (isPalindrome(stringBuilder.toString())) {
					System.out.println(numOps);
					return numOps;
				}

				j--;
			}
		}
		return numOps;
	}
	
	static int solveOperations(String letter){
	    int operations = 0;
	    for (int i=0; i<letter.length()/2; i++){

	        char left = letter.charAt(i);
	        char right = letter.charAt(letter.length()-1-i);
	        int leftValue = (int)left;
	        int rightValue = (int)(right);
	        if (leftValue != rightValue){
	            int difference = Math.abs(leftValue - rightValue);
	            operations += difference;
	        }
	    }
	    return operations;
	}

//	public static boolean isPalindrome(String word) {
//
//		char[] charsInWord = word.toCharArray();		
//
//		for (int i = 0; i < charsInWord.length; i++) {
//			if (charsInWord[i] != charsInWord[charsInWord.length - i - 1]) {
//				return false;
//			}
//		}
//
//		return true;
//	}
	
	public static boolean isPalindrome(String str)
	{
	    //test for end of recursion
	    if(str.length() < 2) {return true;}

	    //check first and last character for equality
	    if(str.charAt(0) != str.charAt(str.length() - 1)){return false;}

	    //recursion call 
	    return isPalindrome(str.substring(1, str.length() - 1));
	}
}
