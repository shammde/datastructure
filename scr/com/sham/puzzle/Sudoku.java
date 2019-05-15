package com.sham.puzzle;
public class Sudoku {

	private static int SIZE = 9;
	private static int UNSET = 0;
	
	public static void main(String args[]){

		/* int sudoku [] [] = {{5,3,0,  0,7,0,  0,0,0},
							{6,0,0,  1,9,5,  0,0,0},
							{0,9,8,  0,0,0,  0,6,0},

							{8,0,0,  0,6,0,  0,0,3},
							{4,0,0,  8,0,3,  0,0,1},
							{7,0,0,  0,2,0,  0,0,6},

							{0,6,0,  0,0,0,  2,8,0},
							{0,0,0,  4,1,9,  0,0,5},
							{0,0,0,  0,8,0,  0,7,9}};*/

		//TIMES
		/*int sudoku[][]={{0,0,4, 0,0,7, 0,0,3},
				 {0,1,5, 0,0,3, 0,0,6},
				 {0,0,0, 9,0,0, 0,0,0},

				 {0,0,1, 4,0,0, 3,0,0},
				 {5,9,0, 0,1,0, 0,7,8},
				 {0,0,8, 0,0,9, 1,0,0},

				 {0,0,0, 0,0,6, 0,0,0},
				 {7,0,0, 3,0,0, 6,9,0},
				 {3,0,0, 5,0,0, 8,0,0}};*/
		/*int sudoku [][] = {{8,0,0, 0,0,0, 0,0,0},
				{0,0,3, 6,0,0, 0,0,0},
				{0,7,0, 0,9,0, 2,0,0},

				{0,5,0, 0,0,7, 0,0,0},
				{0,0,0, 0,4,5, 7,0,0},
				{0,0,0, 1,0,0, 0,3,0},

				{0,0,1, 0,0,0, 0,6,8},
				{0,0,8, 5,0,0, 0,1,0},
				{0,9,0, 0,0,0, 4,0,0}}; */
		/*int sudoku[][] = {{0,0,8, 0,0,4, 0,0,0},
				 {1,0,0, 0,0,0, 0,0,9},
				 {3,0,0, 0,2,0, 0,5,0},
				 
				 {0,0,0, 1,0,0, 0,8,0},
				 {0,0,5, 0,0,0, 4,0,0},
				 {0,7,0, 0,0,9, 0,0,0},
				 
				 {0,6,0, 0,3,0, 0,0,2},
				 {9,0,0, 0,0,0, 0,0,1},
				 {0,0,0, 8,0,0, 7,0,0}};*/
		
		int sudoku[][] = {
				{6,0,0, 0,0,7, 0,0,0},
				{0,0,8, 2,0,0, 0,7,5},
				{0,4,0, 0,3,0, 0,0,6},

				{0,7,1, 0,0,2, 0,5,0},
				{8,0,0, 0,4,0, 0,0,3},
				{0,2,0, 8,0,0, 9,6,0},

				{2,0,0, 0,8,0, 0,3,0},
				{4,3,0, 0,0,9, 8,0,0},
				{0,0,0, 3,0,0, 0,0,9}};
		/*int sudoku[][] =  {
				{0,0,8, 0,0,0, 1,5,0},
				{2,0,0, 0,0,1, 8,0,0},
				{3,0,0, 4,0,6, 7,0,9},
	
				{5,0,0, 0,0,9, 0,0,0},
				{0,9,0, 2,3,4, 0,7,0},
				{0,0,0, 1,0,0, 0,0,8},
	
				{4,0,7, 6,0,5, 0,0,1},
				{0,0,6, 7,0,0, 0,0,4},
				{0,5,3, 0,0,0, 2,0,0}
			};*/


		/*int sudoku[] [] ={{0,0,0,  2,6,0,  7,0,1},
		  {6,8,0,  0,7,0,  0,9,0},
		  {1,9,0,  0,0,4,  5,0,0},

		  {8,2,0,  1,0,0,  0,4,0},
		  {0,0,4,  6,0,2,  9,0,0},
		  {0,5,0,  0,0,3,  0,2,8},

		  {0,0,9,  3,0,0,  0,7,4},
		  {0,4,0,  0,5,0,  0,3,6},
		  {7,0,3,  0,1,8,  0,0,0}};*/

		//Very Difficult
		/*int sudoku [][]= {{0,0,0,  6,0,0,  4,0,0},
				{7,0,0,  0,0,3,  6,0,0},
				{0,0,0,  0,9,1,  0,8,0},

				{0,0,0,  0,0,0,  0,0,0},
				{0,5,0,  1,8,0,  0,0,3},
				{0,0,0,  3,0,6,  0,4,5},

				{0,4,0,  2,0,0,  0,6,0},
				{9,0,3,  0,0,0,  0,0,0},
				{0,2,0,  0,0,0,  1,0,0}};*/

		/*int sudoku [][]={{0,2,0,  6,0,8,  0,0,0},
				{5,8,0,  0,0,9,  7,0,0},
				{0,0,0,  0,4,0,  0,0,0},

				{3,7,0,  0,0,0,  5,0,0},
				{6,0,0,  0,0,0,  0,0,4},
				{0,0,8,  0,0,0,  0,1,3},

				{0,0,0,  0,2,0,  0,0,0},
				{0,0,9,  8,0,0,  0,3,6},
				{0,0,0,  3,0,6,  0,9,0}};*/
		/*int sudoku[][] = {{0,2,0, 0,0,0, 0,0,0},
				{0,0,0, 6,0,0, 0,0,3},
				{0,7,4, 0,8,0, 0,0,0},

				{0,0,0, 0,0,3, 0,0,2},
				{0,8,0, 0,4,0, 0,1,0},
				{6,0,0, 5,0,0, 0,0,0},

				{0,0,0, 0,1,0, 7,8,0},
				{5,0,0, 0,0,9, 0,0,0},
				{0,0,0, 0,0,0, 0,4,0}};*/
		print(sudoku);
		new Sudoku().solve(sudoku);
	}


