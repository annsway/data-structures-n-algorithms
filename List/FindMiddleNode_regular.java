public class Solution {
    public ListNode findMiddleNode(ListNode head) {
        // Write your solution here
        if(head == null || head.next == null){
          return head;
        }
        int len = 0;
        ListNode curr = head;
        ListNode midNode = head;

        while(curr != null){
            len++;
            curr = curr.next;
        }
        int mid = len / 2;
        for(int i = 0; i<mid; i++){
            midNode = midNode.next;
        }
        return midNode;
    }

    public static void main(String[] args) {

        GenerateLinkedList list = new GenerateLinkedList();
        int[] arr = {1, 2, 3};
        ListNode head = list.generate(arr);
//        System.out.println(head.value);

        Solution sol = new Solution();
        System.out.println(sol.findMiddleNode(head).value);;
    }
}



