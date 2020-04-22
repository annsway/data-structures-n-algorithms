public class Stack<T> implements IStack<T>{

    // Adapter Pattern
    DoublyLinkedList<T> list;

    public Stack(DoublyLinkedList<T> list){
        this.list = list;
    }

    @Override
    public T peek(){
        return (T) list.head;
    }; //This method is used to view the top item in the stack without removing it. It returns Null if the stack is empty.

    @Override
    public void pop(){
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

    private boolean isEmpty() {
        return list.isEmpty();
    }

    public void printStack(){
        list.print();
    }

    //    public void printStack(Stack<T> s){
//        // Recursion
//        if(s.isEmpty()){
//            return;
//        }
//        T x = s.peek();
//        s.pop();
//        printStack(s);
//        System.out.println(x.toString()+" ");
//        s.push(x);
//
//    }
}
