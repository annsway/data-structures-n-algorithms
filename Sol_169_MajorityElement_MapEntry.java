import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int majorityElement(int[] nums) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        Map.Entry<Integer, Integer> majorityEntry = null;

        int count;

        for (int i=0; i<nums.length; i++){
            if(hashMap.isEmpty() || !hashMap.containsKey(nums[i])){
                count = 1;
            } else {
                count = hashMap.get(nums[i])+1;
            }
            hashMap.put(nums[i], count);
        }

        // Put the majority element into a Map.Entry
        // Map.Entry interface in Java provides certain methods to access the entry in the Map.
        // By gaining access to the entry of the Map we can easily manipulate them.
        // Ref: https://www.geeksforgeeks.org/map-entry-interface-java-example/

        // Map.Entry is a key and its value combined into one class.
        // This allows you to iterate over Map.entrySet() instead of having to iterate over Map.keySet(),
        // then getting the value for each key.
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()){
            if(majorityEntry == null || majorityEntry.getValue() < entry.getValue()){
                majorityEntry = entry;
            }

        }

        return majorityEntry.getKey();

    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{10,9,9,9,10}));
    }
}