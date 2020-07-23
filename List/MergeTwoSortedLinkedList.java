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
 public ListNode merge(ListNode one, ListNode two) {
        if(one == null && two == null){
            return one;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // 谁小移谁
        while(one != null && two != null){
            if(one.value <= two.value){
                curr.next = one; // 注意不是curr = one; 
                one = one.next;
            } else {
                curr.next = two;
                two = two.next;
            }
            curr = curr.next; // move forward 

        }
        // Deal with the remaining elements in 'one' or 'two'
        // No need to use while loop since by pointing curr.next to one, 
        // the rest of the elements are linked behind one. 
        if(one != null){
            curr.next = one;
        }
        if(two != null){
            curr.next = two;
        }
        return dummy.next;
    }
}
