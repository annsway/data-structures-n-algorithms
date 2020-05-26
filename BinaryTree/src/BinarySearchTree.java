import java.util.ArrayList;
import java.util.Iterator;

public class BinarySearchTree<E extends Comparable<E>> implements SuperTree<E>{

    Position<E> root;

    public BinarySearchTree(){
        this.root = null;
    }

    @Override
    public Position<E> rootElement(){
        return this.root;
    }

    @Override
    public Position<E> parentElement(Position<E> p) throws IllegalArgumentException{
        return p.getParent();
    }

    @Override
    public Iterable<Position<E>> childrenElements(Position<E> p) throws IllegalArgumentException{
        ArrayList<Position<E>> children = p.getChildren();
        assert(children.size()==2);
        return p.getChildren();
    }

    @Override
    public int numChildrenElements(Position<E> p) throws IllegalArgumentException{
        Iterable<Position<E>> children = this.childrenElements(p);
        int childrenCount = 0;
        for(Position<E> child: children){
            if(child != null){
                childrenCount++;
            }
        }
        return childrenCount;
    }

    @Override
    public boolean isRootElement(Position<E> p) throws IllegalArgumentException{
        return p == this.root;
    }

    @Override
    public int sizeOfTree(){
        return sizeOfTree(this.root);
    }

    // Helper function: size of subtree
    private int sizeOfTree(Position<E> p){
        if(p==null){
            return 0;
        }
        int leftSize = sizeOfTree(p.getChildren().get(0));
        int rightSize = sizeOfTree(p.getChildren().get(1));
        return leftSize + rightSize + 1;
    }

    @Override
    public boolean isEmptyTree(){
        return this.root == null;
    }

    @Override
    public boolean isInternalNode(Position<E> p){
        return p != root && this.numChildrenElements(p) > 0;
    }

    @Override
    public boolean isExternalNode(Position<E> p){
        return !this.isInternalNode(p);
    }

    @Override
    public boolean insertElement(E element){
        if(this.root == null){
            this.root = new Position<E>(element, null);
            this.root.addChild(null);
            this.root.addChild(null);
        }
        Position<E> current = root;
        Position<E> parent = null;

        // find the parent to attach
        while(current != null){
            if(current.compareTo(element) < 0){
                parent = current;
                current = current.getChildren().get(1);
            } else if(current.compareTo(element) > 0){
                parent = current;
                current = current.getChildren().get(0);
            } else{
                return false; // duplicate element won't be inserted
            }
        }
        // attach the element
        Position<E> newPosition = new Position<E>(element, parent);
        newPosition.addChild(null);
        newPosition.addChild(null);
        if(parent.compareTo(element) < 0){
            parent.getChildren().set(1, newPosition);
        } else {
            parent.getChildren().set(0, newPosition);
        }
        return true;
    } //returns true if insert is successful

    @Override
    public boolean deleteElement(E element){
        if(!searchElement(element)){
            return false;
        }
        Position<E> current = root;
        Position<E> parent = null;

        while(current.compareTo(element)!=0){
            if(current.compareTo(element)<0){
                parent = current;
                current = current.getChildren().get(1);
            } else if(current.compareTo(element)>0){
                parent = current;
                current = current.getChildren().get(0);
            }
        }

        // if element has no children
        if(numChildrenElements(current)==0){
            parent.getChildren().set(0, null);
        } else if(numChildrenElements(current)==1){
            parent.getChildren().set(0, current.getChildren().get(1));
        } else {
            Position<E> posToDelete = current;
            // current will be the rightmost position
            parent = current;
            current = current.getChildren().get(0); // go to the left side
            // find the rightmost position of the left side
            while(current.getChildren().get(1)!=null){
                parent = current;
                current = current.getChildren().get(1);
            }
            // if there's left child of the rightmost position
            if(current.getChildren().get(0)!=null){
                parent.getChildren().set(1, current.getChildren().get(0));
            }
            parent.getChildren().set(0, null); // remove link of the left child to the parent of the rightmost position
            posToDelete.setData(current.getData());

        }

        return true;

    } //returns true if delete is successful

    @Override
    public boolean searchElement(E element){
        return helper_search(element, root);
    } //returns true if element is found in the tree

    public boolean helper_search(E element, Position<E> current){
        if(current == null){
            return false;
        }
        if(current.compareTo(element)==0){
            return true;
        }
        if(current.compareTo(element)<0){
            return helper_search(element, current.getChildren().get(1));
        }
        return helper_search(element, current.getChildren().get(0));
    }

    @Override
    public void clearElements(){
        root = null;
    } //will remove all elements from the tree

    @Override
    public void positionsPreorderElements(){
        this.helper_Preorder(this.root);
    } //Print the tree elements

    // Helper function
    private void helper_Preorder(Position<E> p){
        if(p==null){
            return;
        }
        System.out.println(p.getData()+" ");
        helper_Preorder(p.getChildren().get(0));
        helper_Preorder(p.getChildren().get(1));
    }

    @Override
    public void positionsPostorderElements(){
        this.helper_Postorder(this.root);
    } //Print the tree elements

    // Helper function
    private void helper_Postorder(Position<E> p){
        if(p==null){
            return;
        }
        helper_Postorder(p.getChildren().get(0));
        helper_Postorder(p.getChildren().get(1));
        System.out.println(p.getData()+" ");
    }

    @Override
    public void positionsInorderElements(){
        this.helper_Inorder(this.root);
    } //Print the tree elements

    // Helper function
    private void helper_Inorder(Position<E> p){
        if(p==null){
            return;
        }
        helper_Inorder(p.getChildren().get(0));
        System.out.println(p.getData()+" ");
        helper_Inorder(p.getChildren().get(1));
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public String toString(){
        return " ";
    }
}
