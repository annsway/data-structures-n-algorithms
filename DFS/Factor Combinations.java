/*
Given an integer number, return all possible combinations of the factors that can multiply to the target number.

Example

Give A = 24

since 24 = 2 x 2 x 2 x 3

              = 2 x 2 x 6

              = 2 x 3 x 4

              = 2 x 12

              = 3 x 8

              = 4 x 6

your solution should return

{ { 2, 2, 2, 3 }, { 2, 2, 6 }, { 2, 3, 4 }, { 2, 12 }, { 3, 8 }, { 4, 6 } }

note: duplicate combination is not allowed.
*/

public List<List<Integer>> combinations(int target) {
    // Write your solution here
    List<List<Integer>> res = new ArrayList<>();
    if (target <= 1) {
        return res;
    }
    List<Integer> cur = new ArrayList<>();
    helper(target, 2, cur, res);
    return res;
}
private void helper(int target, int factor, List<Integer> cur, List<List<Integer>> res) {
    if (target == 1) {
        if (cur.size() > 1) { // exclude target itself
            res.add(new ArrayList<>(cur));
        }
        return;
    }
    for (int curFactor = factor; curFactor <= target; curFactor++) { // 必须加等号，否则无法触及base case
        if (target % curFactor == 0) {
            cur.add(curFactor);
            helper(target / curFactor, curFactor, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
/*

target = 8
              cur = {}
         / |  |  |  |  |  \
        2  3  4  5  6  7   8
       /   x  |  x  x  x    \
      2       2             (x)
     /
    2

*/


