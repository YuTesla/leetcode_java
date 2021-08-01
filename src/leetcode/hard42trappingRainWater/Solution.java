package leetcode.hard42trappingRainWater;

public class Solution {
    //1.自己的递归 2ms
//    private int n=0;
//    public int trap(int[] height) {
//        int n=height.length;
//        if(n<2)return 0;
//        int[] max=maxarr(height,0,n-1);
//        return f(height, 0,max[0])+f(height,max[0],n-1);
//    }
//    private int[] maxarr(int[] height,int left,int right){
//        int max=0;
//        int index=1;
//        if(right<left)return new int[]{-1,-1};
//        for(int i=left;i<=right;i++){
//            if(height[i]>max){
//                max=height[i];
//                index=i;
//            }
//        }
//        int max2=0;
//        int index2=-1;
//        for(int i=left;i<=right;i++){
//            if(height[i]>max2&&i!=index){
//                max2=height[i];
//                index2=i;
//            }
//        }
//        return new int[]{index,index2};
//    }
//
//    private int sum(int[] height,int left,int right,int maxh){
//        int ans=0;
//        while(left<=right){
//            ans+=(maxh>height[left]?maxh-height[left]:0);
//            left++;
//        }
//        return ans;
//    }
//
//    private int f(int[] height,int left,int right){
//        if(right-left<=1)return 0;
//        int[] max=maxarr(height,left,right);
//        if(max[0]<0||max[1]<0)return 0;
//        if(max[0]>max[1]){
//            int ans=sum(height,max[1],max[0],height[max[1]]);
//
//            deb(n++);
//            System.out.printf("left=%d,right=%d,max2_index=%d,ans=%d,maxh=%d\n",left,right,max[1],ans,height[max[1]]);
//            int tmp=f(height,left,max[1]);
//            deb(--n);
//            System.out.printf("res=%d\n",ans+tmp);
//            return ans+tmp;
//        }else {
//            int ans = sum(height, max[0], max[1], height[max[1]]);
//
//            deb(n++);
//            System.out.printf("left=%d,right=%d,max2_index=%d,ans=%d,maxh=%d\n", left, right, max[1], ans, height[max[1]]);
//            int tmp = f(height, max[1],right);
//            deb(--n);
//            System.out.printf("res=%d\n", ans + tmp);
//            return ans + tmp;
//
//        }
//    }

    //2.暴力求每一列 103ms
//    public int trap(int[] height) {
//        int n=height.length;
//        if(n<3)return 0;
//        int res=0;
//        for(int i=1;i<n-1;i++){
//            int h=Math.min(maxarr(height,0,i-1),maxarr(height,i+1,n-1));
//            res+=h>height[i]?h-height[i]:0;
//            System.out.printf("i=%d,h=%d\n",i,h>height[i]?h-height[i]:0);
//        }
//        return res;
//    }
//    private int maxarr(int[] height,int left,int right){
//        if(right-left<0)return -1;
//        int max=0;
//        for(int i=left;i<=right;i++){
//            if(height[i]>max){
//                max=height[i];
//            }
//        }
//        return max;
//    }

    //3.dp求每一列
//    public int trap(int[] height) {
//        int n=height.length;
//        if(n<3)return 0;
//        int res=0;
//        int[] dp_l=new int[n];
//        int[] dp_r=new int[n];
//        for(int i=1;i<n-1;i++){
//            dp_l[i]=Math.max(dp_l[i-1],height[i-1]);
//        }
//        for(int i=n-2;i>0;i--){
//            dp_r[i]=Math.max(dp_r[i+1],height[i+1]);
//        }
//        for(int i=1;i<n-1;i++){
//            int h=Math.min(dp_l[i],dp_r[i]);
//            res+=h>height[i]?h-height[i]:0;
//        }
//        return res;
//    }

    //4.双指针 https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/327718/
    public int trap(int[] height) {
        int n=height.length;
        if(n<3)return 0;
        int res=0;
        int left=0,right=n-1;
        int maxleft=0,maxright=0;
        while(left<=right){
            if(maxleft<maxright){
                res+=Math.max(maxleft-height[left],0);
                maxleft=Math.max(maxleft,height[left]);
                System.out.printf("left=%d,maxleft=%d,res+%d\n",left,maxleft,Math.max(maxleft-height[left],0));
                left++;
            }else{
                res+=Math.max(maxright-height[right],0);
                maxright=Math.max(maxright,height[right]);
                System.out.printf("right=%d,maxright=%d,res+%d\n",right,maxright,Math.max(maxright-height[right],0));
                right--;
            }
        }
        return res;
    }

    private void deb(int n){
        for(int i=0;i<n;i++){
            System.out.printf("\t");
        }
    }

    public static void main(String[] args) {
        Solution sou=new Solution();
        System.out.println(sou.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
