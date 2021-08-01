package leetcode.mid55jumpGame;

public class Solution {
    public boolean canJump(int[] nums) {
        //1.顺推 O(n^2) 299ms
//        boolean[] ifarrived=new boolean[nums.length];
//        ifarrived[0]=true;
//        for(int i=0;i<nums.length;i++){
//            if(ifarrived[i]){
//                for(int j=0;j<=nums[i];j++){
//                    if(i+j>=nums.length)return true;
//                    ifarrived[i+j]=true;
//                }
//            }
//        }
//        return ifarrived[nums.length-1];

        //2.逆推 O(n) 1ms(也可以顺推直接贪心)
        int right=nums.length-1;
        if(right==0)return true;
        for(int i=nums.length-1;i>=0;i--){
            if(right-i<=nums[i])right=i;
        }
        return right==0;
    }
}
