package leetcode.utils.Graph;

public class Edge {
    public int w;
    public Node from;
    public Node to;
    public Edge(Node from,Node to,int w){
        this.from=from;
        this.to=to;
        this.w=w;
    }
}
