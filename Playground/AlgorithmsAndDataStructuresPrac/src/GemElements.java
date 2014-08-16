import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class GemElements {

	public GemElements() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<List<String>> lists = new ArrayList<>();
		int count = Integer.parseInt(in.next());
		String[] ouput = in.toString().split("\\n");
		for (int x=0;x<count;x++) {
			String input = in.next();
			//System.out.println(findGemElements(input));
			List<String> asList = Arrays.asList(input.split("(?!^)"));
			lists.add(asList);
		}
		
		findGemElements(lists);
		in.close();
	}

	private static void findGemElements(List<List<String>> lists) {
		
		ArrayList<String> newset = new ArrayList<>();
				
		newset.addAll(lists.get(0));
				
		for (int i = 1; i < lists.size(); i++) {
			newset.retainAll(lists.get(i));
		}
		
		HashSet set = new HashSet<>(newset);
		System.out.println(set.size());
	}

}
