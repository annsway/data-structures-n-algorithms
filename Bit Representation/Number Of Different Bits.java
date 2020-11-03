/*
Determine the number of bits that are different for two given integers.

Examples

5(“0101”) and 8(“1000”) has 3 different bits
*/
public class Solution{
    public int diffBits(int a, int b) {
        // XOR: returns 0 if both are 0 or both are 1, otherwise, returns 1
        a ^= b; 
        int count = 0;
        // count how many 1s in a
        while (a != 0) {
            // &: returns 1 when both are 1, otherwise, returns 0
            count += a & 1; //看a的最后一位是否为1，若是，则count+1； 
            a >>>= 1; // 消掉a的最后一位
        }
        return count;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.diffBits(5, 8));
    }
}