	private boolean isOnlyQualified(int digit, int row, int col, int sudoku[][]){
		return (isQualified(digit, row, col, sudoku) && 
				isCompeteQualified(digit, row, col, sudoku));
	}

	private boolean isQualified(int digit, int row, int col, int sudoku[][]){
		return (isQualifiedByRow(digit, row, col, sudoku)
				&& isQualifiedByColumn(digit, row, col, sudoku)
				&& isQualifiedByBlock(digit, row, col, sudoku));
	}

	private boolean isCompeteQualified(int digit, int row, int col, int sudoku[][]){
		return (isRowCompeteQualified(digit, row, col, sudoku) 
				|| isColumnCompeteQualified(digit, row, col, sudoku)
				|| isBlockCompeteQualified(digit, row, col, sudoku));
	}

	private boolean isQualifiedByRow(int n, int row, int col, int sudoku[][]){
		boolean retVal = true;
		if(sudoku[row][col] == UNSET){
			for(int index = 0; index < SIZE; index++){
				if(sudoku[row][index] == n){
					retVal = false;
					break;
				}
			}
		}
		return retVal;
	}

	private boolean isQualifiedByColumn(int n, int row, int col, int sudoku[][]){
		boolean retVal = true;
		if(sudoku[row][col] == UNSET){
			for(int index = 0; index < SIZE; index++){
				if(sudoku[index][col] == n){
					retVal = false;
					break;
				}
			}
		}
		return retVal;
	}

	private boolean isQualifiedByBlock(int n, int row, int col, int sudoku[][]){
		boolean retVal = true;
		if(sudoku[row][col] == UNSET){
			for(int rowIndex = (row - (row % 3)); rowIndex < (row + (3 -(row % 3))); rowIndex++){
				for(int colIndex = (col - (col % 3)); colIndex < (col + (3 -(col % 3))); colIndex++){
					if(sudoku[rowIndex][colIndex] == n){
						retVal = false;
						break;
					}
				}
			}
		}
		return retVal;
	}

