package Graph.Weighted_Graph;
/**
 * Created by Daniel on 19/08/2014.
 */
public class Weighted_Node {
    private int curWeight;
    private Weighted_Node curNode;
    private Weighted_Edge[] edges;
    private int numEdges;
    private int secretNum;

    public Weighted_Node(Weighted_Graph g,int maxSize, int num) {
        g.addNode(this);
        curWeight = 0;
        edges = new Weighted_Edge[maxSize];
        this.numEdges = 0;
        this.secretNum = num;
    }
    public Weighted_Node(Weighted_Edge[] edges){
        curWeight = 0;
        this.edges = edges;
    }
    public void addEdge(Weighted_Edge e){
        edges[numEdges++] = e;
    }
    public void addEdge(Weighted_Graph g,Weighted_Node n, int weight){
        Weighted_Edge e = new Weighted_Edge(g,this, n, weight);
        this.addEdge(e);
        n.addEdge(e);
    }
    public int getCurWeight(){
        return curWeight;
    }
    public Weighted_Edge[] getEdges(){
        return edges;
    }
    @Override
    public String toString(){
        return secretNum + " " + curWeight;
    }

    public void setCurWeight(int curWeight) {
        this.curWeight = curWeight;
    }

    public void setCurNode(Weighted_Node curNode) {
        this.curNode = curNode;
    }
    public Weighted_Node getCurNode(){
        return this.curNode;
    }
}
