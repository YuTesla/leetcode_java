package leetcode.hard5longestPalindromicSubstring;

public class Solution {
    public String longestPalindrome(String s) {
        char[] str=s.toCharArray();
        int len=str.length;
        boolean[][] dp=new boolean [len][len];
        for(int i=0;i<len;i++){
            dp[i][i]=true;
            if(i>0){
                dp[i-1][i]=str[i]==str[i-1];
            }
        }
        for(int j=2;j<len;j++){
            for(int i=0;i<j-1;i++){
                dp[i][j]=dp[i+1][j-1]&&(str[i]==str[j]);
            }
        }
        int res=0;
        int[] index=new int[2];
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(dp[i][j]&&j-i+1>res){
                    res=j-i+1;
                    index=new int[]{i,j};
                }
            }
        }
        return s.substring(index[0],index[1]+1);
    }

    public static void main(String[] args) {
        Solution sou=new Solution();
        sou.longestPalindrome("babad");
    }
}
