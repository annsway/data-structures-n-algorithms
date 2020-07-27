// Problem: find the smallest k integer numbers in an unsorted array with size n.

import java.util.Arrays;
import java.util.Random;

public class Solution {
    public int[] quickSelect(int[] array, int k){

        if(array == null){
            return null;
        }
        if(array.length < k){
            return array;
        }

        int[] res = new int[k];
        quickSelect(array, k, 0, array.length - 1);

        for(int i=0; i<k; i++){
            res[i] = array[i];
        }

        Arrays.sort(res); // to return the sorted result 

        return res;
    }

    public void quickSelect(int[] array, int k, int left, int right){

        if(array == null || k == 0){ // base case 
            return;
        }

        Random rand = new Random();
        int pivotIndex = left + rand.nextInt(right - left + 1); // 注需从 left 开始往后

        // ( - , i) < pivot 
        // [i, j]: 未探索区域
        // （j, +): > pivot 

        int i = left, j = right - 1;
        swap(array, pivotIndex, right);

        while(i <= j){
            if(array[i] < array[right]){
                i++;
            } else {
                swap(array, i, j);
                j--;
            }
        }

        swap(array, i, right); 
        // i 现在是pivot的index
        
        int kSorted = i - left + 1; // 项数=[(尾数-首数)/公差]+1

        if( kSorted == k){
            return;
        } else if ( kSorted < k){
            quickSelect(array, k - kSorted, i + 1, right); // 用i, left, right来做边界，而非k, kSorted
        } else { // selected more than k
            quickSelect(array, k, left, i - 1);
        }

    }

    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {5, 1, 0, 2, 3};

        System.out.println(Arrays.toString(solution.quickSelect(arr, 2)));
    }
}



