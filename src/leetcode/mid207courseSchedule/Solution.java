package leetcode.mid207courseSchedule;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //1.使用二维数组存储adj
//        int[][] adj=new int[numCourses][numCourses];
//        Deque<Integer> q=new ArrayDeque<>();
//        int[] indegree=new int[numCourses];
//        // for(int i=0;i<numCourses;i++){
//        //     adj[i]=new ArrayList<Integer>();
//        // }
//        int course=numCourses;
//
//        for(int[] path:prerequisites){
//            adj[path[1]][path[0]]=1;
//            indegree[path[0]]++;
//        }
//
//        for(int i=0;i<numCourses;i++){
//            if(indegree[i]==0){
//                q.offer(i);
//                course--;
//            }
//        }
//        while(!q.isEmpty()){
//            int node=q.poll();
//            for(int i=0;i<numCourses;i++){
//                if(adj[node][i]==1){
//                    indegree[i]--;
//                    // adj[node][i]--;
//                    if(indegree[i]==0){
//                        q.offer(i);
//                        course--;
//                    }
//                }
//            }
//        }
//
//        return course==0;


        //2.使用AyayList存储adj
        List<ArrayList<Integer>> adj=new ArrayList<>();
        Deque<Integer> q=new ArrayDeque<>();
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }
        int course=numCourses;

        for(int[] path:prerequisites){
            adj.get(path[1]).add(path[0]);
            indegree[path[0]]++;
        }

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.poll();
            course--;
            for(int j:adj.get(node)){
                if(--indegree[j]==0){
                    q.offer(j);
                }
            }
        }

        return course==0;
    }


    public static void main(String[] args) {
        canFinish(5,new int[][]{{1,4}, {2,4},{3,1}, {3,2}});
    }
}