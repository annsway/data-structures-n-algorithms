public class Solution {
    public ListNode generate(int n){
        ListNode head = new ListNode(0);
        ListNode cur = head; // cur must have the same reference as head to point to the same ListNode
        for(int i=1; i<n; i++){
            cur.next = new ListNode(i); // must new a ListNode() whenever generating the next node
            cur = cur.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.generate(5); // IDE Debugger: set breakpoint here to see how a LinkedList works in memory
    }
}

class ListNode{
    int value;
    ListNode next;
    public ListNode(int v){
        value = v;
    }
}

