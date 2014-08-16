import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lovelettermystrey {

	public static void main(String[] args) throws FileNotFoundException {
		
		
			Scanner in = new Scanner(System.in);
			int count = Integer.parseInt(in.next());
			String[] ouput = in.toString().split("\\n");
			for (int x=0;x<count;x++) {
				String input = in.next();
				System.out.println(solveOperations(input));


			}
			in.close();
		
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

}
