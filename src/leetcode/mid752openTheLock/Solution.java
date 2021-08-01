package leetcode.mid752openTheLock;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    //未完成的dfs
//    int[] dp=new int[10000];
//    public int minSteps(String[] deadends,String target){
//
//        for(String s:deadends){
//            dp[Integer.parseInt(s)]=-1;
//        }
//        if(dp[0]<0)return 0;
//
//        return -1;
//
//    }
//
//    private int dfs(int current,int target,int steps){
//        if(current==target){
//            return steps;
//        }
//    }

    //dong的bfs
    String plusOne(String s,int j){
        char[] ch=s.toCharArray();
        if(ch[j]=='9'){
            ch[j]='0';
        }else{
            ch[j]+=1;
        }
        return new String(ch);
    }

    String minusOne(String s,int j){
        char[] ch=s.toCharArray();
        if(ch[j]=='0'){
            ch[j]='9';
        }else{
            ch[j]-=1;
        }
        return new String(ch);
    }

//    void BFS(String target){
//        Queue<String> q=new LinkedList<>();
//        q.offer('0000');
//
//        while(!q.isEmpty()){
//            int sz=q.size();
//            for(int i=0;i<sz;i++){
//                String cur=q.poll();
//                System.out.println(cur);
//
//                for(int j=0;j<4;j++){
//                    String up=plusOne(cur,j);
//                    String down=minusOne(cur,j);
//                    q.offer(up);
//                    q.offer(down);
//                }
//            }
//        }
//    }

    int openLock(String[] deadends,String target){
        Set<String> deads=new HashSet<>();
        for(String s:deadends)deads.add(s);

        Set<String> visited=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        int step=0;
        q.offer("0000");
        visited.add("0000");

        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                String cur=q.poll();
//                System.out.println(cur);
                if(deads.contains(cur))continue;
                if(cur.equals(target))return step;

                for(int j=0;j<4;j++){
                    String up=plusOne(cur,j);
                    System.out.printf("up=%s\n",up);
                    if(!visited.contains(up)){
                        q.offer(up);
                        visited.add(up);
                    }
                    String down=minusOne(cur,j);
                    System.out.printf("down=%s\n",down);
                    if(!visited.contains(down)){
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sou=new Solution();
        sou.openLock(new String[]{"8888"},"0009");
    }
}
