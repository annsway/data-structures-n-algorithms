class Solution {
    
    private Queue<Integer> q1; 
    private Queue<Integer> q2;

    /** Initialize your data structure here. */
    public Solution() {
      q1 = new ArrayDeque<>();
      q2 = new ArrayDeque<>();   
    }

    /** Push element x onto stack. */
    public void push(int x) {
      q1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
      if (q1 == null) {
        return null; 
      }
      Integer prev = q1.poll();
      Integer curr = q1.poll();
      while (curr != null) {
        q2.offer(prev); // 最后一个prev不会进入q2
        prev = curr; 
        curr = q1.poll();
      }
      Queue<Integer> temp = q2; 
      q2 = q1; 
      q1 = temp; 
      return prev; 
    }

    /** Get the top element. */
    public Integer top() {
      // WRONG! q.q1 is NOT null - it's a reference already created in Constructor(). 
      // object q1 已经有了，只是还没有加元素
      // if (q1 == null) {
      //   return null; 
      // } 
      Integer ret = pop();
      if (ret == null) {
        return null; 
      }
      q1.offer(ret);
      return ret; 
    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
       return top() == null;
    }
}