package Tencent.shixi4_18;

import java.util.Arrays;
import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for(int numsOfTest=0;numsOfTest<T;numsOfTest++){
            int n=sc.nextInt();
            Game[] games=new Game[n];
            int allscores=0;
            int maxtime=0;
            for(int i=0;i<n;i++){
                games[i]=new Game();
                games[i].time=sc.nextInt();
                maxtime=Math.max(games[i].time,maxtime);
            }
            for(int i=0;i<n;i++){
                int s=sc.nextInt();
                games[i].score=s;
                allscores+=s;
            }
            Arrays.sort(games,(g1, g2)->g2.score-g1.score);
            int timestep=maxtime;
            int curtime=games[0].time;
            int maxscore=0;
            while(timestep>=0){
                for(int i=0;i<games.length;i++){
                    if(games[i].time>=timestep){
                        allscores-=games[i].score;
                        games[i].time=-1;
                        break;
                    }
                }

                timestep--;
            }
            System.out.print(allscores);
            if(numsOfTest<T-1)System.out.println();
        }

    }

}
class Game{
    public int time;
    public int score;
}