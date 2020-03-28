import java.util.HashMap;

// Ref: https://leetcode.com/problems/single-number/

class Solution {
    public int singleNumber(int[] nums) {

        HashMap<Integer, Boolean> hashMap = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(hashMap.containsKey(nums[i])){
                hashMap.replace(nums[i], false); // if appeared twice, set the value as false
            } else{
                hashMap.put(nums[i], true); // if appeared first time, set the value as true
            }
        }

        for(Integer key:hashMap.keySet()){
            if(hashMap.get(key).equals(true)){
                return key;
            }
        }

        return 0;
    }
}