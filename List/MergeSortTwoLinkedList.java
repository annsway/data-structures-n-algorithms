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
  public ListNode mergeSort(ListNode head) {
    // Write your solution here
    if(head == null || head.next == null){
      return head; 
    }
    ListNode midNode = findMiddle(head);
    ListNode midNext = midNode.next;
    midNode.next = null;

    ListNode leftNode = mergeSort(head);
    ListNode rightNode = mergeSort(midNext);

    return merge(leftNode, rightNode);
  }
  private ListNode merge(ListNode one, ListNode two){
    if(one == null && two == null){
      return one; 
    }
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy; 

    while(one != null && two != null){
      if(one.value <= two.value){
        curr.next = one; 
        one = one.next; 
      } else {
        curr.next = two; 
        two = two.next; 
      }
      curr = curr.next; 
    }
    if(one != null){
      curr.next = one; 
    }
    if(two != null){
      curr.next = two; 
    }
    return dummy.next; 
  }
  private ListNode findMiddle(ListNode head){
    if(head == null || head.next == null){
      return head; 
    }
    ListNode fast = head; 
    ListNode slow = head; 

    while(fast.next != null && fast.next.next != null){
      slow = slow.next; 
      fast = fast.next.next; 
    }
    return slow; 
  }
}
