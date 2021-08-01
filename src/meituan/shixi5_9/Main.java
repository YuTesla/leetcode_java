package meituan.shixi5_9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] ws=new int[26];
        for(int i=0;i<26;i++){
            ws[i]=sc.nextInt();
        }
        String ss=sc.nextLine();
        String s=sc.nextLine();
        String t=sc.nextLine();

        int sw=0;
        for(int i=0;i<s.length();i++){
            sw+=ws[s.charAt(i)-'a'];
        }
        int tw=0;
        for(int i=0;i<s.length();i++){
            tw+=ws[t.charAt(i)-'a'];
        }

    }

}
