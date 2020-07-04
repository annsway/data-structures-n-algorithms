public class Solution {
  public ListNode findMiddleNode(ListNode head) {
    // Write your solution here
    ListNode fast = head; 
    ListNode slow = head; 
    while(fast.next != null){
      slow = slow.next;
      fast = fast.next.next; 
    }
    return slow; 
  }
}
