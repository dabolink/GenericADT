package Stack;

import General.node;

public class Stack<T extends Comparable<T>>implements Comparable<T> {
    node<T> head;
    int size;
    public Stack(){
        head = null;
        size = 0;
    }
    public Stack(node<T> h, int size){
        this.head = h;
        this.size = size;
    }
    public void push(T value){
        node<T> temp = new node<T>(value);
        if (head == null){
            head = temp;
        }
        else {
            node<T> next = head;
            while (next.getNext() != null) {
                next = next.getNext();
            }
            next.setNext(temp);
        }
        size++;
    }
    public T pop(){
        if(head == null) {
            return null;
        }
        node<T> temp = head;
        while(temp.getNext().getNext() != null){
            temp = temp.getNext();
        }
        T retVal = temp.getNext().getValue();
        temp.setNext(null);
        size--;
        return retVal;

    }
    public boolean is_empty(){
        return head == null;
    }
    public String toString(){
        if(head == null){
            return "empty";
        }
        String str = "";
        node<T> temp = head;
        while(temp.getNext() != null){
            str += temp.getValue().toString() + " ";
            temp = temp.getNext();
        }
        str += temp.getValue().toString();
        return str;
    }

    @Override
    public int compareTo(T o) {
        return 0;
    }
}
