package leetcode.mid56mergeIntervals;

import java.util.Arrays;


class Solution {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] res = new int[intervals.length][2];
        int idx=-1;
        for(int [] inter:intervals){
            if(idx<0||inter[0]>res[idx][1]){
                res[++idx]=inter;
            }else{
                res[idx][1]=Math.max(inter[1],res[idx][1]);
            }
        }

        return Arrays.copyOf(res, idx + 1);
    }

    public static void main(String[] args) {

    }
}
