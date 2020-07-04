import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    Deque<Integer> s;
    public Solution() {
        // write your solution here
        s = new LinkedList<>();
    }

    public int pop() {
        if(s.isEmpty()){
            return -1;
        } else {
            return s.pollFirst();
        }
    }

    public void push(int element) {
        s.offerFirst(element);
    }

    public int top() {
        if(s.isEmpty()){
            return -1;
        } else {
            return s.peek();
        }
    }

    public int min() {
        if(s.isEmpty()){
            return -1;
        } else {
            Deque<Integer> s2 = new LinkedList<>(); 
            // cannot change it to s2 = s1, which is shallow copy and if the content of s1 changes, 
            // the content of s2 will change too, as they point to the same object in heap
            // s1 and s2 are just reference (address) of an object of LinkedList type. 
            int min = s.peekFirst();
            int temp;
            while(!s.isEmpty()){
                temp = s.peekFirst();
                if(min > temp){
                    min = temp;
                }
                s2.offerFirst(s.pollFirst());
            }
            while(!s2.isEmpty()){
                s.offerFirst(s2.pollFirst());
            }
            return min;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        /**
         * input:   push(5),top(),min(),pop(),min(),top()
         * expected:      <[    5,    5,    5,   -1, -1]>
         **/
//        solution.push(5);
//
//        solution.top();
//        solution.min();
//        solution.pop();
//        solution.min();
//        solution.top();

        solution.push(5);

        System.out.println("top is " + solution.top());
        System.out.println("min is " + solution.min());
        System.out.println("after pop() " + solution.pop());
        System.out.println("min is " + solution.min());
        System.out.println("top is " + solution.top());
    }
}