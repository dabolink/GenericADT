package General;

public class node<T extends Comparable<T>> implements Comparable<node<T>>{
    T value;
    node<T> next;
    node<T> prev;
    public node(T v){
        value = v;
        next = null;
        prev = null;
    }
    public T getValue(){
        return value;
    }
    public node<T> getNext(){
        return next;
    }
    public node<T> getPrev(){
        return prev;
    }
    public void setNext(node<T> n){
        next = n;
    }
    public void setPrev(node<T> p){
        prev = p;
    }
    public void setValue(T v){
        value = v;
    }

    @Override
    public int compareTo(node<T> o) {
        return value.compareTo(o.getValue());
    }
}
