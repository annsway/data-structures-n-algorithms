import java.util.Arrays;
import java.util.Random;

public class Solution {
    public int[] quickSort(int[] array) {
        // Write your solution here
        if(array == null || array.length <= 1){
            return array;
        }
        return sort(array, 0, array.length - 1);
    }

    public int[] sort(int[] array, int left, int right){
        if(left >= right){
            return array;
        }
        // pick a pivot
        Random rand = new Random();
        int pivotIndex = left + rand.nextInt(right - left + 1);
        // move pivot to the rightmost of the array
        swap(array, pivotIndex, right);
        int pivot = array[right];

        int i = left, j = right - 1;
        while(i <= j){
            if(array[i] > pivot){
                swap(array, i, j);
                j--;
            } else {
                i++;
            }
        }
        swap(array, i, right);

        sort(array, left, i-1);
        sort(array, i+1, right);
        return array;
    }


    public int[] swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4, 2, -3, 6, 1};
        System.out.println(Arrays.toString(solution.quickSort(arr)));
    }
}
