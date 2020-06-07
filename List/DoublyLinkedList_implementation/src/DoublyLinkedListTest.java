import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {

    @Test
    public void Test(){

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // Test if node is successfully added to the linked list 
        list.addFirstNode(1);
        list.addFirstNode(2);
        Integer res1 = list.head.getElement();
        assertEquals(2, (Object) res1);

        // Test if node is successfully removed from the linked list 
        list.removeLastNode();
        Object res2 = list.head.getNext();
        assertEquals(null, res2);

        // Test isEmpty()
        list.removeLastNode();
        Boolean res3 = list.isEmpty();
        assertEquals(true, res3);
    }

}