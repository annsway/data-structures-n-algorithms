/**
Given an array that is initially stored in one stack, sort it with one additional stacks (total 2 stacks).

After sorting the original stack should contain the sorted integers and from top to bottom the integers are sorted in ascending order.

Assumptions:

The given stack is not null.
There can be duplicated numbers in the give stack.
Requirements:

No additional memory, time complexity = O(n ^ 2).
**/
public class Solution {
  public void sort(LinkedList<Integer> s1) {
    LinkedList<Integer> s2 = new LinkedList<Integer>();
    // Write your solution here.
    if (s1 == null || s1.size() == 1) {
      return; 
    }
    sort(s1, s2);
  }

  // 用Deque这个interface去实现LinkedList这个class
  // Deque<Integer> input = new LinkedList<>();
  private void sort(LinkedList<Integer> input, LinkedList<Integer> buffer){
    while(!input.isEmpty()){
      int currMin = Integer.MAX_VALUE; 
      int countMin = 0; 
      // 1. Find the min of input
      // 2. Move all elements from input to buffer 
      while(!input.isEmpty()){
        int curr = input.pollFirst();
        if (curr < currMin) {
          currMin = curr; 
          countMin = 1;
        } else if (curr == currMin) {
          countMin++;
        }
        buffer.offerFirst(curr);
      }
      // 1. !buffer.isEmpty(): 第一次把currMin 放入buffer
      // 2. buffer.peekFirst() >= currMin: buffer中已有sorted部分(<currMin)，不动
      while (!buffer.isEmpty() && buffer.peekFirst() >= currMin) {
        int temp = buffer.pollFirst();
        if (temp != currMin) {
          input.offerFirst(temp); // put other elements back to input stack 
        }
      }
      // 将currMin放到buffer
      while (countMin != 0) {
        buffer.offerFirst(currMin);
        countMin--;
      }
    }
    // put sorted elements in the buffer back to input stack
    while (!buffer.isEmpty()) {
      input.offerFirst(buffer.pollFirst());
    }
  }
}