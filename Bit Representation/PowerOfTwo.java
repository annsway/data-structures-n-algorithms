/*
Determine if a given integer is power of 2.

Examples

16 is power of 2 (2 ^ 4)
3 is not
0 is not
-1 is not
*/
public class PowerOfTwo {
    public static boolean isPowerOfTwo(int number) {
    /* 0:       0
       1:       1
       2:     1 0 *
       3:     1 1
       4:   1 0 0 *
       5:   1 0 1
       6:   1 1 0
       7:   1 1 1
       8: 1 0 0 0 *
       --------------
       Analysis:
       (1) power of 2: leading 1 and all 0s
       (2) using & with (number - 1) to get 0     
        - 只有是2的幂的情况下，(number & (number - 1) 才是0
        - 否则一定会有至少一位与运算后是1
       --------------
       2:     1 0 *
       1:     0 1
             ------
       &      0 0

       4:   1 0 0 *
       3:   0 1 1
             ------
       &    0 0 0

       8: 1 0 0 0 *
       7: 0 1 1 1
            ------
       &  0 0 0 0

       12: 1 1 0 0
       11: 1 0 1 1
            ------
       &  0 0 0 0
    */
        return number > 0 && (number & (number - 1)) == 0;
    }
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(2));
    }
}
