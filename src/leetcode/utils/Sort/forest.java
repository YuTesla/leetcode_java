//package leetcode.utils.Sort;
//
//public class forest {
//    public static void swap(int[] arr,int i,int j){
//        int tmp=arr[i];
//        arr[i]=arr[j];
//        arr[j]=tmp;
//    }
//
//    public static void bubbleSort(int[] arr){
//        int n=arr.length;
//        if(n<2)return;
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n-i-1;j++){
//                if(arr[j+1]<arr[j])swap(arr,j,j+1);
//            }
//        }
//    }
//
//    public static void bubbleSort5_25(int[] arr){
//        if(arr==null||arr.length<2)return;
//        for(int i=0;i<arr.length;i++){
//            for(int j=0;j<arr.length-i-1;j++){
//                if(arr[j]>arr[j+1])swap(arr,j,j+1);
//            }
//        }
//    }
//    //冒泡排序无法通过简单的合并判断条件做到和插入排序一样的复杂度，因为插入排序是到那里就停了，而冒泡可能还要接着排后面的
//    public static void bubbleSort_GY(int[] arr){
//        int n=arr.length;
//        if(n<2)return;
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n-i-1&&arr[j+1]<arr[j];j++){
//                swap(arr,j,j+1);
//            }
//        }
//    }
//
//    public static void insertSort(int[] arr){
//        int n=arr.length;
//        if(n<2)return;
//        for(int i=0;i<n-1;i++) {
//            for(int j=i;j>=0&&arr[j+1]<arr[j];j--) {
//                swap(arr, j, j + 1);
//            }
//        }
//    }
//
//    public static void insertSort5_25(int[] arr){
//        if(arr==null||arr.length<2)return;
//        for(int i=0;i<arr.length-1;i++){
//            for(int j=i+1;j>0&&arr[j]<arr[j-1];j--){
//                swap(arr,j,j-1);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] arr=new int[]{4,3,2,5,1};
////        bubbleSort(arr);
////        selectSort(arr);
////        insertSort(arr);
////        bubbleSort_GY(arr);
////        partition(arr,0,4);
//        insertSort5_25(arr);
//        for(int num:arr) System.out.println(num);
//    }
//}
