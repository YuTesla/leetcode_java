package leetcode.easy69sqrtx;

public class Solution {
    public int mySqrt(int x) {
        //1.数学方法 x^0.5=e^(0.5lnx)
//        int ans=(int)Math.exp(0.5*Math.log(x));
//        return (long)(ans+1)*(ans+1)>x?ans:(ans+1);

        //2.牛顿法
        if(x==0)return 0;
        double x0=x;
        int C=x;
        double x1=0.5*(x0+C/x0);
        while(true){
            if(Math.abs(x0-x1)<1e-7)break;
            double x2=0.5*(x1+C/x1);
            x0=x1;
            x1=x2;
        }
        int res=(int)x1;
        return (long)res*res>x?res-1:res;
    }
}
