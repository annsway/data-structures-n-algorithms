import java.util.ArrayList;
import java.util.List;

public class SolDFS {
    public List<String> permutations(String input) {
        // Write your solution here
        List<String> res = new ArrayList<>();
        char[] data = input.toCharArray();
        helper(data, 0, res);
        return res;
    }
    private void helper(char[] input, int index, List<String> res){
        if (index == input.length) {
            res.add(new String(input));
            return;
        }
        // [0, index): 已排过序的
        // [index, input.length - 1]: 还未排序的
        for (int i = index; i < input.length; i++) {
            swap(input, i, index); // 每个元素都到index位置上去转一转
            helper(input, index + 1, res);
            swap(input, i, index); // 将元素挪回原来的位置
        }
    }
    private void swap(char[] array, int i, int j){
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        SolDFS sol = new SolDFS();
        System.out.println(sol.permutations("abc"));
    }
}


