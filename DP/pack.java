/*
Given the number of swags, what is the minimum number of boxes to pack them up?

Example #1
Input: 4
Output: 1 (just one 2x2 box)

Example #2
Input: 10
Output: 2 (one 3x3 box and one 1x1 box)
*/

// 右小段：不可再分割的部分
public int pack(int n) {
    if (n <= 1) {
        return n;
    }
    int[] M = new int[n + 1]; // M[i] represents the minimum number of boxes needed for i swags
    //base case
    M[0] = 0;
    M[1] = 1;
    for (int i = 2; i <= n; i++) { // i represents the number of swags
        int result = i; // 每一个swag都装一个box
        int right = 1; // right represents the length of the side of the LAST box
        while (right * right <= i) { // right x right represents the size of the last box
            result = Math.min(M[i - right * right] + 1, result);
            right++;
        }
        M[i] = result;
    }
    return M[n];
}