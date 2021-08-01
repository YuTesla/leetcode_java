package Tencent.shixi4_18;
import java.util.Scanner;
import java.util.*;
public class two {


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int T=sc.nextInt();
            for(int numsOfTest=0;numsOfTest<T;numsOfTest++){
                int n=sc.nextInt();
                Game[] games=new Game[n];
                int allscores=0;
                for(int i=0;i<n;i++){
                    games[i]=new Game();
                    games[i].time=sc.nextInt();
                }
                for(int i=0;i<n;i++){
                    int s=sc.nextInt();
                    games[i].score=s;
                    allscores+=s;
                }
                Arrays.sort(games,(g1,g2)->g1.time-g2.time);
                int index=0;
                int curtime=games[0].time;
                int maxscore=0;
                while(index<n){
                    maxscore=Math.max(maxscore,games[index].score);
                    if(index==n-1||games[index+1].time!=games[index].time){
                        allscores-=maxscore;
                        maxscore=0;
                    }
                    index++;
                }
                System.out.println(allscores);
            }

        }



}
