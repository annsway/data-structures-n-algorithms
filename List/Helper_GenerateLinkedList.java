public class GenerateLinkedList{
    public ListNode generate(int[] array){
        ListNode head = new ListNode(array[0]);
        ListNode curr = head;
        for(int i=1; i<array.length; i++){
            curr.next = new ListNode(array[i]);
            curr = curr.next;
        }
        return head;
    }
}
