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
public ListNode insert(ListNode head, int value) {
    // Write your solution here
    ListNode insert = new ListNode(value);
    
    //    {[], 1}   || {[3, 3, 5], 1}
    if(head == null || head.value >= value){
      insert.next = head; 
      head = insert; 
      return head; 
    } 

    ListNode curr = head; 
    
    while(curr.next != null){
      if(curr.next.value >= value){
        ListNode temp = curr.next;
        curr.next = insert; 
        insert.next = temp; 
        return head; 
      } 
      curr = curr.next; 
    }
    curr.next = insert; 
    return head; 
  }
}
