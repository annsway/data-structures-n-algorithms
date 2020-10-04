import java.util.ArrayList;
import java.util.List;

public class SolDFS {

    void findSubset(char[] input, int index, StringBuilder solutionPrefix){
        if (index == input.length) {
            System.out.println(solutionPrefix);
            return;
        }
        // line 05
        solutionPrefix.append(input[index]); // 吃
        findSubset(input, index + 1, solutionPrefix); // line 12

        solutionPrefix.deleteCharAt(solutionPrefix.length() - 1); // 吐 line 09
        findSubset(input, index + 1, solutionPrefix);

    }

    // with helper
    public List<String> subSets(String set) {
        // Write your solution here.
        if (set == null) {
            return null;
        }
        List<String> res = new ArrayList<>();
        char[] input = set.toCharArray(); // convert string to char[]
        StringBuilder sb = new StringBuilder();
        helper(input, 0, sb, res);

        return res;
    }

    private void helper(char[] input, int level, StringBuilder solutionPrefix, List<String> res){
        if (level == input.length) {
            res.add(solutionPrefix.toString());
            return; // must have "return" here, otherwise, it will run the next line of code, which will cause index out of bound for input[length]
        }
        solutionPrefix.append(input[level]);
        helper(input, level + 1, solutionPrefix, res);

        solutionPrefix.deleteCharAt(solutionPrefix.length() - 1);
        helper(input, level + 1, solutionPrefix, res);
    }


    public static void main(String[] args) {
        SolDFS sol = new SolDFS();
        char[] input1 = {'a', 'b', 'c'};
        StringBuilder sb = new StringBuilder(); // default length = 16
        sol.findSubset(input1, 0, sb);

        // with helper 
        String input2 = "abc";
        System.out.println(sol.subSets(input2));
    }
}
