/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head, fast=head;
        int top; 
        Stack<Integer> stackNode = new Stack<>();
        
        while(fast!=null && fast.next != null){
            
            stackNode.push(slow.val); // You cannot compare Node to Node, as they will have different addresses 
            slow = slow.next;
            fast = fast.next.next;

        }
        
        
        if(fast!=null){
            slow = slow.next;
        }
        
        while(slow != null){
            top = stackNode.pop();
            if(top != slow.val){
                return false;
            }
            slow = slow.next;
            
        }
        return true; 
        
    }
}