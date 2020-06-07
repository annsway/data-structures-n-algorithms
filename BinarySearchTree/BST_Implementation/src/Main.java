public class Main {

    public static void main(String[] args){
        /**    Create the following BST
                   50
               /      \
            30         70
           /  \       /  \
         20    40    60    80
         **/

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        //Insert data into the tree

        tree.insertElement(50);
        tree.insertElement(30);
        tree.insertElement(20);
        tree.insertElement(40);
        tree.insertElement(70);
        tree.insertElement(60);
        tree.insertElement(80);

        //Search for element 103 and print the results
        System.out.println("Is 103 in the binary tree? "+tree.searchElement(103));

        //Search for element 80 and print the results
        System.out.println("Is 80 in the binary tree? "+tree.searchElement(80));

        //Print data for all traversals

        System.out.println("Preorder: ");
        tree.positionsPreorderElements();
        System.out.println("Inorder: ");
        tree.positionsInorderElements();
        System.out.println("Postorder:  ");
        tree.positionsPostorderElements();

        //Delete element 20
        tree.deleteElement(20);
        System.out.println("After deletion of 20. Inorder: ");
        tree.positionsInorderElements();

        //Delete element 30
        tree.deleteElement(30);
        System.out.println("After deletion of 30. Inorder: ");
        tree.positionsInorderElements();

        //Delete element 50
        tree.deleteElement(50);
        System.out.println("After deletion of 50. Inorder: ");
        tree.positionsInorderElements();

    }

}
