package offer.easy13reOrderArray;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param array int整型一维数组 
     * @return int整型一维数组
     */
//    public int[] reOrderArray (int[] array) {
//        // write code here
//        int index=-1;
//        for(int i=0;i<array.length;i++){
//            if(array[i]%2==1){
//                insert(array,index,i);
//                index++;
//            }
//        }
//        return array;
//    }
//
//    public void swap(int[] arr,int i,int j){
//        int tmp=arr[i];
//        arr[i]=arr[j];
//        arr[j]=tmp;
//    }
//
//    public void insert(int[] arr,int index,int i){
//        for(int j=i;j>index+1;j--){
//            swap(arr,j-1,j);
//        }
//    }

    public int[] reOrderArray (int[] array) {
        // write code here
        Deque<Integer> ji=new ArrayDeque<>();
        Deque<Integer> ou=new ArrayDeque<>();
        for(int i:array){
            if(i%2==1)ji.offer(i);
            else ou.offer(i);
        }
        int index=0;
        while(!ji.isEmpty()){
            array[index++]=ji.pop();
        }
        while(!ou.isEmpty()){
            array[index++]=ou.pop();
        }
        return array;
    }
}