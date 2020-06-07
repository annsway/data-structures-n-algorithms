//Ref: https://leetcode.com/problems/first-unique-character-in-a-string/
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        
        for(int i=0; i<s.length(); i++){
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0)+1);
        }
        
        for(int i=0; i<s.length(); i++){
            if(hashMap.get(s.charAt(i))==1){
                return i;
            }
        }
        
        return -1; 
    }
}