public class Main {

    public static void main(String[] args) {

        System.out.println("\n+++++++++++++++++++++++++++++"+
                        "\n++++++++++ Queue ++++++++++++"+
                        "\n+++++++++++++++++++++++++++++");

        DoublyLinkedList<Person> queueListForPerson = new DoublyLinkedList<>();
        Queue<Person> queuePerson = new Queue<>(queueListForPerson);

        queuePerson.enqueue(new Person("Ali", "Naqvi"));
        queuePerson.enqueue(new Person("Baja", "Cool"));
        queuePerson.enqueue(new Person("Celine", "Nice"));
        queuePerson.enqueue(new Person("David", "Good"));
        queuePerson.enqueue(new Person("Eric", "Johnson"));
        queuePerson.enqueue(new Person("Fawad", "Raff"));
        queuePerson.enqueue(new Person("Gina", "Halls"));

        System.out.println("\nPrint queue from first to last (traverse forward): ");
        queuePerson.traverseForward();

        System.out.println("\n\nPrint queue from last to first (traverse backward): ");
        queuePerson.traverseBackward();

        queuePerson.deque();
        queuePerson.deque();


        System.out.println("\n\nPrint queue from first to last (traverse forward) after deque: ");
        queuePerson.traverseForward();

        System.out.println("\n\nPrint queue from last to first (traverse backward) after deque: ");
        queuePerson.traverseBackward();

        ////////////////////////////////////////////

        System.out.println("\n\n+++++++++++++++++++++++++++++"+
                            "\n++++++++++ Stack ++++++++++++"+
                            "\n+++++++++++++++++++++++++++++");
        DoublyLinkedList<Integer> stackList = new DoublyLinkedList<>();
        Stack<Integer> stackInteger = new Stack<>(stackList);

        stackInteger.push(10);
        stackInteger.push(20);
        stackInteger.push(30);
        stackInteger.push(40);
        stackInteger.push(50);
        stackInteger.push(60);
        stackInteger.push(70);
        stackInteger.push(80);
        stackInteger.push(90);
        stackInteger.push(100);

        System.out.println("\n\nPrint stack from top to bottom (traverse forward): ");
        stackInteger.traverseForward();

        System.out.println("\n\nPrint stack from bottom to top (traverse backward): ");
        stackInteger.traverseBackward();

        stackInteger.pop();
        stackInteger.push(200);

        System.out.println("\n\nPrint stack from top to bottom (traverse forward) after pop() and push(): ");
        stackInteger.traverseForward();

        System.out.println("\n\nPrint stack from bottom to top (traverse backward) after pop() and push(): ");
        stackInteger.traverseBackward();

    }

}
