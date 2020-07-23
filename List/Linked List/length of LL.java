public int length(ListNode head){

	int count = 0;
	ListNode curr = head; 

	while(curr != null){
		curr = curr.next; 
		count++; 
	}

	return count; 
}