package leetcode.hard72editDistance;

public class Solution {
    public int minDistance(String word1, String word2) {
        char[] s1=word1.toCharArray();
        char[] s2=word2.toCharArray();
        int l1=s1.length;
        int l2=s2.length;
        int[][] dp=new int[l1+1][l2+1];
        for(int i=0;i<=l1;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=l2;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(s1[i-1]==s2[j-1])dp[i][j]=dp[i-1][j-1];
                else dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
            }
        }
        return dp[l1][l2];
    }
}
