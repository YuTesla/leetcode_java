package nonghang.shixi_6_4;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
//        for(int num:getSeq(18,4)){
//            System.out.println(num);
//        }
        for(String s:specify_sort(new String[]{"abc123","abc+1234","ababab--1"})){
            System.out.println(s);
        }
    }

    public static int get_year_gap(int[] data_A,int[] data_B){
        int year=0;
        double GDP_A=data_A[0],GDP_B=data_B[0];
        double grow_A=data_A[1],grow_B=data_B[1];
        double po_A=data_A[2],po_B=data_B[2];
        double po_grow_A=data_A[3],po_grow_B=data_B[3];
        while(GDP_A/po_A>GDP_B/po_B){
            GDP_A*=(1+grow_A);
            GDP_B*=(1+grow_B);
            po_A*=(1+po_grow_A);
            po_B*=(1+po_grow_B);
            year++;
        }
        return year;
    }

    public static String[] specify_sort(String[] words){
        if(words.length==0)return words;
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                double num_letter1=0,num_letter2=0,num_num1=0,num_num2=0;
                for(int i=0;i<o1.length();i++){
                    if(Character.isDigit(o1.charAt(i))){
                        num_num1++;
                    }
                    if(Character.isLetter(o1.charAt(i))){
                        num_letter1++;
                    }
                }
                for(int i=0;i<o2.length();i++){
                    if(Character.isDigit(o2.charAt(i))){
                        num_num2++;
                    }
                    if(Character.isLetter(o2.charAt(i))){
                        num_letter2++;
                    }
                }
                double div1=num_letter1/num_num1,div2=num_letter2/num_num2;
                if(div1>div2){
                    return -1;
                }else if(div1<div2){
                    return 1;
                }else{
                    return o2.compareTo(o1);
                    //return o1.compareTo(o2);
                }
            }
        });
        return words;

    }

    public static int[] getSeq(int num,int n){
        int[] res=new int[n];
        if(n==0)return res;
        if((num-(int)(0.5*n*(n-1)))%n==0){
            int a=(num-(int)(0.5*n*(n-1)))/n;
            for(int i=0;i<n;i++){
                res[i]=a+i;
            }
            return res;
        }else{
            return new int[]{};
        }
    }

}
