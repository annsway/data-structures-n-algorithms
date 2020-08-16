/**
Given a rope with positive integer-length n, how to cut the rope into m integer-length parts with length p[0], p[1], ...,p[m-1], 
in order to get the maximal product of p[0]*p[1]* ... *p[m-1]? m is determined by you and must be greater than 0 (at least one cut must be made). 
Return the max product you can have.

Assumptions

n >= 2
Examples

n = 12, the max product is 3 * 3 * 3 * 3 = 81 
(cut the rope into 4 pieces with length of each is 3).
**/
public class Solution{
    public int maxProduct(int length) {
        int[] M = new int[length + 1]; // 表格
        M[1] = 0;
        // 1st for loop: 从小到大填表，找到current length的切法最大值
        // i: current length; n: total length of the rope
        // i <= 1 没有必要讨论，其物理意义为 current length <= 1 米，而题目要求至少切一刀
        // M[0] = 0 (invalid); M[1] = 0 (invalid)
        for (int i = 2; i <= length; i++) { 
            int curMax = 0;
            // 2nd for loop: 讨论current length里面可能出现的每种切法cases
            // j represents LeftBigSection
            for (int j = 1; j < i; j++) { // j = 0 没有必要讨论，其物理意义为切 0 米
                // Math.max(j, M[j]): 左大段(不切：左大段 = j 米 | 切：M[j] => 历史上左边的最大值)
                // (i - j): 右小段
                curMax = Math.max(curMax, Math.max(j, M[j]) * (i - j)); // M[j]: 从表格中取出第j个value
            }
            M[i] = curMax; // M[i]: 填表格，值会被M[j]用到。current max 历史上的最大值
        }
        return M[length];
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxProduct(3));;
    }
}


