/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 
 Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null

Examples

L = null, is reordered to null
L = 1 -> null, is reordered to 1 -> null
L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null
 
 */
public class Solution {

   public ListNode reorder(ListNode head) {
        // Write your solution here
        if(head == null || head.next == null){
          return head; 
        }
        ListNode middle = findMiddle(head);
        ListNode one = head;
        ListNode two = reverseLinkedList(middle.next);
        middle.next = null;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy; // 此时dummy和curr指向heap上同一个node(0)

        while(one != null && two != null){
            curr.next = one; // heap上的node(0).next 指向下一个元素，dummy和curr不变
            one = one.next; 
            curr.next.next = two; // heap上的node(0).next.next 指向下下个元素，dummy和curr不变
            two = two.next;
            curr = curr.next.next; // dummy不变（只有node(0).next...不停挂上去），curr变
        }

        if(one != null){
            curr.next = one;
        } else {
            curr.next = two;
        }

        return dummy.next;
    }



    public ListNode reverseLinkedList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseLinkedList(head.next); // node3
        ListNode node2 = head.next;
        node2.next = head;
        head.next = null;
        return newHead;
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
