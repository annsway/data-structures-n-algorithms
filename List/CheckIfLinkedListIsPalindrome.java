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
  public boolean isPalindrome(ListNode head) {
    // Write your solution here
    if(head == null || head.next == null){
      return true; 
    }
    ListNode middle = findMiddle(head);
    ListNode right = reverseLinkedList(middle.next); 

    while(right != null){ // the length of right must be shorter than left
      if(head.value != right.value){
        return false; 
      }
      head = head.next; 
      right = right.next; 
    }
    return true; 
  }

  public ListNode reverseLinkedList(ListNode head){
    ListNode curr = head; 
    ListNode prev = null; 
    while(curr != null){
      ListNode next = curr.next; 
      curr.next = prev; 
      prev = curr; 
      curr = next; 
    }
    return prev; 
  }
  
  public ListNode findMiddle(ListNode head){
    ListNode slow = head; 
    ListNode fast = head; 
    while(fast.next != null && fast.next.next != null){
      slow = slow.next; 
      fast = fast.next.next; 
    }
    return slow; 
  }
}
