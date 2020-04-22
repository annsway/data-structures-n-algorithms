public class Main {


    public static void main(String[] args) {

        ////////////////////////////////////////////
        ////////////////////// Queue ///////////////
        ////////////////////////////////////////////

        DoublyLinkedList<Integer> queueListForInteger = new DoublyLinkedList<>();
        Queue<Integer> queueInteger = new Queue<>(queueListForInteger);

        queueInteger.enqueue(1);
        queueInteger.enqueue(2);
        queueInteger.enqueue(3);
        queueInteger.enqueue(4);
        queueInteger.enqueue(5);
        queueInteger.enqueue(6);
        queueInteger.enqueue(7);
        queueInteger.enqueue(8);
        queueInteger.enqueue(9);
        queueInteger.enqueue(10);
        queueInteger.enqueue(11);
        queueInteger.enqueue(12);
        queueInteger.enqueue(13);
        queueInteger.enqueue(14);
        queueInteger.enqueue(15);
        queueInteger.enqueue(16);
        queueInteger.enqueue(17);
        queueInteger.enqueue(18);
        queueInteger.enqueue(19);
        queueInteger.enqueue(20);


        System.out.println("+++++++++++++++++++++++++++++"+
                        "\n++++++++++ Queue ++++++++++++"+
                        "\n+++++++++++++++++++++++++++++\n");

        System.out.println("Print integer queue from first to last: ");
        queueInteger.printQueue();

        queueInteger.deque();
        System.out.println("\n");
        queueInteger.printQueue();

        queueInteger.deque();
        System.out.println("\n");
        queueInteger.printQueue();

        queueInteger.deque();
        System.out.println("\n");
        queueInteger.printQueue();

        queueInteger.deque();
        System.out.println("\n");
        queueInteger.printQueue();

        queueInteger.deque();
        System.out.println("\n");
        queueInteger.printQueue();

        System.out.println("\nThe first element of the integer queue is "+queueInteger.first()+"\n");

        queueInteger.deque();
        queueInteger.deque();
        queueInteger.enqueue(18);
        queueInteger.enqueue(21);
        queueInteger.enqueue(23);
        queueInteger.deque();
        queueInteger.deque();

        queueInteger.printQueue();
        System.out.println("\nThe first element of the integer queue is "+queueInteger.first()+"\n");

        /////////////////////////////////

        DoublyLinkedList<Person> queueListForPerson = new DoublyLinkedList<>();
        Queue<Person> queuePerson = new Queue<Person>(queueListForPerson);

        queuePerson.enqueue(new Person("Ali", "Naqvi"));
        queuePerson.enqueue(new Person("Joe", "Cool"));
        queuePerson.enqueue(new Person("Jo", "Nice"));
        queuePerson.enqueue(new Person("Alice", "Good"));
        queuePerson.enqueue(new Person("Tim", "Johnson"));
        queuePerson.enqueue(new Person("Jim", "Raff"));
        queuePerson.enqueue(new Person("JoAnna", "Halls"));

        queuePerson.printQueue();
        System.out.println("\nThe first element of Person queue is "+queuePerson.first()+"\n\n");

        ////////////////////////////////////////////
        ////////////////////// Stack ///////////////
        ////////////////////////////////////////////

        System.out.println("+++++++++++++++++++++++++++++"+
                            "\n++++++++++ Stack ++++++++++++"+
                            "\n+++++++++++++++++++++++++++++\n");
        DoublyLinkedList<Integer> stackList = new DoublyLinkedList<>();
        Stack<Integer> stackInteger = new Stack<>(stackList);

        stackInteger.push(1);
        stackInteger.push(2);
        stackInteger.push(3);
        stackInteger.push(4);
        stackInteger.push(5);
        stackInteger.push(6);
        stackInteger.push(7);
        stackInteger.push(8);
        stackInteger.push(9);
        stackInteger.push(10);
        stackInteger.push(11);
        stackInteger.push(12);
        stackInteger.push(13);
        stackInteger.push(14);
        stackInteger.push(15);
        stackInteger.push(16);
        stackInteger.push(17);
        stackInteger.push(18);
        stackInteger.push(19);
        stackInteger.push(20);
        System.out.println("Print intger stack from top to bottom: ");
        stackInteger.printStack();

        stackInteger.pop();
        System.out.println("\n");
        stackInteger.printStack();

        stackInteger.pop();
        System.out.println("\n");
        stackInteger.printStack();

        stackInteger.pop();
        System.out.println("\n");
        stackInteger.printStack();

        stackInteger.pop();
        System.out.println("\n");
        stackInteger.printStack();

        stackInteger.pop();
        System.out.println("\n");
        stackInteger.printStack();

        System.out.println("\nThe top element of the integer stack is "+stackInteger.peek());

        stackInteger.pop();
        stackInteger.pop();
        stackInteger.push(18);
        stackInteger.push(21);
        stackInteger.push(23);
        stackInteger.pop();
        stackInteger.pop();
        System.out.println("\n");
        stackInteger.printStack();

        System.out.println("\nThe top element of the integer stack is "+stackInteger.peek());


        /////////////////////////////////
        DoublyLinkedList<Person> stackListPerson = new DoublyLinkedList<>();
        Stack<Person> stackPerson = new Stack<>(stackListPerson);

        stackPerson.push(new Person("Ali", "Naqvi"));
        stackPerson.push(new Person("Joe", "Cool"));
        stackPerson.push(new Person("Jo", "Nice"));
        stackPerson.push(new Person("Alice", "Good"));
        stackPerson.push(new Person("Tim", "Johnson"));
        stackPerson.push(new Person("Jim", "Raff"));
        stackPerson.push(new Person("JoAnna", "Halls"));

        System.out.println("\n");
        stackPerson.printStack();
        System.out.println("\nThe top element of the Person stack is "+stackPerson.peek());



    }

}
