import java.util.Arrays;

public class 2dArrayExample {
    public static int[][] sumOfMatrix(int[][] matrix1, int[][] matrix2){
        int[][] res = matrix1;
        for(int i=0; i<matrix1.length; i++){
            for(int j=0; j<matrix1[i].length; j++){
                res[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{4, 8}, {3, 7}};
        int[][] matrix2 = {{1, 0}, {5, 2}};
        System.out.println("The sum of the two matrices is " + Arrays.deepToString(sumOfMatrix(matrix1, matrix2)));
    }
}
