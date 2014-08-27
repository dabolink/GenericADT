package Trees;
import General.treeNode;

public class Binary_Tree<T extends Comparable<T>> implements Comparable<Binary_Tree>  {
    treeNode<T> head;
    int size;
    public Binary_Tree(){
        head = null;
        size = 0;
    }
    @Override
    public int compareTo(Binary_Tree o) {
        return 0;
    }
    public void add(T value){
        treeNode<T> temp;
        temp = new treeNode<T>(value);
        if(head == null){
            head = temp;
            size++;
        }else{
            treeNode<T> curNode = head;
            int comp = curNode.compareTo(value);
            if(comp == 0){
                System.out.println("already in tree");
            }
            else if(comp == 1){
                if(curNode.getLeft() == null){
                    curNode.setLeft(temp);
                    size++;
                }else {
                    recAdd(temp, curNode.getLeft());
                }
            }
            else if(comp == -1){
                if(curNode.getRight() == null){
                    curNode.setRight(temp);
                    size++;
                }
                else {
                    recAdd(temp, curNode.getRight());
                }
            }
        }
    }
    private void recAdd(treeNode<T> temp, treeNode<T> curNode){
        if(curNode == null){
            System.out.println("error");
        }else{
            int comp = curNode.compareTo(temp.getValue());
            if(comp == 0){
                System.out.println("already in tree");
            }else if(comp == 1){
                if(curNode.getLeft() == null){
                    curNode.setLeft(temp);
                    size++;
                }else{
                    recAdd(temp, curNode.getLeft());
                }
            }else if (comp == -1){
                if(curNode.getRight() == null){
                    curNode.setRight(temp);
                    size++;
                }else{
                    recAdd(temp, curNode.getRight());
                }
            }
        }
    }
    public boolean remove(T value){
        return false;
    }
    public boolean is_Empty(){
        return head == null;
    }
    public void empty(){
        head = null;
    }
    public String toString(){
        if(head == null){
            return "empty";
        }
        String str = "";
        str += recStringLeft(head.getLeft());
        str += head.getValue().toString();
        str += recStringRight(head.getRight());
        return str;
    }
    private String recStringLeft(treeNode<T> curNode){
        String str = "";
        if(curNode == null){
            return str;
        }
        if(curNode.getLeft() == null){
            str = "(" + curNode.getValue().toString();
            str += recStringRight(curNode.getRight());
        }
        else{
            str += "(" + recStringLeft(curNode.getLeft());
            str += curNode.getValue().toString();
            str += recStringRight(curNode.getRight());
        }
        return str + ")";
    }
    private String recStringRight(treeNode<T> curNode){
        String str = "";
        if(curNode == null){
            return str;
        }
        if(curNode.getRight() == null){
            str = "(" + recStringLeft(curNode.getLeft());
            str += curNode.getValue().toString();

        }
        else{
            str += "(" + recStringLeft(curNode.getLeft());
            str += curNode.getValue().toString();
            str += recStringRight(curNode.getRight());
        }
        return str + ")";
    }

    public int getSize() {
        return size;
    }
}
