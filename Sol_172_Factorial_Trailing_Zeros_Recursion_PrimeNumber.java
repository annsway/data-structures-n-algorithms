// https://leetcode.com/problems/factorial-trailing-zeroes/discuss/52371/My-one-line-solutions-in-3-languages

class Solution {

    // Because all trailing 0 is from factors 5 * 2.
    // But sometimes one number may have several 5 factors, for example, 25 have two 5 factors, 125 have three 5 factors.
    // In the n! operation, factors 2 is always ample. So we just count how many 5 factors in all number from 1 to n.

    public static int trailingZeroes(int n) {

        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);


    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(1808548329));
    }
}