/*
Determine if a given integer is power of 2.

Examples

16 is power of 2 (2 ^ 4)
3 is not
0 is not
-1 is not
*/
public class Solution {
  public boolean isPowerOfTwo(int number) {
    // 只有是2的幂的情况下，(number & (number - 1) 才是0
    // 否则一定会有至少一位与运算后是1
    return number > 0 && (number & (number - 1)) == 0;
  }
}