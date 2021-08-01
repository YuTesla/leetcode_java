package leetcode.utils.Graph;

import java.util.ArrayList;

public class Node {
    public int id;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;
    public Node(int id){
        this.id=id;
        in=0;
        out=0;
        nexts=new ArrayList<>();
        edges=new ArrayList<>();
    }
}
