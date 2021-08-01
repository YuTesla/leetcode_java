package leetcode.hard44wildcardMatching;

import javax.sound.midi.Soundbank;

public class Solution {
    //1.递归
//    int n=0;
//
//    public boolean isMatch(String s, String p) {
//        char[] str=s.toCharArray();
//        char[] exp=p.toCharArray();
//        return f(str,exp,0,0);
//
//    }
//
//    private boolean f(char[] str,char[] exp,int i,int j){
//        if(j==exp.length){
//            return i==str.length;
//        }
//        if(i==str.length){
//            return exp[j]=='*'&&f(str,exp,i,j+1);
//        }
//        if(exp[j]!='*'){
//            deb(n++);
//            System.out.printf("i=%d,j=%d\n",i,j);
//
//            boolean ans=(exp[j]==str[i]||exp[j]=='?')&&f(str,exp,i+1,j+1);
//
//            deb(--n);
//            System.out.println(String.valueOf(ans));
//            return ans;
//        }
//        while(i<str.length){
//            deb(n++);
//            System.out.printf("i=%d,j=%d,while\n",i,j);
//            boolean ans=f(str,exp,i,j+1);
//            deb(--n);
//            System.out.println(String.valueOf(ans));
//            if(ans){
//                return true;
//            }
//            i++;
//        }
//        System.out.println("end");
//        return f(str,exp,i,j+1);
//    }

    //2.dp
    public boolean isMatch(String s, String p) {
        char[] str=s.toCharArray();
        char[] exp=p.toCharArray();
        int m=str.length;
        int n=exp.length;
        boolean[][] dp=new boolean [m+1][n+1];
        dp[m][n]=true;
        int k=n-1;
        while(k>=0&&exp[k]=='*'){
            if(dp[m][k+1])dp[m][k]=true;
            else break;
            k--;
        }
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(exp[j]!='*')dp[i][j]=(exp[j]==str[i]||exp[j]=='?')&&dp[i+1][j+1];
                else{
                    int tmp=i;
                    while(tmp<=m){
                        if(dp[tmp][j+1]){
                            dp[i][j]=true;
                            break;
                        }
                        tmp++;
                    }
                    if(!dp[i][j])dp[i][j]=dp[i][j+1];
                }
            }
        }
        return dp[0][0];

    }

    private void deb(int n){
        for(int i=0;i<n;i++){
            System.out.printf("\t");
        }
    }

    public static void main(String[] args) {
        Solution sou = new Solution();
        System.out.println(sou.isMatch("aa","*"));

    }
}
