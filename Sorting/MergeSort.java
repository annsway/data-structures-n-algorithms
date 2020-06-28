import java.util.Arrays;

public class Solution {
    public static int[] mergeSort(int[] array) {
        // Write your solution here
        if(array == null || array.length <= 1){
            return array;
        }
        int left = 0;
        int right = array.length - 1;
        return sort(array, left, right);
    }

    // recursion
    public static int[] sort(int[] array, int left, int right){
        // base case
        if(left == right){
            return new int[]{array[left]};
        }
        // sub-problem
        int mid = left + (right - left)/2;
        int[] leftArray = sort(array, left, mid);
        int[] rightArray = sort(array, mid+1, right);

        return merge(leftArray, rightArray);
    }

    public static int[] merge(int[] array1, int[] array2){
        int[] res = new int[array1.length + array2.length];
        int i = 0, j = 0, pos = 0;
        // 谁小移谁
        while(i < array1.length && j < array2.length){
            if(array1[i] < array2[j]){
                res[pos] = array1[i];
                i++;
            } else {
                res[pos] = array2[j];
                j++;
            }
            pos++;
        }
        while(i < array1.length){
            res[pos] = array1[i];
            i++;
            pos++;
        }
        while(j < array2.length){
            res[pos] = array2[j];
            j++;
            pos++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,5,2};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }
}
