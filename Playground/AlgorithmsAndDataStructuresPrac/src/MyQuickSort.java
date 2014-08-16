import java.util.ArrayList;

public class MyQuickSort {

    /**
     * @param args
     */
    public static void main(String[] args) {

        //int[] a = { 1, 23, 45, 2, 8, 134, 9, 4, 2000 };
        int a[]={23,44,1,2009,2,88,123,7,999,1040,88};
        //int a[] ={6327, 571, 6599, 479, 7897, 9322, 4518, 571, 6677, 7432, 815, 6920, 4329, 4104, 7775, 5708, 7991, 5802, 8619, 6053, 7539, 7454, 9000, 3267, 6343, 7165, 4095, 439, 5621, 4095, 153, 1948, 1018, 6752, 8779, 5267, 2426, 9649, 2190, 9103, 7081, 3006, 2376, 7762, 3462, 151, 3471, 1453, 2305, 8442};
        quickSort(a, 0, a.length - 1);
        for (int i : a) {
        	System.out.println(i);	
		}
        
        ArrayList al = new ArrayList();
    }

    public static void quickSort(int[] a, int p, int r)
    {
        if(p<r)
        {
            int q=partition(a,p,r);
            quickSort(a,p,q);
            quickSort(a,q+1,r);
        }
    }

    private static int partition(int[] a, int p, int r) {

        int piv = a[p];
        
        while (p<r && a[p] != a[r]) {
            
            while ( a[p] < piv)
                p++;
            
            while (a[r] > piv)
               r--;

            if (p < r)
                swap(a, p, r);                
                
        }
        return p;
    }

    private static void swap(int[] a, int i, int j) {
        // TODO Auto-generated method stub
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}