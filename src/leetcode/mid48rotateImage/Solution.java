package leetcode.mid48rotateImage;

public class Solution {
    public void rotate(int[][] matrix) {
        int len=matrix.length;
        int tmp=0;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<(len>>1);j++){
                tmp=matrix[i][j];
                matrix[i][j]=matrix[i][len-j-1];
                matrix[i][len-j-1]=tmp;
            }
        }
    }
}
