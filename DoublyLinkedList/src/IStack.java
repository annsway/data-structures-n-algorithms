/** In java <T> means Generic class. A Generic Class is a class which can work on any type of data type
 * or in other words we can say it is data type independent. ... <T> specifically stands for generic type.
 * Ref: https://stackoverflow.com/questions/462297/how-to-use-classt-in-java
 **/
public interface IStack<T> {
    T peek(); //This method is used to view the top item in the stack without removing it. It returns Null if the stack is empty.
    void pop(); //This method is similar to peek(). It should throw an exception when the stack is empty.
    void push(T value); //This method puts an item into the stack.
    int size(); //This method return the number of elements in the stack.
    boolean isEmpty();
    void traverseForward();
    void traverseBackward();
}
