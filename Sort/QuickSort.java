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
        // Q: 为什么base case 是left >= right？
        // A: 例如只剩{1, 2}可排，此时 index i = 1
        // 1. 左边: 只剩一个元素{1}, quickSort(array, left, i-1)
        // left = 0, right = i - 1 = 0
        // 2. 右边: 出界，quickSort(array, i+1, right)
        // left = i + 1 = 2 > right = 1 

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
