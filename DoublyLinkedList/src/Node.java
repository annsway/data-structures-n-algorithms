public class Node<T>
{
    // Instance variables:
    private T element;
    private Node previous, next;

//      If we want to have different ways of initializing an object using different number of parameters,
//      then we must do constructor overloading as we do method overloading when we want different definitions
//      of a method based on different parameters.

    /** Creates a node with null references to its element, previous node and next node. */
    public Node()
    {
        this(null,  null, null);
    }

    /** Creates a node with the given element and next node. */
    public Node(T e,  Node previous, Node next)  {
        element = e;
        this.previous = previous;
        this.next  = next;
    }

    // Accessor methods:
    public T getElement() {
        return  element;
    }

    public Node getPrevious() {
        return previous;
    }

    public Node getNext() {
        return  next;
    }

    // Modifier methods:
    public void  setElement(T newElem)  {
        element  =  newElem;
    }

    public void setPrevious(Node newPreivous){
        previous = newPreivous;
    }

    public void  setNext(Node newNext)  {
        next  =  newNext;
    }

    public String toString(){//overriding the toString() method
        return ""+element;
    }
}
