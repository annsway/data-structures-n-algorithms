public class StackApplication {

    public static void main(String[] args) {

        Stack<Integer> stackInteger = new Stack<>();

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

        stackInteger.pop();
        stackInteger.pop();
        stackInteger.pop();
        stackInteger.pop();
        stackInteger.pop();

        stackInteger.peek();

        stackInteger.pop();
        stackInteger.pop();

        stackInteger.push(18);
        stackInteger.push(21);
        stackInteger.push(23);

        stackInteger.pop();
        stackInteger.pop();
        stackInteger.peek();

        System.out.println("The top element of the integer stack is "+stackInteger.peek());

        System.out.println("\nPrint the integer stack from bottom to top: ");
        stackInteger.printStack(stackInteger);

        /////////////////////////////////
        Stack<Person> stackPerson = new Stack<>();

        stackPerson.push(new Person("Ali", "Naqvi"));
        stackPerson.push(new Person("Joe", "Cool"));
        stackPerson.push(new Person("Jo", "Nice"));
        stackPerson.push(new Person("Alice", "Good"));
        stackPerson.push(new Person("Tim", "Johnson"));
        stackPerson.push(new Person("Jim", "Raff"));
        stackPerson.push(new Person("JoAnna", "Halls"));

        System.out.println("\nThe top element of the Person stack is "+stackPerson.peek());

        System.out.println("\nPrint the Person stack from bottom to top: ");
        stackPerson.printStack(stackPerson);
        
        
    }

}
