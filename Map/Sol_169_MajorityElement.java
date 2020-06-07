// Ref: https://leetcode.com/problems/majority-element/

class Solution {
    public static int majorityElement(int[] nums) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> countList = new ArrayList<>();
        int max=0;
        int count=0;

        for (int i=0; i<nums.length; i++){

            if(hashMap.isEmpty() || !hashMap.containsKey(nums[i])){
                count = 1;
            } else {
                count = hashMap.get(nums[i])+1;
            }
            hashMap.put(nums[i], count);
            
        }

        for (Integer key: hashMap.keySet()){
            countList.add(hashMap.get(key));
        }


        for (Integer key: hashMap.keySet()){

            if (hashMap.get(key) == Collections.max(countList)){
                max = key;
            }
        }

        System.out.println(hashMap);
        return max;
    }
}