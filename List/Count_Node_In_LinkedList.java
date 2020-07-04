/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public int count(ListNode head) {
    // Write your solution here
    int count = 0;
    ListNode curr = head; 
    while(curr != null){
      count++;
      curr = curr.next;
    }
    return count; 
  }
}