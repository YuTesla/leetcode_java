package leetcode.mid15threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        if(n<3)return res;
        int i=0;
        while(i<n-2){
            if(nums[i]>0)return res;
            while(i>0&&i<n-2&&nums[i]==nums[i-1])i++;
            if(i==n-2)return res;
            int l=i+1;
            int r=n-1;
            while(l<r){
                if(nums[i]+nums[l]+nums[r]==0){

                    List<Integer> tmp=new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[l]);
                    tmp.add(nums[r]);
                    res.add(tmp);
                    l++;
                    while(l<r&&nums[l]==nums[l-1])l++;
                    r--;
                    while(l<r&&nums[r]==nums[r+1])r--;
                }else if(nums[i]+nums[l]+nums[r]>0)r--;
                else l++;
            }
            i++;
        }
        return res;
    }
}
