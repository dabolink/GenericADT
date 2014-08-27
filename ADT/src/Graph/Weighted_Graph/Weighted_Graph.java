package Graph.Weighted_Graph;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Daniel on 19/08/2014.
 */
public class Weighted_Graph {
    private Weighted_Node[] nodes;
    private Weighted_Edge[] edges;
    private int NumNodes, NumEdges;

    public Weighted_Graph(int MaxNodes) {
        NumNodes = 0;
        NumEdges = 0;
        nodes = new Weighted_Node[MaxNodes];
        edges = new Weighted_Edge[MaxNodes * MaxNodes];
    }

    public void addNode(Weighted_Node n) {
        if (!this.contains(n)) {
            nodes[NumNodes++] = n;
        }
    }

    public void addEdge(Weighted_Edge e) {
        edges[NumEdges++] = e;
        if (!this.contains(e.getNode1())) {
            nodes[NumNodes++] = e.getNode1();
        }
        if (!this.contains(e.getNode2())) {
            nodes[NumNodes++] = e.getNode2();
        }
    }

    public void addEdge(Weighted_Node n1, Weighted_Node n2, int weight) {
        Weighted_Edge e = new Weighted_Edge(this, n1, n2, weight);
    }

    public boolean contains(Weighted_Node n1, Weighted_Node n2) {
        for (Weighted_Edge e : edges) {
            if (e != null) {
                if ((e.getNode1() == n1 && e.getNode2() == n2) || (e.getNode1() == n2 && e.getNode2() == n1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean contains(Weighted_Node n2) {
        for (Weighted_Node n : nodes) {
            if (n == n2) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        System.out.println("graph");
        for (int i = 0; i < NumNodes; i++) {
            for (int j = 0; j < NumNodes; j++) {
                if (contains(nodes[i], nodes[j])) {
                    System.out.print(" 1 |");
                } else {
                    System.out.print(" 0 |");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Nodes:");
        for (Weighted_Node n : nodes) {
            if (n != null) {
                System.out.print(n.toString() + '\t');
            }
        }
        System.out.println();
        System.out.println("Edges: ");
        for (Weighted_Edge e : edges) {
            if (e != null) {
                System.out.print(e.toString() + '\t');
            }
        }
        System.out.println();
    }
    /* Dijkstra's algorithm */
    public int findShortestPath(Weighted_Node n1, Weighted_Node n2) {
        Weighted_Node[] permanentNodes = new Weighted_Node[NumNodes];
        Weighted_Node[] NP = new Weighted_Node[NumNodes];
        int i = 0;
        for(Weighted_Node n: nodes) {
            if (n != null){
                NP[i++] = n;
            }
        }
        Weighted_Node workingNode = n1;
        NP = remove(NP,workingNode);
        permanentNodes[0] = workingNode;
        int permNodes = 1;
        for (Weighted_Node n : nodes) {
            if (n != null && n != workingNode) {
                n.setCurWeight(-1);
                n.setCurNode(null);
            }
        }
        n1.setCurWeight(0);
        // n2 not in perm
        //System.out.println("NP");
        //printArray(NP);
        //System.out.println("perm");
        //printArray(permanentNodes);
        while (!contains(permanentNodes,n2)) {
            //System.out.println("working " + workingNode.toString());
            if(workingNode == null){
                System.out.println("error?");
                break;
            }
            Weighted_Edge[] nodeEdges = workingNode.getEdges();
            for (i = 0; i < nodeEdges.length; i++) {
                Weighted_Node curNode;
                if (nodeEdges[i] != null) {
                    if (nodeEdges[i].getNode1() != workingNode) {
                        curNode = nodeEdges[i].getNode1();
                    } else {
                        curNode = nodeEdges[i].getNode2();
                    }
                    int dw = workingNode.getCurWeight() + nodeEdges[i].getWeight();
                    if (curNode.getCurWeight() > dw || curNode.getCurWeight() == -1) {
                        curNode.setCurWeight(dw);
                        curNode.setCurNode(workingNode);
                    }
                }
            }
            //select new working node
            workingNode = null;
            for(Weighted_Node n: NP){
                if(workingNode == null && n != null) {
                    if (n.getCurWeight() != -1) {
                        workingNode = n;
                    }
                }else{
                    if(n != null){
                        if(workingNode.getCurWeight() > n.getCurWeight() && n.getCurWeight() != -1){
                            workingNode = n;
                        }
                    }
                }
            }
            //System.out.println("new working" + workingNode.toString());
            permanentNodes[permNodes++] = workingNode;
            NP = remove(NP, workingNode);
            //System.out.println("NP");
            //printArray(NP);
            //System.out.println("perm");
            //printArray(permanentNodes);
        }
        System.out.println();
        return workingNode.getCurWeight();
    }

    private void printArray(Weighted_Node[] array) {
        for(Weighted_Node n: array){
            if(n!=null){
                System.out.println(n.toString());
            }
        }
    }

    private Weighted_Node[] remove(Weighted_Node[] array, Weighted_Node node) {
        for(int i = 0; i < array.length; i++){
            if(array[i] == node){
                array[i] = null;
                break;
            }
        }
        return array;
    }

    private boolean contains(Weighted_Node[] array, Weighted_Node node) {
        for(Weighted_Node n: array){
            if(n == node){
                return true;
            }
        }
        return false;
    }

    public int getNumNodes() {
        return this.NumNodes;
    }
}
