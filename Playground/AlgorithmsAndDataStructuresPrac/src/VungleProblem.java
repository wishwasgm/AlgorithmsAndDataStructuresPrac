public class VungleProblem {

	public VungleProblem() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[][] checkboardInput = new int[][] { { 1, 0, 1, 1, 1, 1, 1, 0, 1, 1 },
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

		//countNumOfHolesInCheckBoard(multi);
		// First get the width of the array
				int arrayWidth = checkboardInput.length;

				// Get the depth of the array
				int arrayDepth = checkboardInput[0].length;

				int holeCount = 0;

				// Iterate over the breadth of the array and for each element check the
				// depth
				for (int i = 0; i < arrayWidth; i++) {
					for (int j = 0; j < arrayDepth; j++) {
						//countNumOfHolesInCheckBoardUsingRecursion();
					}
				}
					

	}

	public static void countNumOfHolesInCheckBoard(int[][] checkboardInput) {

		// First get the width of the array
		int arrayWidth = checkboardInput.length;

		// Get the depth of the array
		int arrayDepth = checkboardInput[0].length;

		int holeCount = 0;

		// Iterate over the breadth of the array and for each element check the
		// depth
		for (int i = 0; i < arrayWidth; i++) {
			for (int j = 0; j < arrayDepth; j++) {
				if (checkboardInput[i][j] != 0) {
					// If the first element of the array being considered( the
					// element in the inner array)
					// is not 0, just break out of this loop
					continue;
				}

				// Found the first 0
				holeCount++;

				int countOfElementsToTheRight = arrayWidth - j;
				int countOfElementsToTheLeft = j;

				// Check if the neighbouring elements in the inner array is also
				// a 0. If yes add to the holecount
				// and continue along the width

				for (int k = j + 1; k < countOfElementsToTheRight; k++) {
					if (checkboardInput[j][k] == 0) {
						holeCount++;
					} else {
						break;
					}
				}

				System.out.println(holeCount);
				holeCount = 0;
				continue;
			}
		}
	}

	public static int countNumOfHolesInCheckBoardUsingRecursion(
			int[][] checkboardInput) {

		// First get the width of the array
		int arrayWidth = checkboardInput.length;

		// Get the depth of the array
		int arrayDepth = checkboardInput[0].length;

		int holeCount = 0;

		// Iterate over the breadth of the array and for each element check the
		// depth
		for (int i = 0; i < arrayWidth; i++) {
			for (int j = 0; j < arrayDepth; j++) {
				if (checkboardInput[i][j] != 0) {
					// If the first element of the array being considered( the
					// element in the inner array)
					// is not 0, just break out of this loop
					return 0;
				}

				else return countNumOfHolesInCheckBoardUsingRecursion(checkboardInput);

			}
		}
		return holeCount;
	}
}
