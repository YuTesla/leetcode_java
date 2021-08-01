package offer.easy21IsPopOrder;

import java.util.ArrayList;

import java.util.Stack;

public class Solution {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        int n=pushA.length;
        if(n<1)return true;
        Stack<Integer> s=new Stack<>();

        int index=0;
        for(int i=0;i<n;i++){
            if(s.isEmpty()||s.peek()!=popA[i]){
                while(pushA[index]!=popA[i]){
                    if(index>=n)return false;
                    s.push(pushA[index]);
                    index++;

                }
                s.push(pushA[index++]);
            }
            s.pop();
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(IsPopOrder(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
    }
}