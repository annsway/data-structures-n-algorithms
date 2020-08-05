public class Solution {
  private Deque<Integer> left;
  private Deque<Integer> right;
  private Deque<Integer> buffer;

  public Solution() {
    // Write your solution here.
    left = new ArrayDeque<>();
    right = new ArrayDeque<>();
    buffer = new ArrayDeque<>();
  }
  
  public void offerFirst(int element) {
    left.offerFirst(element);
  }
  
  public void offerLast(int element) {
    right.offerFirst(element);
  }

  /************************************/
  private void move(Deque<Integer> src, Deque<Integer> dest) {
    if (!dest.isEmpty()) { // to ensure the existing elements in the dest stack get pulled first 
      return; 
    }
    int half = src.size() / 2; // to increase efficency; early return 
    for (int i = 0; i < half; i++) {
      buffer.offerFirst(src.pollFirst()); // move the first half to the buffer
      i++;
    }
    while (!src.isEmpty()) {
      dest.offerFirst(src.pollFirst()); // move the buttom half to the dest stack  
    }
    while (!buffer.isEmpty()) {
      src.offerFirst(buffer.pollFirst()); // move the first half back to the src stack 
    }
  }
  
  public Integer pollFirst() {
    move(right, left); // move(src, dest)
    return left.isEmpty() ? null : left.pollFirst();
  }

  public Integer pollLast() {
    move(left, right); // move(src, dest)
    return right.isEmpty() ? null : right.pollFirst();
  }
  
  public Integer peekFirst() {
    move(right, left); // move(src, dest)
    return left.isEmpty() ? null : left.peekFirst();
  }
  
  public Integer peekLast() {
    move(left, right); // move(src, dest)
    return right.isEmpty() ? null : right.peekFirst();
  }
  
  public int size() {
    return right.size() + left.size();
  }
  
  public boolean isEmpty() {
    return right.isEmpty() && left.isEmpty();
  }
}