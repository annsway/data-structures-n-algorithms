/*
Input: a string of universities. Each university is represented as a single capital letter.
Output: all possible schedules. A lowercase letter “x” means we take a break.

Example

Input: String = “ABC”

Output:

ABC

ABxC

AxBC

AxBxC
*/
public List<String> takeBreak(String input) {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    dfs(input, 0, result, sb);
    return result;
}
private void dfs(String input, int index, List<String> result, StringBuilder sb) {
    if (index == input.length()) {
        result.add(sb.toString());
    } else {
        sb.append(input.charAt(index));
        if (index < input.length() - 1) {
            sb.append('x');
            dfs(input, index + 1, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        dfs(input, index + 1, result, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.takeBreak("ABC"));
}