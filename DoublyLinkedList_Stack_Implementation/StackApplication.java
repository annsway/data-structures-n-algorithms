public class StackApplication {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.push(13);
        stack.push(14);
        stack.push(15);
        stack.push(16);
        stack.push(17);
        stack.push(18);
        stack.push(19);
        stack.push(20);

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        stack.peek();

        stack.pop();
        stack.pop();

        stack.push(18);
        stack.push(21);
        stack.push(23);

        stack.pop();
        stack.pop();
        stack.peek();

        System.out.println(stack.peek());

        /////////////////////////////////
        Stack<Person> stackPerson = new Stack<>();

        stackPerson.push(new Person("Ali", "Naqvi"));
        stackPerson.push(new Person("Joe", "Cool"));
        stackPerson.push(new Person("Jo", "Nice"));
        stackPerson.push(new Person("Alice", "Good"));
        stackPerson.push(new Person("Tim", "Johnson"));
        stackPerson.push(new Person("Jim", "Raff"));
        stackPerson.push(new Person("JoAnna", "Halls"));

        System.out.println(stackPerson.peek().FirstName);
        System.out.println(stackPerson.size());
    }

}
