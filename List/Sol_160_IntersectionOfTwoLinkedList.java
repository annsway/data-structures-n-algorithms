/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
To prove A and B will eventually meet, no matter what their lengths are:

Suppose A=a+c; B = b+c;
==> A+B=a+c+b +c
==> B+A=b+c+a +c
**/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null){
            return null;
        }
        
        ListNode a1 = headA;
        ListNode b1 = headB;
        
        while(headA != headB){
            if(headA != null){
                headA = headA.next;
            } else {
                headA = b1;
            }
            
            if(headB != null){
                headB = headB.next;
            } else {
                headB = a1;
            }
        }
        
        return headA;
        
    }
}