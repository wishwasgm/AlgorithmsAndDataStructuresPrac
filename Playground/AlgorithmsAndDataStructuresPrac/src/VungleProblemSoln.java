import java.util.ArrayList;

public class VungleProblemSoln
{
   private final static int TRIED = 5;
   private final static int USED_IN_HOLE = 8;
   static int num = 0;

   static int[][] grid = new int[][] { 
		    { 1, 0, 1, 1, 1, 1, 1, 0, 1, 1 },
			{ 1, 1, 1, 0, 0, 1, 0, 0, 1, 1 },
			{ 0, 1, 0, 0, 1, 1, 0, 0, 0, 0 },
			{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0 },
			{ 1, 0, 1, 0, 1, 1, 1, 0, 0, 0 },
			{ 1, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
			{ 1, 0, 0, 0, 0, 0, 1, 0, 0, 0 },
			{ 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 },
			{ 0, 0, 0, 1, 0, 1, 1, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 0, 1, 0, 0, 0 }

	};   
 
   
//   static int[][] grid = new int[][] { 
//		   {1,0,0,1},
//		   {0,1,1,0},
//		   {0,0,1,0},
//		   {0,0,0,0}
//
//
//	};
   
  static int width = grid.length;   
  static int depth = grid[0].length;

   public static void main (String[] args)
   {
      VungleProblemSoln labyrinth = new VungleProblemSoln();
      
      //System.out.println (labyrinth);
      ArrayList<Integer> holesList = new ArrayList<Integer>();

      for (int i = 0; i < width; i++) {
    	  for (int j = 0; j < depth; j++) {
    		  if (grid[i][j] != TRIED && grid[i][j] != USED_IN_HOLE){
    			  labyrinth.traverse (i, j);
    			  if (num >0){
        			  //System.out.println(num);
    				  holesList.add(num);
        		  }
        		  num = 0;
    		  }
    	  }
      
		
	}
      
      
//      if (labyrinth.traverse (0, 0))
//         System.out.println ("The maze was successfully traversed!");
//      else
//         System.out.println ("There is no possible path.");
//
      System.out.println (labyrinth);
   }

 //----------------------------------------------------------
   //  Attempts to recursively traverse the maze. Inserts
   //  special characters indicating locations that have been
   //  tried and that eventually become part of the solution.
   //----------------------------------------------------------
   public boolean traverse (int row, int column)
   {
      boolean done = false;
      //System.out.println(this);
      
      //if (valid (row, column))
      {

    	  if (row >= grid.length || column >= grid[0].length) {
    		  return done;
    	  }
    	 
    	  if (grid[row][column] == 1) {
    		  grid[row][column] = TRIED;
    		  
    		  return true;
    		  
    		  
    		  
    	  } else  if (grid[row][column] == 0) {
    		  grid[row][column] = USED_IN_HOLE;
    		  num++;
    		  done = false;
    		  if (row<grid.length-1 && (grid[row+1][column] != TRIED || grid[row+1][column] != USED_IN_HOLE) && !done) {
    			  traverse(row+1, column); // down
        		  }
    		  if (column>0 && row>0 && (grid[row-1][column-1] != TRIED ||grid[row-1][column-1] != USED_IN_HOLE) && !done) {
    			  traverse(row, column-1); // left
    		  }
    		  if (column <= grid[0].length-2 && (grid[row][column+1] != TRIED||grid[row][column+1] != USED_IN_HOLE) && !done) {
        		  traverse(row, column+1); // right
        		  }
        		 
    		  if (row>0 && (grid[row-1][column] != TRIED||grid[row-1][column] != USED_IN_HOLE) && !done) {
        		  traverse(row-1, column); // up
        		  }
    		  
    		  
    	  }
    	  
    	 
    	 
      }
       return done;
    }
   
   
   public boolean traverseRecursively2 (int row, int column)
   {
      boolean done = false;
      //System.out.println(this);
      
      {

    	  if (row >= grid.length || column >= grid[0].length) {
    		  return done;
    	  }
    	 
    	  if (grid[row][column] == 1) {
    		  grid[row][column] = TRIED;
    		  
    		  return done;
    		  
    		  
    		  
    	  } else  if (grid[row][column] == 0) {
    		  grid[row][column] = USED_IN_HOLE;
    		  num++;
    		  done = false;
    		  if (row<grid.length-1 && (grid[row+1][column] != TRIED || grid[row+1][column] != USED_IN_HOLE) && !done) {
    			  done = traverse(row+1, column); // down
        		  }
    		  if (column>0 && row>0 && (grid[row-1][column-1] != TRIED ||grid[row-1][column-1] != USED_IN_HOLE) && !done) {
    			  traverse(row, column-1); // left
    		  }
    		  if (column <= grid[0].length-2 && (grid[row][column+1] != TRIED||grid[row][column+1] != USED_IN_HOLE) && !done) {
        		  traverse(row, column+1); // right
        		  }
        		 
    		  if (row>0 && (grid[row-1][column] != TRIED||grid[row-1][column] != USED_IN_HOLE) && !done) {
        		  traverse(row-1, column); // up
        		  }
    		  
    		  if (num >0){
    			  System.out.println(num);
    		  }
    		  num = 0;
    	  }
    	 
      }
       return done;
    }
   
   //------------------------------------------------------------
   //  Determines if a specific location is valid.
   //------------------------------------------------------------
   private boolean valid (int row, int column)
   {
      boolean result = false;
 
      // check if cell is in the bounds of the matrix
      if (row >= 0 && row < grid.length &&
          column >= 0 && column < grid[row].length)

         //  check if cell is not blocked and not previously 
         //  tried
         if (grid[row][column] == 1)
            result = true;

      return result;
   }
   
   public boolean traverse2 (int row, int column)
   {
      boolean done = false;
      
      //if (valid (row, column))
      {
         //grid[row][column] = TRIED;  // this cell has been tried

         if (row == grid.length-1 && column == grid[0].length-1)
            done = true;  // the maze is solved
         else
         {
            if (grid[row][column] == 0) {
            	num++;
            	traverse (row, column-1);
            	traverse (row, column+1); 
            	traverse (row-1, column); 
            	//traverse (row, column+1);
            } else {
            	if (num > 0) {
            	System.out.println(num);
            	num = 0;
            	}
            	traverse (row, column+1); 
            }
//             done = traverse (row+1, column);     // down
//             if (!done)
//                done = traverse (row, column+1);  // right
//             if (!done)
//                done = traverse (row-1, column);  // up
//             if (!done)
//                done = traverse (row, column-1);  // left
          }

          if (done)  // this location is part of the final path
             grid[row][column] = USED_IN_HOLE;
       }
       
       return done;
    }
   
 
 //------------------------------------------------------------
   //  Returns the maze as a string.
   //------------------------------------------------------------
   public String toString ()
   {
      String result = "\n";

      for (int row=0; row < grid.length; row++)
      {
         for (int column=0; column < grid[row].length; column++)
            result += grid[row][column] + "";
         result += "\n";
      }

      return result;
   }
}
