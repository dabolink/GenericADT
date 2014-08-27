package Bubble;

/**
 * Created by Daniel on 13/08/2014.
 */
public class Bubble <T>{
    T[] init;
    public Bubble(T[] i){
        init = i;
    }
    public void sort(){
        System.out.println("working");
    }
    @Override
    public String toString(){
        String str = "";
        for(int i = 0; i < init.length; i++){
            str += init[i].toString() + " ";
        }
        str += "\n";
        return str;
    }
}
