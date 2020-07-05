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
  public ListNode partition(ListNode head, int target) {
    // Write your solution here
    if(head == null || head.next == null){
      return head; 
    }
    ListNode small = new ListNode(0);
    ListNode large = new ListNode(0);
    ListNode curSmall = small;
    ListNode curLarge = large; 
    while(head != null){
      if(head.value < target){
        curSmall.next = head; 
        curSmall = curSmall.next; 
      } else {
        curLarge.next = head; 
        curLarge = curLarge.next; 
      }
      head = head.next; 
    }
    curSmall.next = large.next; 
    curLarge.next = null; 
    return small.next; 

  }
}
