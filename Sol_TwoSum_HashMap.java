// Ref: https://leetcode.com/problems/two-sum/

import java.util.HashMap; // import the HashMap class

class TwoSum_HashMap {

    public static int[] twoSum(int[] nums, int target) {

        int remainder;
        int[] solution = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){

            remainder = target - nums[i];

            if (map.get(remainder)!=null){
                solution[0] = map.get(remainder);
                solution[1] = i;

            }

            map.put(nums[i], i);

        }

        return solution;

    }

    public static void main (String[] args){

        int[] input = {2, 7, 11, 15};

        twoSum(input, 9);

    }

}