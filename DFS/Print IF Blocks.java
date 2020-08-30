import java.util.ArrayList;
import java.util.List;

public class Solution{
    public void allBlocks(int n) {
        char[] cur = new char[n*2];
        List<String> res = new ArrayList<>();
        helper(cur, n, n, 0, res);
        for (int i = 0; i < res.size(); i++) {
             printBlocks(res.get(i));
            System.out.println("\n");
        }
    }
    private void helper(char[] cur, int leftRem, int rightRem, int level, List<String> res) {
        if (leftRem == 0 && rightRem == 0) {
            res.add(new String(cur));
            return;
        }
        if (leftRem > 0) {
            cur[level] = '{';
            helper(cur, leftRem - 1, rightRem, level + 1, res);
        }
        if (rightRem > leftRem) {
            cur[level] = '}';
            helper(cur, leftRem, rightRem - 1, level + 1, res);
        }
    }
    private void printBlocks(String input) {
        int countIndent = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '{') {
                for (int j = 0; j < countIndent; j++) {
                    System.out.print("  ");
                }
                System.out.println("if {");
                countIndent += 2;
            } else {
                countIndent -= 2;
                for (int j = 0; j < countIndent; j++) {
                    System.out.print("  ");
                }
                System.out.println("}");
            }
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.allBlocks(2);
    }
}

