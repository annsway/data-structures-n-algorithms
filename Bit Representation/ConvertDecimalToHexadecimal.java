/*
Generate the hexadecimal representation for a given non-negative integer number as a string. The hex representation should start with "0x".

There should not be extra zeros on the left side.

Examples

0's hex representation is "0x0"
255's hex representation is "0xFF"
*/
public class Solution {
  public String hex(int number) {
        // Write your solution here
        String prefix = "0x";
        if (number == 0) {
            return prefix + "0";
        }
        StringBuilder sb = new StringBuilder();
        while (number != 0) {
            int remainder = number % 16;
            if (remainder >= 10) {
                sb.append((char)(remainder - 10 + 'A'));
            } else {
                sb.append(remainder);
            }
            number >>>= 4; // 相当于number /= 16; e.g. 二进制的前四位相当于 8 + 4 + 2 + 1 = 15
        }
        return prefix + sb.reverse().toString(); // O(n)
    }

}
