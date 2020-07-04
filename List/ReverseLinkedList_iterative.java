public class Solution {
    public ListNode reverse(ListNode head) {
        // Write your solution here
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next; // record next
            curr.next = prev; // reverse
            prev = curr; // move prev forward
            curr = next; // move curr forward
        } // curr = null 
        return prev; // the last node 
    }

    public static void main(String[] args) {

        GenerateLinkedList list = new GenerateLinkedList();
        int[] arr = {1, 2, 3, 4};
        ListNode head = list.generate(arr);
        System.out.println(head.value);

        Solution sol = new Solution();
        System.out.println(sol.reverse(head).value);;
    }
}



