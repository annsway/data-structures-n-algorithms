import java.util.Arrays;

public class InsertToArray {

    /**Insert an element to the given position of a given array, and return the new array**/
    public static int[] insertToArray(int[] arr, int pos, int element){
        int[] res = new int[arr.length + 1];
        for(int i=0; i<pos; i++){
            res[i] = arr[i];
        }
        res[pos] = element;
        for(int j=pos+1; j<res.length; j++){
            res[j] = arr[j-1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7};
        System.out.println(Arrays.toString(insertToArray(arr, 2, 4)));

    }
}
