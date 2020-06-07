public class DoublyLinkedList<E> implements IDoublyLinkedList<E> {

    // Adaptee class

    Node<E> head;

    public int size(){
        int res = 0;
        Node<E>curr_node = head;
        while(curr_node != null){
                res++;
                curr_node = curr_node.getNext();
        }
        return res;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void addFirstNode(E element){
        Node<E>new_node = new Node(element, null,null);

        if (head != null) {
            new_node.setNext(head);
            head.setPrevious(new_node); // Must-have, otherwise stack element.getPrevious will always be null
        }
        head = new_node;
    }

    public void addLastNode(E element){
        Node<E>last_node = new Node(element, null, null);
        Node<E>curr_node = head;

        if(head == null){
            addFirstNode((E) last_node);
        } else {
            while(curr_node.getNext() != null){
                curr_node = curr_node.getNext();
            }
            last_node.setPrevious(curr_node);
            curr_node.setNext(last_node);
        }

    }

    public void removeFirstNode(){

        if (head != null && head.getNext() != null){
            Node<E>new_head = head.getNext();
            new_head.setPrevious(null);
            head = new_head;
        } else {
            head = null;
        }

    }

    public void removeLastNode(){

        if(head==null){
            return;
        }
        Node<E>curr_node = head;
        Node<E>prev_node;

        // only one element
        if(head.getNext()==null){
            head = null;
            return;
        }

        // more than one element
        while(curr_node.getNext()!=null){
            curr_node = head.getNext(); // find the last element
        }
        prev_node = curr_node.getPrevious();
        prev_node.setNext(null);
        curr_node.setPrevious(null);

    }

    public void traverseForward(){
        Node<E> curr_node = head;
        while(curr_node!=null){
            System.out.print(curr_node.toString()+" ");
            curr_node = curr_node.getNext();
        }
    }

    public void traverseBackward(){
        Node<E> curr_node = head;
        while(curr_node.getNext()!=null){
            curr_node = curr_node.getNext();
        }
        while(curr_node!=null){
            System.out.print(curr_node.toString()+" ");
            curr_node = curr_node.getPrevious();
        }
    }

}


