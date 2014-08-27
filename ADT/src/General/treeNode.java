package General;

public class treeNode<T extends Comparable<T>> implements Comparable<T>{
    T value;
    treeNode<T> right;
    treeNode<T> left;

    public treeNode(T value) {
        this.value = value;
        right = null;
        left = null;
    }
    public treeNode<T> getRight(){
        return right;
    }
    public treeNode<T> getLeft(){
        return left;
    }
    public void setRight(treeNode<T> node){
        right = node;
    }
    public void setLeft(treeNode<T> node){
        left = node;
    }
    public T getValue(){
        return this.value;
    }
    public void setValue(T value){
        this.value = value;
    }
    @Override
    public int compareTo(T o) {
        return this.value.compareTo(o);
    }
}
