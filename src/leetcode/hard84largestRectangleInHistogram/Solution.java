package leetcode.hard84largestRectangleInHistogram;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
//    public int largestRectangleArea(int[] heights) {
        //1.dp 超出内存限制
//        int len=heights.length;
//        int[][] dp=new int[len][len];
//        for(int i=0;i<len;i++)dp[i][i]=heights[i];
//        for(int i=0;i<len;i++){
//            for(int j=i+1;j<len;j++){
//                dp[i][j]=Math.min(dp[i][j-1],heights[j]);
//            }
//        }
//        int res=0;
//        for(int i=0;i<len;i++){
//            for(int j=i;j<len;j++){
//                res=Math.max((j-i+1)*dp[i][j],res);
//            }
//        }
//        return res;

        //2.暴力   超时
        // int len=heights.length;
        // int res=0;
        // for(int i=0;i<len;i++){
        //     int w=1;
        //     for(int j=i-1;j>=0&&heights[j]>=heights[i];j--){
        //         w++;
        //     }
        //     for(int j=i+1;j<len&&heights[j]>=heights[i];j++){
        //         w++;
        //     }
        //     res=Math.max(res,heights[i]*w);
        // }
        // return res;
//    }

    //3.单调栈
    public int largestRectangleArea(int[] heights) {
        int[] h=new int[heights.length+2];
        for(int i=0;i<heights.length;i++){
            h[i+1]=heights[i];
        }
        h[0]=-1;
        int res=0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        stack.push(1);
        for(int i=2;i<h.length;i++){
            while(!stack.isEmpty()&&h[i]<h[stack.peek()]){
                int lasth=stack.pop();
                res=Math.max(res,h[lasth]*(i-stack.peek()-1));
            }
            stack.push(i);
//            for(int j:stack) System.out.printf("%d\t",h[j]);
//            System.out.println();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sou=new Solution();
        sou.largestRectangleArea(new int[]{2,1,5,6,2,3});

    }
}
