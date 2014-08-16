
public class StringPermutations {

	public StringPermutations() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		String str = "Wishwas";
		printPermu("",str);
	}

	private static void printPermu(String prefix, String str) {
		int length = str.length();
		if (length == 0) {
			System.out.println(prefix);
		}
		
				
		for (int i = 0; i < length; i++) {
			printPermu(prefix+str.charAt(i), str.substring(0,i) + str.substring(i+1,length));
		}
		
	}

}
