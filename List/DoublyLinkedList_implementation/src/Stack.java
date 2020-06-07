import Exceptions.EmptyCollectionException;

public class Stack<T> implements IStack<T>{

    // Adapter class
    DoublyLinkedList<T> list;

    public Stack(DoublyLinkedList<T> list){
        this.list = list;
    }

    @Override
    public T peek(){
        if(list.isEmpty()){
            return null;
        }
        return (T) list.head;
    }; //This method is used to view the top item in the stack without removing it. It returns Null if the stack is empty.

    @Override
    public void pop() throws EmptyCollectionException {
        if(list.isEmpty()){
            throw new EmptyCollectionException("stack");
        }
        list.removeFirstNode();
    }; //This method is similar to peek(). It should throw an exception when the stack is empty.

    @Override
    public void push(T value){
        list.addFirstNode(value);
    }; //This method puts an item into the stack.

    @Override
    public int size(){
        return list.size();
    }; //This method return the number of elements in the stack.

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void traverseForward(){
        list.traverseForward();
    }

    @Override
    public void traverseBackward(){
        list.traverseBackward();
    }

}
