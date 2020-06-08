public class MatrixTrace {
    // trace of square matrix
    public static int matrixTrace(int[][] matrix){
        int trace = 0;

        for(int i=0; i<matrix.length; i++){
            trace += matrix[i][i];
        }
        return trace;

    }
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {5, 7}};
        System.out.println(matrixTrace(arr));

    }
}