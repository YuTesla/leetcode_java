package leetcode.utils.Graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Prim {


    public static HashSet<Edge> prim(Graph graph){
        HashSet<Edge> edgeset=new HashSet<>();
        HashSet<Node> nodeset=new HashSet<>();
        PriorityQueue<Edge> q=new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.w-o2.w;
            }
        });

        HashSet<Edge> res=new HashSet<>();
        for(Node node:graph.nodes.values()){

            if(!nodeset.contains(node)){
                nodeset.add(node);
                for(Edge edge:node.edges){
                    if(!edgeset.contains(edge)){
                        edgeset.add(edge);
                        q.add(edge);
                    }
                }
            }

            while(!q.isEmpty()){
                Edge edge=q.poll();
                Node toNode=edge.to;
                if(!nodeset.contains(toNode)){
                    res.add(edge);
                    nodeset.add(toNode);
                    for(Edge newedge:toNode.edges){
                        if(!edgeset.contains(newedge)){
                            edgeset.add(newedge);
                            q.add(newedge);
                        }
                    }
                }
            }

            break;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] g=new int[][]{
                {1,3,1},{1,2,8},{1,4,15},{2,3,2},{3,4,7},{2,5,10},{3,5,3},{3,6,12},{4,6,3},{5,6,4}
        };
        Graph graph=new Graph();
        graph.createUndirectedGraph(g);
        HashSet<Edge> res=Prim.prim(graph);
        for(Edge edge:res){
            System.out.printf("%d  %d  w=%d\n",edge.from.id,edge.to.id,edge.w);
        }
    }
}
