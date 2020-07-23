import java.util.ArrayList;

public class Position<E extends Comparable<E>> {
    private E data;
    private Position<E> parent;
    private ArrayList<Position<E>> children;

    public Position(E data, Position<E> parent){
        this.data = data;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    public void setData(E data){
        this.data = data;
    }

    public E getData(){
        return this.data;
    }

    public int compareTo(E e) {
        return getData().compareTo(e);
    }

    public Position<E> getParent(){
        return this.parent;
    }

    public void addChild(Position<E> child){
        this.children.add(child);
    }

    public ArrayList<Position<E>> getChildren(){
        return this.children;
    }

    @Override
    public String toString(){
        return ""+this.data;
    }

}