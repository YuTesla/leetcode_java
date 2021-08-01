package leetcode.mid238productOfArrayExceptSelf;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        //1.两个辅助数组  O(n) O(n)
//        int n=nums.length;
//        if(n<2)return nums;
//        int[] L=new int[n];
//        int[] R=new int[n];
//        L[0]=nums[0];
//        R[n-1]=nums[n-1];
//        for(int i=1;i<n;i++){
//            L[i]=nums[i]*L[i-1];
//        }
//        for(int i=n-2;i>=0;i--){
//            R[i]=nums[i]*R[i+1];
//        }
//        int[] res=new int[n];
//        res[0]=R[1];
//        res[n-1]=L[n-2];
//        for(int i=1;i<n-1;i++){
//            res[i]=L[i-1]*R[i+1];
//        }
//        return res;

        //2. 使用输出数组作为辅助数组，将另一个辅助数组用一个整型来代替 O(n) O(1)
        int n=nums.length;
        if(n<2)return nums;
        int[] res=new int[n];
        int R=1;
        res[0]=nums[0];
        for(int i=1;i<n;i++){
            res[i]=nums[i]*res[i-1];
        }
        for(int i=n-1;i>0;i--){
            res[i]=res[i-1]*R;
            R=R*nums[i];
        }
        res[0]=R;

        return res;
    }
}
