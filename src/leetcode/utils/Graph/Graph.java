package leetcode.utils.Graph;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;
    public Graph(){
        nodes=new HashMap<>();
        edges=new HashSet<>();
    }

    //图的数据是(from,to,weight)的形式给出
    public void createDirectedGraph(int[][] g){
        for(int[] e:g){
            if(!nodes.containsKey(e[0])){
                nodes.put(e[0],new Node(e[0]));
            }
            if(!nodes.containsKey(e[1])){
                nodes.put(e[1],new Node(e[1]));
            }
            Node from=nodes.get(e[0]);
            Node to=nodes.get(e[1]);
            Edge newedge=new Edge(from,to,e[2]);
            from.out++;
            to.in++;
            from.edges.add(newedge);
            from.nexts.add(to);
            edges.add(newedge);
        }
    }

    public void createUndirectedGraph(int[][] g){
        for(int[] e:g){
            if(!nodes.containsKey(e[0])){
                nodes.put(e[0],new Node(e[0]));
            }
            if(!nodes.containsKey(e[1])){
                nodes.put(e[1],new Node(e[1]));
            }
            Node from=nodes.get(e[0]);
            Node to=nodes.get(e[1]);
            Edge newedge1=new Edge(from,to,e[2]);
            Edge newedge2=new Edge(to,from,e[2]);
            from.out++;
            from.in++;
            to.in++;
            to.out++;
            from.edges.add(newedge1);
            from.edges.add(newedge2);
            from.nexts.add(to);
            to.nexts.add(from);
            edges.add(newedge1);
            edges.add(newedge2);
        }
    }
}