	private boolean isRowCompeteQualified(int digit, int row, int col, int sudoku[][]){

		boolean qualified = true;

		//Check entire row of this cell of any non filled is competing for this 
		for(int tempCol = 0; tempCol < SIZE; tempCol++){
			if(tempCol != col){
				if(sudoku[row][tempCol] == UNSET){
					if(isQualified(digit, row, tempCol, sudoku)){
						qualified = false;
						break;
					}
				}
			}
		}

		return qualified;
	}

	private boolean isColumnCompeteQualified(int digit, int row, int col, int sudoku[][]){

		boolean qualified = true;

		//Check entire column of this cell if any non filled is competing for this 
		for(int tempRow = 0; tempRow < SIZE; tempRow++){
			if(tempRow != row){
				if(sudoku[tempRow][col] == UNSET){
					if(isQualified(digit, tempRow, col, sudoku)){
						qualified = false;
						break;
					}
				}
			}
		}

		return qualified;
	}

	
	private boolean isBlockCompeteQualified(int digit, int row, int col, int sudoku[][]){

		boolean qualified = true;

		//Check entire row of this cell if any non filled is competing for this 
		for(int rowIndex = (row - (row % 3)); rowIndex < (row + (3 -(row % 3))); rowIndex++){
			for(int colIndex = (col - (col % 3)); colIndex < (col + (3 -(col % 3))); colIndex++){
				if(!(rowIndex == row && colIndex == col)){
					if(sudoku[rowIndex][colIndex] == UNSET){
						if(isQualified(digit, rowIndex, colIndex, sudoku)){
							qualified = false;
							break;
						}
					}
				}
			} 
		}
		return qualified;
	}

	public void solve(int sudoku[][]){
		boolean finalSolution = false;
		boolean solved = true;
		while(!finalSolution){
			finalSolution = true;
			solved = true;
			for(int row = 0; row < SIZE; row++){
				for(int col = 0; col < SIZE; col++){
					for(int digit = 1; digit <= SIZE; digit++){
						if(sudoku[row][col] == UNSET && isOnlyQualified(digit, row, col, sudoku)){
							sudoku[row][col] = digit;
							//print(sudoku);
							finalSolution = false;
							break;
						}
						if(sudoku[row][col] == UNSET){
							solved = false;
						}
					}
				}
			}
		}
		print(sudoku);
		if(!solved){
			/** 
			 * There are ties for positions so try out all possibilities 
			 */
			solve(0, 0, sudoku);
			print(sudoku);
		}
	}
	
	private boolean solve(int row, int col, int sudoku[][]){
		boolean retVal = false;
		while(sudoku[row][col] != UNSET){
			col++;
			if(col > 8){
				row++;
				col = 0;
			}
			if(row > 8){
				return true;
			}
		}
		
		for(int digit = 1; digit <= 9; digit++){
			if(isQualified(digit, row, col, sudoku)){
				sudoku[row][col] = digit;
				if(col < 8){
					retVal = solve(row, col + 1, sudoku);
				}else if(row < 8){
					retVal = solve(row + 1, 0, sudoku);
				}else{
					return true;
				}
				
				if(retVal){
					return true;
				}else{
					sudoku[row][col] = UNSET;
				}
			}
		}

		if(sudoku[row][col] == UNSET){
			return false;
		}
		return true;
	}

	public static void print(int sudoku[][]){

		for(int i = 0; i < SIZE; i++){
			if(i == 0){
				System.out.println("+--------+--------+--------+");
			}
			for(int j = 0; j < SIZE; j++){

				if(j == 0){
					System.out.print("| ");
				}
				System.out.print(sudoku[i][j] + ",");
				if(j % 3 == 2 || j == 8){
					System.out.print(" | ");
				}
			}
			System.out.println();
			if(i % 3 == 2){
				System.out.println("+--------+--------+--------+");
			}
		}
	}
}
