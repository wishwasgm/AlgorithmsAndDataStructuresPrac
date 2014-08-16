
public class C3Prob {

	private static String path = "";

	public static void main(String[] args) {

		int a[][] = new int[][]{
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}};

		String output = "1,5,9,13,14,15,16,12,8,4,3,2,6,10,11,7"; 
		
		traverse(a,0,0);
		
		System.out.println(path);

	}

	private static String traverse(int[][] a, int row, int col) {
		
		
		if (row >= a.length || col >= a[0].length) {
		return path;
		}
//			
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i][col]);
			path += a[i][col];	
			row++;
		}
		
		for (int i = 1; i < a[0].length; i++) {
			path += a[row-1][i];
			System.out.println(a[row-1][i]);
			col++;
		}
		
		for (int i = row-2; i >=0; i--) {
			path += a[i][col-1];	
			System.out.println(a[i][col]);
			row--;
		}
		
		for (int i = col-1; i >=0; i--) {
			path += a[row-1][i];
			System.out.println(a[row-1][i]);
			col--;
		}
		
		int[][] copy = new int[a.length-1][a[0].length-1];
		System.arraycopy(a, 1, copy, 1, a.length-2);
		
		return path;
		
	}

	private static int[] partArray(int[] array, int size) {
	    int[] part = new int[size];
	    System.arraycopy(array, 0, part, 0, size);
	    
	    return part;
	}
}
