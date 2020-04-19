public class DoublyLinkedList<E> {

    Node head;

    public int size(){
        int res = 0;
        Node curr_node = head;
        while(curr_node != null){
                res++;
                curr_node = curr_node.getNext();
        }
        return res;
    }

    public boolean isEmpty(Node node){
        return head == null;
    }

    public void addFirstNode(E element){
        Node new_node = new Node(element, null,null);

        if (head != null) {
            new_node.setNext(head);
        }
        head = new_node;
    }

    public void addLastNode(E element){
        Node last_node = new Node(element, null, null);
        Node curr_node = head;

        if(head == null){
            addFirstNode((E) last_node);
        }

        while(curr_node.getNext() != null){
            curr_node = curr_node.getNext();
        }

        last_node.setPrevious(curr_node);
        curr_node.setNext(last_node);
    }

    public void removeFirstNode(){

        if (head != null){
            Node new_head = head.getNext();
            new_head.setPrevious(null);
            head = new_head;
        }

    }

    public void removeLastNode(){
        Node curr_node = head;
        Node prev_node;

        while(curr_node.getNext()!=null){
            curr_node = head.getNext();
        }
        prev_node = curr_node.getPrevious();
        prev_node.setNext(null);
        curr_node.setPrevious(null);


    }

}


