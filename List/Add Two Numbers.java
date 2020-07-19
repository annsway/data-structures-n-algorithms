/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 */

public class Solution {
  public ListNode addTwoNumbers(ListNode one, ListNode two) {
    // Write your solution here
    int add = 0; 
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy; 
    while(one != null || two != null || add != 0){
      if(one != null){
        add += one.value; 
        one = one.next; 
      }
      if(two != null){
        add += two.value; 
        two = two.next; 
      }
      curr.next = new ListNode(add % 10); // 记录个位数
      add = add / 10; // 保留十位数
      curr = curr.next; 
    }
    return dummy.next; 
  }
}
