package leetcode.easy26removeDuplicates;

class Solution {
    public int removeDuplicates(int[] nums) {
        int leng=nums.length;
        if(leng<2)return leng;
        int start=0;
        int end=1;
        while(end<leng){
            if(nums[end]==nums[start]){
                end++;
            }else{
                nums[++start]=nums[end];
            }
        }
        return ++start;
    }
}