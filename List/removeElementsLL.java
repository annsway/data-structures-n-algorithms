/**
Remove all elements from a linked list of integers that have value val.
Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
**/

public class Solution {
  public ListNode removeElements(ListNode head, int val) {
    // Write your solution here
    if(head == null){
      return head; 
    }
    ListNode dummy = new ListNode(0);
    ListNode prev = dummy;
    dummy.next = head;  

    while(head != null){
      if(head.value == val){
        prev.next = head.next; 
      } else {
        prev = head; 
      }
      head = head.next; 
    }
    return dummy.next; 
  }
}
