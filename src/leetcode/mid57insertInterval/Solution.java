package leetcode.mid57insertInterval;

import java.util.Arrays;

public class Solution {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        //1.先加进来再仿照56合并区间
//        int len=intervals.length;
//        int[][] res=new int[len+1][2];
//        for(int i=0;i<len;i++){
//            res[i]=intervals[i];
//        }
//        res[len]=newInterval;
//
//        int[][] ans=res;
//        Arrays.sort(res,(l1, l2)->l1[0]-l2[0]);
//        int idx=-1;
//        for(int j=0;j<len+1;j++){
//            if(idx==-1||res[j][0]>ans[idx][1]){
//                ans[++idx]=res[j];
//            }else{
//                ans[idx][1]=Math.max(ans[idx][1],res[j][1]);
//            }
//        }
//        return Arrays.copyOf(ans,idx+1);

        int len = intervals.length;
        if (len < 1) return new int[][]{newInterval};
        int[][] res = new int[len + 1][2];
        int idx = 0;
        int i = 0;
        while (i < len && intervals[i][1] < newInterval[0]) {
            res[idx++] = intervals[i++];
        }
        while (i < len && (intervals[i][1] > newInterval[0] || intervals[i][0] < newInterval[1])) {
            res[idx][0] = Math.min(intervals[i][0], newInterval[0]);
            res[idx][1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        idx++;
        while (i < len) {
            res[idx++] = intervals[i++];
        }
        return Arrays.copyOf(res, idx);

//        int[][] res = new int[intervals.length + 1][2];
//        int idx = 0;
//        // 遍历区间列表：
//        // 首先将新区间左边且相离的区间加入结果集
//        int i = 0;
//        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
//            res[idx++] = intervals[i++];
//        }
//        // 接着判断当前区间是否与新区间重叠，重叠的话就进行合并，直到遍历到当前区间在新区间的右边且相离，
//        // 将最终合并后的新区间加入结果集
//        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
//            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
//            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
//            i++;
//        }
//        res[idx++] = newInterval;
//        // 最后将新区间右边且相离的区间加入结果集
//        while (i < intervals.length) {
//            res[idx++] = intervals[i++];
//        }
//
//        return Arrays.copyOf(res, idx);
    }

//    public static void main(String[] args) {
//        System.out.println(insert(new int[][]{[1,3],[6,9]}));
//    }
}
