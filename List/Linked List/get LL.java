// Method 1

//
ListNode getNode(ListNode head, int target){
	if(head == null){
		return null;
	}
	int count = 0; 

	ListNode curr = head;  // you don't have to create 
	while(curr != null){
		if(count == target){
			return curr; 
		}
		curr = curr.next; 
		count++;
	}
	return null; 
}

// Method 2 (better)

ListNode get(ListNode head, int index){
	// Termination condition 取反 De Morgan‘s Laws
	// Corner cases: index <= 0 || head == null
	while(index > 0 && head != null){
		head = head.next; 
		index--; 
	}
	return head; 
}