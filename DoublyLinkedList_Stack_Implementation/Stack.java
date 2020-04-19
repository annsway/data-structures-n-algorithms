public class Stack<T> implements IStack<T>{

    DoublyLinkedList<T> stack = new DoublyLinkedList<T>();
    Object object = new Object();

    @Override
    public T peek(){
        return (T) stack.head;
    }; //This method is used to view the top item in the stack without removing it. It returns Null if the stack is empty.

    @Override
    public void pop(){
        stack.removeFirstNode();
    }; //This method is similar to peek(). It should throw an exception when the stack is empty.

    @Override
    public void push(T value){
        stack.addFirstNode(value);
    }; //This method puts an item into the stack.

    @Override
    public int size(){
        return stack.size();
    }; //This method return the number of elements in the stack.

}
