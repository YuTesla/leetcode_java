package offer.mid12existPath;

class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.equals(""))return true;
        int m=board.length,n=board[0].length;
        boolean[][] used = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board,word,i,j,0,used,m,n))return true;

                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board,String word,int i,int j,int index,boolean[][] used,int m,int n){
        if(i<0||i>=m||j<0||j>=n)return false;
        if(used[i][j]||index>word.length())return false;
        if(word.charAt(index)==board[i][j]){
            if(index==word.length()-1)return true;
            else{
                used[i][j]=true;
                boolean res=dfs(board,word,i+1,j,index+1,used,m,n)||
                        dfs(board,word,i-1,j,index+1,used,m,n)||
                        dfs(board,word,i,j+1,index+1,used,m,n)||
                        dfs(board,word,i,j-1,index+1,used,m,n);
                used[i][j]=false;
                return res;
            }
        }else{
            return false;
        }

    }

//    public static void main(String[] args) {
//        char[][] board=new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
//        exist(board,"ABCESEEEFS");
//    }
}