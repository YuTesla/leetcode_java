package TongHuaShun;

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumNum(1,3));
    }

    public static long sumNum(int b,int n){
        long res=0;
        for(int i=0;i<n;i++){
            res+=b*(n-i)*Math.pow(10,i);
        }
        return res;
    }
}
