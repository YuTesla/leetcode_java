package meituan.shixi5_9;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class four {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] grid=new int[n][m];
        String ss=sc.nextLine();
        for(int i=0;i<n;i++){
            String s=sc.nextLine();
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='*'){
                    grid[i][j]=1;
                }
            }
        }
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                System.out.print(grid[i][j]);
//            }
//            System.out.println();
//        }
//        boolean[][] ifvisit=new boolean[n][m];
//        int res=dfs(grid,0,0,n,m,0,ifvisit,1);
//        System.out.println(res);
        Deque<int[]> q=new ArrayDeque<>();
        int[][] dir=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        q.offer(new int[] {0,0,0});
        boolean[][][] ifvisit=new boolean[n][m][2];
        ifvisit[0][0][0]=true;
        for(int s=0,sz;(sz=q.size())>0;s++){
            while(--sz>=0){
                int[] p=q.poll();
                if(p[0]==n-1&&p[1]==m-1){
                    System.out.println(s);
                    return;
                }
                for(int[] d:dir){
                    int x=p[0]+d[0],y=p[1]+d[1],e=p[2];
                    if(x<0||x>=n||y<0||y>=m)continue;
                    if(grid[x][y]==1){
                        if(++e>1)continue;
                    }
                    if(ifvisit[x][y][e])continue;
                    q.offer(new int[]{x,y,e});
                    ifvisit[x][y][e]=true;
                }
            }
        }
        System.out.println(-1);
    }

    public static int dfs(int[][] grid,int i,int j,int n,int m,int len,boolean[][] ifvisit,int flag){
        if(i<0||i>=n||j<0||j>=m)return Integer.MAX_VALUE;
        if(i==n-1&&j==m-1)return len;
        if(ifvisit[i][j])return Integer.MAX_VALUE;
        if(grid[i][j]==1){
            if(flag==1)flag--;
            else return Integer.MAX_VALUE;
        }

        ifvisit[i][j]=true;

        int minl=Integer.MAX_VALUE;
        minl=Math.min(minl,dfs(grid,i-1,j,n,m,len+1,ifvisit,flag));
        minl=Math.min(minl,dfs(grid,i+1,j,n,m,len+1,ifvisit,flag));
        minl=Math.min(minl,dfs(grid,i,j+1,n,m,len+1,ifvisit,flag));
        minl=Math.min(minl,dfs(grid,i,j-1,n,m,len+1,ifvisit,flag));

        ifvisit[i][j]=false;
        return minl;
    }
}
