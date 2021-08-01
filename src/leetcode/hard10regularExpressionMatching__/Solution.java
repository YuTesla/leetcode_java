package leetcode.hard10regularExpressionMatching__;

public class Solution {
    //1.暴力递归
//    public boolean isMatch(String s, String p) {
//        char[] str=s.toCharArray();
//        char[] exp=p.toCharArray();
//        return f(str,exp,0,0);
//    }
//
//    private boolean f(char[] str,char[] exp,int i,int j){
//        if(j==exp.length){
//            return i==str.length;
//        }
//        if(j==exp.length-1||exp[j+1]!='*'){
//            return i<str.length&&(exp[j]==str[i]||exp[j]=='.')&&f(str,exp,i+1,j+1);
//        }
//
//        while(i<str.length&&(exp[j]==str[i]||exp[j]=='.')){
//            if(f(str,exp,i,j+2)){
//                return true;
//            }
//            i++;
//        }
//        return f(str,exp,i,j+2);
//    }

    //2.改的dp
    public boolean isMatch(String s, String p) {
        char[] str=s.toCharArray();
        char[] exp=p.toCharArray();
        int m=str.length;
        int n=exp.length;
        boolean[][] dp=new boolean [m+1][n+1];
        initdp(dp,m,n,str,exp);
        if(n==1)return dp[0][0];
        for(int j=n-2;j>=0;j--){
            for(int i=m-1;i>=0;i--){
                if(exp[j+1]!='*')dp[i][j]=((exp[j]==str[i]||exp[j]=='.')&&dp[i+1][j+1]);
                else{
                    int k=i;
                    while(k<m&&(exp[j]==str[k]||exp[j]=='.')){
                        if(dp[k][j+2]){
                            dp[i][j]=true;
                            break;
                        }
                        k++;
                    }
                    if(!dp[i][j])dp[i][j]=dp[k][j+2];
                }
            }
        }
        return dp[0][0];
    }

    private void initdp(boolean[][] dp,int m,int n,char[] str,char[] exp){
        dp[m][n]=true;
        if(m>0&&n>0)dp[m-1][n-1]=(exp[n-1]==str[m-1]||exp[n-1]=='.');
        for(int j=n-2;j>=0;j=j-2){
            if(exp[j]!='*'&&exp[j+1]=='*')dp[m][j]=true;
            else break;
        }
    }
}
