/** 

Rearrange the array so that the numbers smaller than array[pivotIndex] 
are on the left side of array[pivotIndex] and numbers larger than 
array[pivotIndex] are on the right side of array[pivotIndex].

**/

class Solution {

    public static void partition(int[] array, int pivotIndex) {
        if(array == null || array.length <= 1){
            return;
        }
        swap(array, pivotIndex, array.length - 1); // move pivot to the rightmost position
        int pivot = array[array.length - 1];
        int i = 0, j = array.length - 2;
        while(i <= j){
            if(array[i] >= pivot){
                swap(array, i, j);
                j--;
                // i++: is wrong b/c you don't know if array[j] is greater than pivot or not.
            } else if(array[i] < pivot){
                i++;
            }
        }
        swap(array, i, array.length - 1);

    }

    public static int[] swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }

    public static void main(String[] args) {
        int[] array = {3,2,1};
        partition(array, 0);
    }
}