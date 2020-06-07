interface IDoublyLinkedList<T> {
    
    int size();

    boolean isEmpty();

    void addFirstNode(T element);

    void addLastNode(T element);

    void removeFirstNode();

    void removeLastNode();

    void traverseForward();
    
    void traverseBackward();
}
