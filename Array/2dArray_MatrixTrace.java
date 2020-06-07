// trace of square matrix 
public int matrixTrace(int[][] matrix){
	int trace;

	for(int i=0; i<matrix.length; i++){
		trace += matrix[i][i];
	}
	return trace; 

}