public class Queue<T> implements IQueue<T>{

    // Adapter Pattern
    DoublyLinkedList<T> list;

    public Queue(DoublyLinkedList<T> list){
        this.list = list;
    }

    //Adds one element to the rear of this queue.
    public void enqueue(T element) {
        list.addLastNode(element);
    }

    //Removes and returns the element at the front of this queue.
    public T deque() {
        T firstVal = (T) list.head; //bottom or top?
        list.removeFirstNode();
        return firstVal;
    }

    //Returns without removing the element at the front of this queue.
    public T first() {
        return (T)list.head;
    }

    //Returns true if this queue contains no elements.
    public boolean isEmpty() {
        return list.isEmpty();
    }

    //Returns the number of elements in this queue.
    public int size() {
        return list.size();
    }

    // Returns a string representation of this queue.
    public String toString() {
        return " "+list.head.getElement();
    }

    public void printQueue(){
        list.print();
    }
}
