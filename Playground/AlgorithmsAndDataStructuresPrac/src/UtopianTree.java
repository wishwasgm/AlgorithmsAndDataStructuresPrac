import java.util.Scanner;

class UtopianTree {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for (int x=0;x<count;x++) {
            System.out.println(printTreeHeight(in.nextInt()));
        }
      
        //int _b;
        //_b = in.nextInt()
        //int numOfTestCases = Integer.parseInt(args[0]);
        //for (int i=1;i<numOfTestCases+1;i++) {
          //  System.out.println(printTreeHeight(Integer.parseInt(args[i])));
        //}
    }
        public static int printTreeHeight(int num) {
            int j=1;
            int initialHeight = 1;
            while(j<=num){
               if (j%2 == 0){
            	   initialHeight += 1;
               } 
                else {
                	 initialHeight *= 2;
                }
               j++;
            }
            
            return initialHeight;
        }
    }
