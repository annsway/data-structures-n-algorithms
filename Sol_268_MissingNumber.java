// ref: https://leetcode.com/problems/missing-number/
class Solution {
    public static int missingNumber(int[] nums) {
        int[] counter = new int[nums.length+1];

        for(int i=0; i<nums.length; i++){
            counter[nums[i]]=1;
        }

        for(int j=0; j<counter.length; j++){
            if(counter[j]==0){
                return j;
            }
        }
        return -1;
    }

}