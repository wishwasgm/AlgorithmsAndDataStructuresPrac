import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GOT {

	public static void main(String[] args) throws FileNotFoundException {
		
		boolean fileInput = false;
		if (fileInput ) {
//		Scanner myScan = new Scanner(System.in);
//		String inputString = myScan.nextLine();
      String inputString ="";
		
          Scanner console = new Scanner(System.in);           

         System.out.println("File to be read: ");
         String inputFile = console.next();

         File file = new File(inputFile);
         Scanner in = new Scanner(file);

		int words = 0;
	    int lines = 0;
	    int chars = 0;
	    while(in.hasNextLine())  {
	        lines++;
	        inputString = in.nextLine();
	    }
	    
	    boolean hasPalindrome = NumOfCharsIndicarePalindrome(inputString);
//		if (NumOfCharsIndicarePalindrome(inputString)) {
//			hasPalindrome = createAnagramAndCheckForPalindrome("",inputString);
//		}

		

		String ans = hasPalindrome ? "YES" : "NO";
		// Assign ans a value of s or no, depending on whether or not
		// inputString satisfies the required condition
		System.out.println(ans);
		//myScan.close();
		}
		
		else {
			Scanner myScan = new Scanner(System.in);
			String inputString = myScan.nextLine();
	      
		    
		    boolean hasPalindrome = NumOfCharsIndicarePalindrome(inputString);
//						

			String ans = hasPalindrome ? "YES" : "NO";
			// Assign ans a value of s or no, depending on whether or not
			// inputString satisfies the required condition
			System.out.println(ans);
			//myScan.close();
		}
	}

	public static boolean createAnagramAndCheckForPalindrome(String prefix,
			String word) {
		int len = word.length();
		if (len == 0) {
			return isPalindrome(prefix);
		}

		for (int i = 0; i < len; i++) {
			boolean ispal = createAnagramAndCheckForPalindrome(
					prefix + word.charAt(i),
					word.substring(0, i) + word.substring(i + 1, len));
			if (ispal) {
				return true;
			}

		}
		return false;
	}

	public static boolean isPalindrome(String word) {

		char[] charsInWord = word.toCharArray();		

		for (int i = 0; i < charsInWord.length; i++) {
			if (charsInWord[i] != charsInWord[charsInWord.length - i - 1]) {
				return false;
			}
		}

		System.out.println(word + " is a palindrome !");
		return true;
	}

	private static boolean NumOfCharsIndicarePalindrome(String word) {
		HashMap<Character, Integer> countMap = new HashMap<>();
		for (char c : word.toCharArray()) {
			if (countMap.containsKey(c)) {
				int count = countMap.get(c).intValue()+1;
				countMap.remove(c);
				countMap.put(c, count);
			} else {
			countMap.put(c, 1);
			}
		}
		
		int numOfOdd = 0;
		for (int count : countMap.values()) {
			if (count%2==1) {
				numOfOdd ++;
			}
		}
		
		return (numOfOdd == 1 || numOfOdd == 0);
		
	}

}
