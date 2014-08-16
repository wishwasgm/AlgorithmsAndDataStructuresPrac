/**
 * @author Wishwas Mohan
 */

import java.util.ArrayList;
import java.util.Collections;

public class VungleProblemSolnFinal {
	private final static int TRIED = 5;
	private final static int USED_IN_HOLE = 8;
	static int numOfHoles = 0;

	//Input
	static int[][] checkerBoard = new int[][] {
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

	//Smaller Input
	
	// static int[][] grid = new int[][] {
	// {1,0,0,1},
	// {0,1,1,0},
	// {0,0,1,0},
	// {0,0,0,0}
	//
	//
	// };

	static int width = checkerBoard.length;
	static int depth = checkerBoard[0].length;

	public static void main(String[] args) {
		VungleProblemSolnFinal vungleProblemSolnFinal = new VungleProblemSolnFinal();

		ArrayList<Integer> holesCountList = new ArrayList<Integer>();

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < depth; j++) {
				if (checkerBoard[i][j] != TRIED
						&& checkerBoard[i][j] != USED_IN_HOLE) {
					vungleProblemSolnFinal.traverse(i, j);
					if (numOfHoles > 0) {
						// System.out.println(num);
						holesCountList.add(numOfHoles);
					}
					numOfHoles = 0;
				}
			}

		}
		
		Collections.sort(holesCountList);
		
		for (Integer integer : holesCountList) {
			System.out.print(integer+",");
		}
		
	}
	

	public boolean traverse(int row, int column) {
		boolean done = false;

		if (row >= checkerBoard.length || column >= checkerBoard[0].length) {
			return done;
		}

		//If the element is one, just mark it as tried and move on.
		if (checkerBoard[row][column] == 1) {
			checkerBoard[row][column] = TRIED;

			return true;

		} else if (checkerBoard[row][column] == 0) { // else check the neighbouring elements and mark them as used 
			checkerBoard[row][column] = USED_IN_HOLE;
			numOfHoles++;
			done = false;
			if (row < checkerBoard.length - 1
					&& (checkerBoard[row + 1][column] != TRIED || checkerBoard[row + 1][column] != USED_IN_HOLE)
					&& !done) {
				traverse(row + 1, column); // traverse down
			}
			if (column > 0
					&& row > 0
					&& (checkerBoard[row - 1][column - 1] != TRIED || checkerBoard[row - 1][column - 1] != USED_IN_HOLE)
					&& !done) {
				traverse(row, column - 1); // traverse left
			}
			if (column <= checkerBoard[0].length - 2
					&& (checkerBoard[row][column + 1] != TRIED || checkerBoard[row][column + 1] != USED_IN_HOLE)
					&& !done) {
				traverse(row, column + 1); // traverse right
			}

			if (row > 0
					&& (checkerBoard[row - 1][column] != TRIED || checkerBoard[row - 1][column] != USED_IN_HOLE)
					&& !done) {
				traverse(row - 1, column); // traverse up
			}

		}

		return done;
	}
}
