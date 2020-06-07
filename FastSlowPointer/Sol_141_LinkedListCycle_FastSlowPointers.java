/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// Ref: https://www.youtube.com/watch?v=bxCb37nLXWM

public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if(head==null || head.next==null){
            return false;
        } 

        ListNode fast=head.next, slow=head;

        while(fast!=slow){
            
            if(fast==null || fast.next==null){
                return false;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        
        return true;

    }
}