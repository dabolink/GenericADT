
import Graph.Weighted_Graph.*;

public class ADT {
    public static void main(String[] args) {
        Weighted_Graph g = new Weighted_Graph(10);
        Weighted_Node n1 = new Weighted_Node(g,10,1);
        Weighted_Node n2 = new Weighted_Node(g,10,2);
        Weighted_Node n3 = new Weighted_Node(g,10,3);
        Weighted_Node n4 = new Weighted_Node(g,10,4);
        Weighted_Node n5 = new Weighted_Node(g,10,5);
        g.addEdge(n1,n2,2);
        g.addEdge(n2,n3,3);
        g.addEdge(n1,n4,1);
        g.addEdge(n4,n5,1);
        g.addEdge(n5,n3,1);
        g.print();
        //System.out.println(g.getNumNodes());
        System.out.println("shortest length from n1 -> n3 is " + g.findShortestPath(n1, n3));
        g.print();

    }
}
