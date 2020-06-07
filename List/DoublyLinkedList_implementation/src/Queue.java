import Exceptions.EmptyCollectionException;

public class Queue<T> implements IQueue<T>{

    // Adapter class
    DoublyLinkedList<T> list;

    public Queue(DoublyLinkedList<T> list){
        this.list = list;
    }

    @Override
    public void enqueue(T element) {
        list.addLastNode(element);
    }    //Adds one element to the rear of this queue.

    @Override
    public T deque() throws EmptyCollectionException {
        if(list.isEmpty()){
            throw new EmptyCollectionException("queue");
        }
        T firstVal = (T) list.head;
        list.removeFirstNode();
        return firstVal;
    }    //Removes and returns the element at the front of this queue.


    @Override
    public T first() {
        if(list.isEmpty()){
            return null;
        }
        return (T)list.head;
    }    //Returns without removing the element at the front of this queue.


    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }    //Returns true if this queue contains no elements.


    @Override
    public int size() {
        return list.size();
    }    //Returns the number of elements in this queue.


    @Override
    public String toString() {
        return " "+list.head.getElement();
    }    // Returns a string representation of this queue.


    @Override
    public void traverseForward(){
        list.traverseForward();
    }

    @Override
    public void traverseBackward(){
        list.traverseBackward();
    }

}
