public class Solution {
  public ListNode findMiddleNode(ListNode head) {
    // Write your solution here
    if(head == null || head.next == null){
      return head;
    }
    ListNode fast = head; 
    ListNode slow = head; 
    // fast.next != null: for odd length 
    // fast.next.next != null: for even length, otherwise, NPE 
    while(fast.next != null && fast.next.next != null){
      slow = slow.next;
      fast = fast.next.next; 
    }
    return slow; 
  }
}
