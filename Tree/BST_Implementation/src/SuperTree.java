
public interface SuperTree<E extends Comparable<E>> extends Iterable<E> {
    Position<E> rootElement();
    Position<E> parentElement(Position<E> p) throws IllegalArgumentException;
    Iterable<Position<E>> childrenElements(Position<E> p) throws IllegalArgumentException;
    int numChildrenElements(Position<E> p) throws IllegalArgumentException;
    boolean isRootElement(Position<E> p) throws IllegalArgumentException;
    int sizeOfTree();
    boolean isEmptyTree();
    boolean isInternalNode(Position<E> p);
    boolean isExternalNode(Position<E> p);
    boolean insertElement(E element); //returns true if insert is successful
    boolean deleteElement(E element); //returns true if delete is successful
    boolean searchElement(E element); //returns true if element is found in the tree
    void clearElements(); //will remove all elements from the tree
    void positionsPreorderElements(); //Print the tree elements
    void positionsPostorderElements(); //Print the tree elements
    void positionsInorderElements(); //Print the tree elements


}
