package leetcode.mid18fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        int leng=nums.length;
        for(int i=0;i<leng-3;i++){
            if(i>0&&nums[i]==nums[i-1])continue;
            for(int j=i+1;j<leng-2;j++){
                if(j>i+1&&nums[j]==nums[j-1])continue;
                int left=j+1;
                int right=leng-1;
                while(left<right){
                    if(left>j+1&&nums[left]==nums[left-1]){
                        left++;
                        continue;
                    }
                    if(right<leng-1&&nums[right]==nums[right+1]){
                        right--;
                        continue;
                    }
                    if(nums[i]+nums[j]+nums[left]+nums[right]==target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                    }else if(nums[i]+nums[j]+nums[left]+nums[right]>target){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return res;
    }
}