public class ReverseLinkedListRecursion {
    public ListNode reverse(ListNode head) { // Node 3
        // Corner Case  || Base Case
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverse(head.next); // Node3; newHead won't be created until we hit the base case
        // head对应的是recursion的上一层
        ListNode n2 = head.next; // 表示读head指向的node1中的黄色小纸条来找到node2
        n2.next = head; // ~ head.next.next = head 表示将node2中的黄色小纸条next写上head指向的node1的地址
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {

        GenerateLinkedList list = new GenerateLinkedList();
        int[] arr = {1, 2, 3};
        ListNode head = list.generate(arr);
        System.out.println(head.value);

        ReverseLinkedListRecursion sol = new ReverseLinkedListRecursion();
        System.out.println(sol.reverse(head).value);;
    }
}
