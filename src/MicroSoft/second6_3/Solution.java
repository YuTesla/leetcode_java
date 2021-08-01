package MicroSoft.second6_3;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        int[] data={1,2,3,4,5,5,4,7,8,6,1,2,3,4,56,14,1,1,4,4};
        int[] data={1,5,4,5,711001,12,132165,13151};
        int num=data.length-1;
        double baifenwei=0.8;
//        int index=(int)(num*baifenwei);
//        int target=data[index];


        if(data.length==0){
            System.out.println("数组为空");
            return;
        }
        int offset=(int)(data.length*baifenwei);
//        System.out.println(offset);
        //错误1：百分位*数组长度=0
        if(offset==0){
            offset=1;
        }
        int[] help=help=copyArr(data,0,offset);
        Arrays.sort(help);
        int[] tmp=new int[offset];
//        System.out.println(data.length/help.length);
        for(int i=1;i<data.length/help.length;i++){
            tmp=copyArr(data,i*offset,offset);
            Arrays.sort(tmp);
            help=campare(help,tmp);
        }
        if(data.length% help.length!=0){
            int[] tail=new int[data.length% help.length];
            tail=copyArr(data,data.length/help.length*offset,data.length% help.length);
            Arrays.sort(tail);
            help=campare(help,tail);
        }

        System.out.println(help[help.length-1]);




    }

    public static int[] copyArr(int[] arr,int start,int offset){
        int[] tmp=new int[offset];
        for(int i=0;i<offset;i++){
            tmp[i]=arr[start+i];
        }
        return tmp;
    }

    public static int[] campare(int[] arr1,int[] arr2){
        int index1=0,index2=0,index=0;
        int[] tmp=new int[arr1.length];
        while (index<tmp.length){
            if(arr1[index1]>arr2[index2]){
                tmp[index++]=arr2[index2++];
            }else{
                tmp[index++]=arr1[index1++];
            }
            if(index1==arr1.length||index2==arr2.length)break;
        }
        if(index!=tmp.length){
            while(index<tmp.length&&index1<arr1.length){
                tmp[index++]=arr1[index1++];
            }
            while(index<tmp.length&&index2<arr2.length){
                tmp[index++]=arr2[index2++];
            }
        }
        return tmp;
    }

//    public static void main(String[] args) {
//        int[] d1={1,2,3,4};
//        int[] d2={0,1,22};
//        for(int num:campare(d1,d2)){
//            System.out.println(num);
//        }
//    }

}
