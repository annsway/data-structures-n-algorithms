interface IQueue <T> {

    //Adds one element to the rear of this queue.
    void enqueue(T element);

    //Removes and returns the element at the front of this queue.
    T deque();

    //Returns without removing the element at the front of this queue.
    T first();

    //Returns true if this queue contains no elements.
    boolean isEmpty();

    //Returns the number of elements in this queue.
    int size();

    // Returns a string representation of this queue.
    String toString();

    void traverseForward();

    void traverseBackward();
}