/*
Get all valid ways of putting N Queens on an N * N chessboard so that no two Queens threaten each other.

Assumptions

N > 0
Return

A list of ways of putting the N Queens
Each way is represented by a list of the Queen's y index for x indices of 0 to (N - 1)
Example

N = 4, there are two ways of putting 4 queens:

[1, 3, 0, 2] --> the Queen on the first row is at y index 1, the Queen on the second row is at y index 3, the Queen on the third row is at y index 0 and the Queen on the fourth row is at y index 2.

[2, 0, 3, 1] --> the Queen on the first row is at y index 2, the Queen on the second row is at y index 0, the Queen on the third row is at y index 3 and the Queen on the fourth row is at y index 1.
*/

import java.util.ArrayList;
import java.util.List;

public class Solution{
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(n, cur, res);
        return res;
    }
    private void helper(int n, List<Integer> existingQueens, List<List<Integer>> result) {
        // base case: when for all the rows we know where the queen is positioned
        if (existingQueens.size() == n) {
            result.add(new ArrayList<>(existingQueens));
            return;
        }
        for (int column = 0; column < n; column++) {
            // check if putting a queen at column i at current row is valid
            if (isValid(existingQueens, column)) {
                existingQueens.add(column); // 吃
                helper(n, existingQueens, result); // dfs: 继续check下一排
                existingQueens.remove(existingQueens.size() - 1); // 吐
            }
        }
    }
    private boolean isValid(List<Integer> existingQueens, int candidateColumn) {
        int candidateRow = existingQueens.size();
        // 对已知的所有queens进行遍历，与candidate queen进行比较
        for (int existingRow = 0; existingRow < candidateRow; existingRow++) {
            int existingColumn = existingQueens.get(existingRow); // 从exsitingQueens list里拿出每行对应的queen所在的column
            if (existingColumn == candidateColumn || Math.abs(candidateColumn - existingColumn) == candidateRow - existingRow) {
                //  判断是否在同一列 || 判断是否在对角线上: 斜率 k = y2 - y1 / x2 - x1, k = 1 or k = -1 都可以
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.nqueens(4));
    }
}

