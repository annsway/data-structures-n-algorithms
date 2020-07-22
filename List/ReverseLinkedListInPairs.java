/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }

Reverse pairs of elements in a singly-linked list.

Examples

L = null, after reverse is null
L = 1 -> null, after reverse is 1 -> null
L = 1 -> 2 -> null, after reverse is 2 -> 1 -> null
L = 1 -> 2 -> 3 -> null, after reverse is 2 -> 1 -> 3 -> null

 */
public class Solution {
    public ListNode reverseInPairs(ListNode first) {
        if(first == null || first.next == null){
            return first;
        }

        ListNode second = first.next;
        ListNode third = second.next;

        // 记录后面的头
        ListNode reversed_third = reverseInPairs(third); 

        // 前面的两个nodes
        second.next = first; // reverse
        first.next = reversed_third; // 将first与second断开，否则有环

        return second; // second变为头
    }
}
