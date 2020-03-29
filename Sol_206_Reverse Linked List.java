/**
 * https://leetcode.com/problems/reverse-linked-list/
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        if(head == null || head.next == null){
            return head; // this kind of return will be run at the case of head = 5 (since head.next == null)
        }
        
        // step into the recursion of the reverseList method till the base criteria is met. 
        ListNode first_pointer = reverseList(head.next); // first_pointer = 5 for every case. 
        head.next.next = head;
        head.next = null; 
        
        return first_pointer; // this kind of return will be run in all the other cases, except for head = 5
        
    }
}