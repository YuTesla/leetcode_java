package offer.mid13movingCount;

public class Solution {
    public int movingCount(int m, int n, int k) {
        if(k==0)return 1;
        int[][] ans=new int[m][n];
        ans[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(ans[i][j]==1){
                    if(i+1<m&&bytesum(i+1,j)<=k){
                        ans[i+1][j]=1;
                    }
                    if(j+1<n&&bytesum(i,j+1)<=k){
                        ans[i][j+1]=1;
                    }
                }
            }
        }
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res+=ans[i][j];
            }
        }
        return res;
    }

    public int bytesum(int i,int j){
        int tmp=0;
        while(i!=0){
            tmp+=i%10;
            i=i/10;
        }
        while(j!=0){
            tmp+=j%10;
            j=j/10;
        }
        return tmp;
    }
}
