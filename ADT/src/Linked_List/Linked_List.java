package Linked_List;

import General.node;

public class Linked_List<T extends Comparable<T>> implements Comparable<Linked_List<T>>{
    node<T> head;

    int size;
    //constructor
    public Linked_List(){
        head = null;
        size = 0;
    }
    public boolean remove(){
        return false;
    }
    //add at index i
    public boolean add(int i, T value){
        if (i > size){
            return false;
        }
        return false;
    }
    public void append(T value){
        node<T> curNode = head;
        node<T> temp = new node<T>(value);
        if(head == null){
            head = temp;
            size++;
        }else {
            while (curNode.getNext() != null) {
                curNode = curNode.getNext();
            }
            curNode.setNext(temp);
            size++;
        }
    }
    public T getValue(int i){
        node<T> curNode = head;
        if(i > size) {
            return null;
        }
        int j = 0;
        while(curNode.getNext() != null){
            if(i == j){
                return curNode.getValue();
            }
            j++;
            curNode = curNode.getNext();
        }
        return null;
    }
    //return two listed appended together
    public void append(Linked_List<T> LL){
        node curNode = head;
        while(curNode.getNext() != null){
            curNode = curNode.getNext();
        }
        for(int i = 0; i < LL.getSize();i++){
            this.append(LL.getValue(i));
        }
    }
    public boolean is_empty(){
        return head == null;
    }
    public int getSize(){
        return this.size;
    }
    @Override
    public String toString(){
        node curNode = head;
        String str = "";
        if(head == null){
            return "empty";
        }
        while(curNode.getNext() != null){
            str += curNode.getValue().toString() + " ";
            curNode = curNode.getNext();
        }
        str += curNode.getValue().toString();
        return str;
    }
    @Override
    public int compareTo(Linked_List<T> o) {
        return 0;
    }
}
