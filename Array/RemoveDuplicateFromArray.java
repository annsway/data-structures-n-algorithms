import java.util.Arrays;

public class Solution {
    public static int[] removeDuplicate(int[] array, int duplicate) {
        int count = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == duplicate) {
                count++;
            }
        }
        int[] result = new int[array.length - count + 1];
        if(result.length == 0){
            return null;
        }
        int i = 0;
        int j = 0;
        while (i < array.length) {
            if (array[i] == duplicate) {
                i++;
            } else {
                result[j] = array[i];
                i++;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,3,4,3,2};
        System.out.println(Arrays.toString(removeDuplicate(arr, 3)));

    }

}
