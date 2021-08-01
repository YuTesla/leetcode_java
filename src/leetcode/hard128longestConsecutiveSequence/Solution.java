package leetcode.hard128longestConsecutiveSequence;


import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int ans=0;
        int res=0;
        for(int num:set){
            ans=0;
            if(!set.contains(num-1)){
                int cur=num;
                while(set.contains(cur)){
                    ans++;
                    res=Math.max(ans,res);
                    cur++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sou=new Solution();
        System.out.println(sou.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
