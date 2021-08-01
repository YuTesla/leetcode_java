package leetcode.mid15threeSumClosest;

import java.util.Arrays;

public class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        //1.暴力
//        int res=nums[0]+nums[1]+nums[2];
//        int leng=nums.length;
//        for(int i=0;i<leng-2;i++){
//            for(int j=i+1;j<leng-1;j++){
//                for(int k=j+1;k<leng;k++){
//                    if(Math.abs(res-target)>Math.abs(nums[i]+nums[j]+nums[k]-target)){
//                        res=nums[i]+nums[j]+nums[k];
//                    }
//                }
//            }
//        }
//        return res;
        //2.自己的双指针
        Arrays.sort(nums);
        int res=nums[0]+nums[1]+nums[2];
        int leng=nums.length;
        for(int i=0;i<leng-2;i++){
            int left=i+1;
            int right=leng-1;
            while(left<right){
                if(nums[i]+nums[left]+nums[right]==target){
                    return nums[i]+nums[left]+nums[right];
                }
                else if(nums[i]+nums[left]+nums[right]>target){
                    if(nums[i]+nums[left]+nums[right]-target<Math.abs(res-target)){
                        res=nums[i]+nums[left]+nums[right];
                    }
                    right--;
                }else{
                    if(target-(nums[i]+nums[left]+nums[right])<Math.abs(res-target)){
                        res=nums[i]+nums[left]+nums[right];
                    }
                    left++;
                }
            }
        }
        return res;
        //3.题解双指针
//        Arrays.sort(nums);
//        int ans = nums[0] + nums[1] + nums[2];
//        for(int i=0;i<nums.length;i++) {
//            int start = i+1, end = nums.length - 1;
//            while(start < end) {
//                int sum = nums[start] + nums[end] + nums[i];
//                if(Math.abs(target - sum) < Math.abs(target - ans))
//                    ans = sum;
//                if(sum > target)
//                    end--;
//                else if(sum < target)
//                    start++;
//                else
//                    return ans;
//            }
//        }
//        return ans;

    }

    public static void main(String[] args) {
        int[] nums={-1,2,1,-4};
        int target=1;
        System.out.println(threeSumClosest(nums,target));
    }
}
