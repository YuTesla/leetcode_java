package leetcode.mid75sortColors;

public class Solution {
    public void sortColors(int[] nums) {
        int slow=0,fast=0;
        //先排0
        int tmp=0;
        while(fast<nums.length){
            if(nums[fast]==0){
                tmp=nums[slow];
                nums[slow]=0;
                nums[fast]=tmp;
                slow++;
            }
            fast++;
        }
        slow=nums.length-1;
        fast=nums.length-1;
        //排2
        while(fast>=0){
            if(nums[fast]==2){
                tmp=nums[slow];
                nums[slow]=2;
                nums[fast]=tmp;
                slow--;
            }
            fast--;
        }
    }
}
