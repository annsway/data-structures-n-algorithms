/**
Examples
{0} is sorted to {0}
{1, 0} is sorted to {0, 1}
{1, 0, 1, -1, 0} is sorted to {-1, 0, 0, 1, 1}
**/

import java.util.Arrays;

public class RainbowSort {
    public static int[] rainbowSort(int[] array) {
        // Write your solution here
        if(array == null || array.length <= 1){
            return array;
        }
        int i = 0, j = 0, k = array.length - 1;
        while(j <= k){
            if(array[j] == -1){
                swap(array, i, j);
                j++;
                i++;
            } else if(array[j] == 0){
                j++;
            } else {
                swap(array, j, k);
                k--;
            }
        }
        return array;
    }
    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,-1};
        System.out.println(Arrays.toString(rainbowSort(arr)));
    }
}
