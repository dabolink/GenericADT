package Graph.Weighted_Graph;

public class Weighted_Edge {
    private int weight;
    private Weighted_Node[] nodes = new Weighted_Node[2];
    public Weighted_Edge(Weighted_Graph g, Weighted_Node n1, Weighted_Node n2, int w) {
        nodes[0] = n1;
        nodes[1] = n2;
        this.weight = w;
        g.addEdge(this);
        n1.addEdge(this);
        n2.addEdge(this);
    }
    public int getWeight(){
        return weight;
    }
    public void setWeight(int w){
        this.weight = w;
    }
    public void setNode1(Weighted_Node n){
        nodes[0] = n;
    }
    public void setNode2(Weighted_Node n){
        nodes[1] = n;
    }
    public Weighted_Node getNode1(){
        return nodes[0];
    }
    public Weighted_Node getNode2(){
        return nodes[1];
    }
    @Override
    public String toString(){
        return nodes[0].toString() + " " + nodes[1].toString() + " " + this.weight;
    }
}
