import java.util.Arrays;

public class Solution {
    public int[] selectionSort(int[] array) {
        // Write your solution here
        if(array == null || array.length <= 1){
            return array;
        }

        // [0, i): sorted array
        for(int i=0; i<array.length - 1; i++){
            int minIndex = i; // [i, array.length): unsorted array
            // inner for loop: to find the index of the minimum element of the unsorted array
            for(int j=i+1; j<array.length; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            // swap the first element of the unsorted array and
            // the minimum element fo the unsorted array
            swap(array, minIndex, i);
            // move forward by one element after moving the minimum to the left
        }
        return array;
    }

    public int[] swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] array = {2, 4, 1, 3};
        solution.selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

}
