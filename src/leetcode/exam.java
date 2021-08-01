package leetcode;

import java.util.Scanner;

//package leetcode;
//import java.util.Arrays;
//public class exam {
//
//
//
//        // 开时测试
//        public static void main(String[] args) {
//            int testTime = 500000;	//	总测试数
//            int maxSize = 100;		//	单次测试数量
//            int maxValue = 100;		//	单词测试数值最大值
//            boolean succeed = true;	//	测试是否成功
//            for (int i = 0; i < testTime; i++) {
//                int[] arr1 = generateRandomArray(maxSize, maxValue);	//	数组一
//                int[] arr2 = copyArray(arr1);	//	数组二
//                selectionSort(arr1);	//	算法一
//                comparator(arr2);		//	算法二
//                if (!isEqual(arr1, arr2)) {	//	校验一致性
//                    succeed = false;
//                    printArray(arr1);	//	不一致则打印
//                    printArray(arr2);	//	不一致则打印
//                    break;
//                }
//            }
//            System.out.println(succeed ? "Nice!" : "Fucking fucked!");
//
//            //	int[] arr = generateRandomArray(maxSize, maxValue);
//            //	printArray(arr);
//            //	selectionSort(arr);
//            //	printArray(arr);
//        }
//
//
//        // 	生成随机数组
//        public static int[] generateRandomArray(int maxSize, int maxValue) {
//            // Math.random()   [0,1)
//            // Math.random() * N  [0,N)
//            // (int)(Math.random() * N)  [0, N-1]
//            int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
//            for (int i = 0; i < arr.length; i++) {
//                // [-? , +?]
//                arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
//            }
//            return arr;
//        }
//
//        // 	复制数组
//        public static int[] copyArray(int[] arr) {
//            if (arr == null) {
//                return null;
//            }
//            int[] res = new int[arr.length];
//            for (int i = 0; i < arr.length; i++) {
//                res[i] = arr[i];
//            }
//            return res;
//        }
//
//
//        // 校验是否一致
//        public static boolean isEqual(int[] arr1, int[] arr2) {
//            if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
//                return false;
//            }
//            if (arr1 == null && arr2 == null) {
//                return true;
//            }
//            if (arr1.length != arr2.length) {
//                return false;
//            }
//            for (int i = 0; i < arr1.length; i++) {
//                if (arr1[i] != arr2[i]) {
//                    return false;
//                }
//            }
//            return true;
//        }
//
//        // 打印数组
//        public static void printArray(int[] arr) {
//            if (arr == null) {
//                return;
//            }
//            for (int i = 0; i < arr.length; i++) {
//                System.out.print(arr[i] + " ");
//            }
//            System.out.println();
//        }
//
//    }
//
//}
public class exam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String n = sc.next();
            System.out.println(n);
        }
    }
//public static void main(String[] args) {
//    Scanner in = new Scanner(System.in);
//    while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//        int a = in.nextInt();
//        int b = in.nextInt();
//        System.out.println(a + b);
//    }
//}
}

