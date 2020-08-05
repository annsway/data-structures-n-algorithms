import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public static void shuffle(Deque<Integer> stack1, Deque<Integer> stack2) {
        while(!stack1.isEmpty()){
            stack2.push(stack1.poll());
        }
    }

    public static void main(String[] args) {
        Deque<Integer> s1 = new LinkedList<>();
        s1.push(1);
        s1.push(2);
        s1.push(3);

        System.out.println(s1); // print: [1, 2, 3]

        Deque<Integer> s2 = new LinkedList<>();
        shuffle(s1, s2);
        System.out.println(s1); // print: []
        System.out.println(s2); // print: [3, 2, 1]

    }
}