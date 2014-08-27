package Queue;

import General.node;

/** generic Queue **/

public class Queue<T extends Comparable<T>> implements Comparable<Queue> {
    node<T> head;
    int size;
    public Queue(){
        this.head = null;
        this.size = 0;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void push(T t){
        node<T> temp = new node<T>(t);
        if(head == null) {
            head = temp;
        }else{
            node<T> next = head;
            while(next.getNext() != null){
                next = next.getNext();
            }
            next.setNext(temp);
        }
        size++;
    }
    public T pop(){
        if (head == null){
            return null;
        }
        node<T> temp = head;
        head = head.getNext();
        size--;
        return temp.getValue();

    }
    public void empty(){
        head = null;
        size = 0;
    }
    public int getSize(){
        return size;
    }
    @Override
    public String toString(){
        String str = "";
        node<T> temp = head;
        if(head == null){
            return "empty";
        }
        while(temp.getNext() != null){
            str += temp.getValue().toString() + " ";
            temp = temp.getNext();
        }
        str += temp.getValue().toString();
        return str;
    }

    @Override
    public int compareTo(Queue o) {
        return 0;
    }
}
