
//Ref: https://leetcode.com/problems/contains-duplicate/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        if(nums.length<=1){
            return false; 
        }
        
        Set<Integer> hash_set = new HashSet<Integer>();
        
        for(int i=0; i<nums.length; i++){
            if(hash_set.contains(nums[i])){
                return true; 
            }
            hash_set.add(nums[i]);
        }
  
        return false; 
    }
}