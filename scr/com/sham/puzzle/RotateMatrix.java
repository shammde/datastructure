package com.sham.puzzle;

public class RotateMatrix {

	
	 // Function to print the matrix
	void displayMatrix(int mat[][])
	{
		int N = mat.length;
	    for (int i = 0; i < N; i++)
	    {
	        for (int j = 0; j < N; j++)
	            System.out.printf("%2d ", mat[i][j]);
	 
	        System.out.println();
	    }
	    System.out.println();
	}
	
    public void rotateMatrixInplace(int[][] matrix) {
		int length = matrix.length-1;
		for (int i = 0; i <= (length)/2; i++) {
			for (int j = i; j < length-i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[length-j][i];
				matrix[length-j][i] = matrix[length-i][length-j];
				matrix[length-i][length-j] = matrix[j][length-i];
				matrix[j][length-i] = temp;
			}
		}
	}
	
	public static void main(String args[])
	{
	    // Test Case 1
	    int mat[][] =
	    {
	        {1, 2, 3, 4},
	        {5, 6, 7, 8},
	        {9, 10, 11, 12},
	        {13, 14, 15, 16},
	    };
	 
	 
	    // Tese Case 2
	    /* int mat[N][N] = {
	                        {1, 2, 3},
	                        {4, 5, 6},
	                        {7, 8, 9}
	                    };
	     */
	 
	    // Tese Case 3
	    /*int mat[N][N] = {
	                    {1, 2},
	                    {4, 5}
	                };*/
	 
	    //displayMatrix(mat);
	 
	    RotateMatrix rot = new RotateMatrix();
	    rot.displayMatrix(mat);
	    rot.rotateMatrixInplace(mat);
	    //rot.rotateMatrix(mat);
	    //rot.rotateMatrixBy90Degree(mat, mat.length);
	    // Print rotated matrix
	    rot.displayMatrix(mat);
	    int array[] = {1,2,3,4,5,16,7,8,9}, max=0;
	    for(int i = 0; i < array.length - 2; i++)
	    	System.out.println((max = (array[i] > array[i + 1]) ? array[i] : array[i + 1]) > array[i + 2] ? max : array[i + 2]);
	}
}
