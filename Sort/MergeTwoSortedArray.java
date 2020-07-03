import java.util.Arrays;

public class Solution {
    public static int[] merge(int[] one, int[] two) {
        // Write your solution here
        int i = 0, j = 0, pos = 0;
        int[] res = new int[one.length + two.length];
        // 谁小移谁
        while(i < one.length && j < two.length){
            if(one[i] < two[j]){
                res[pos] = one[i];
                i++;
            } else {
                res[pos] = two[j];
                j++;
            }
            pos++;
        }
        // check if the index has not reached to the end of the array 
        while(i < one.length){
            res[pos] = one[i];
            i++;
            pos++;
        }
        while(j < two.length){
            res[pos] = two[j];
            j++;
            pos++;
        }
        return res;
    }

    public static void main(String[] args){
        int[] arr1 = {3,7};
        int[] arr2 = {1,6,8,9};
        System.out.println(Arrays.toString(merge(arr1, arr2)));
    }
}
