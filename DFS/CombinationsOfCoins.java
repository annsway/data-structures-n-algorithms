/**
Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents), get all the possible ways to pay a target number of cents.

Arguments

coins - an array of positive integers representing the different denominations of coins, there are no duplicate numbers and the numbers are sorted by descending order, eg. {25, 10, 5, 2, 1}
target - a non-negative integer representing the target number of cents, eg. 99
Assumptions

coins is not null and is not empty, all the numbers in coins are positive
target >= 0
You have infinite number of coins for each of the denominations, you can pick any number of the coins.
Return

a list of ways of combinations of coins to sum up to be target.
each way of combinations is represented by list of integer, the number at each index means the number of coins used for the denomination at corresponding index.
Examples

coins = {2, 1}, target = 4, the return should be

[

  [0, 4],   (4 cents can be conducted by 0 * 2 cents + 4 * 1 cents)

  [1, 2],   (4 cents can be conducted by 1 * 2 cents + 2 * 1 cents)

  [2, 0]    (4 cents can be conducted by 2 * 2 cents + 0 * 1 cents)

]
**/

import java.util.ArrayList;
import java.util.List;

public class SolDFS {

    public List<List<Integer>> combinations(int target, int[] coins) {
        // Write your solution here
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(target, coins, 0, cur, res);
        return res;
    }

    private void helper(int target, int[] coins, int level, List<Integer> cur, List<List<Integer>> res) {
        if (level == coins.length - 1) {
            if (target % coins[coins.length - 1] == 0) {
                cur.add(target / coins[coins.length - 1]);
                res.add(new ArrayList<>(cur)); // 深度copy，直接加了一个元素进入res list
                // res.add(cur); // WRONG!!! 这里是把curr的reference给copy到了res list，当res进行remove等操作时，reference会失效
                // Note: 这里涉及mutability 的概念，list是mutable的。result.add的时候，add的是list的reference
                // 如果res.add(cur), 那么cur改变的时候list也会改变
                // 如果add的是new ArrayList<>，也就是一个新的元素，那cur改变的时候就不会再变
                cur.remove(cur.size() - 1);
            }
            return;
        }
        int max = target / coins[level];
        for (int i = 0; i <= max; i++) {
            cur.add(i);
            helper(target - i * coins[level], coins, level + 1, cur, res);
            cur.remove(cur.size() - 1); // 如果没有这个remove，那么从底层上来的元素会出现在之后的结果组里面，e.g. [[0, 4], [0, 1, 2], [0, 1, 2, 0]]
        }
    }


    public static void main(String[] args) {
        SolDFS sol = new SolDFS();
        System.out.println(sol.combinations(4, new int[]{2, 1})); // expected: [[0, 4], [1, 2], [2, 0]]
    }
}
