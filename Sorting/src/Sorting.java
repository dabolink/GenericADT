import Bubble.Bubble;

/**
 * Created by Daniel on 13/08/2014.
 */
public class Sorting {
    public static void main(String[] args) {
        Integer[] test = new Integer[10];
        for(int i=0;i<10;i++){
            test[i] = i;
        }
        Bubble b = new Bubble<Integer>(test);
        System.out.println(b.toString());
        b.sort();
        System.out.println(b.toString());

    }
}
