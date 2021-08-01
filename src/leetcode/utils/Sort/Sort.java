package leetcode.utils.Sort;

public class Sort {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        if (n < 2) return;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void selectSort(int[] arr) {
        int n = arr.length;
        if (n < 2) return;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE, index = 0;
            for (int j = i; j < n; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            swap(arr, i, index);
        }
    }

    public static void insertSort(int[] arr) {
        int n = arr.length;
        if (n < 2) return;
        for (int i = 1; i < n; i++) {
//            for(int j=i;j>0;j--){
//                if(arr[j]<arr[j-1]){
//                    swap(arr,j,j-1);
//                }
//            }
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n < 2) return;
        mergeSort(arr, 0, n - 1);
    }

    public static void mergeSort(int[] arr, int L, int R) {
        if (R == L) return;
        int mid = ((R - L) >> 1) + L;
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int[] num = new int[R - L + 1];
        int p1 = L, p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= R) {
            num[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }
        while (p1 <= mid) {
            num[i++] = arr[p1++];
        }
        while (p2 <= R) {
            num[i++] = arr[p2++];
        }
        for (int j = 0; j < R - L + 1; j++) {
            arr[L + j] = num[j];
        }
    }


    public static void quickSort(int[] arr) {
        int n = arr.length;
        if (n < 2) return;
        quickSort(arr, 0, n - 1);
    }

    public static void quickSort(int[] arr, int L, int R) {
        if (L >= R) return;
        int[] p = partition(arr, L, R);
        quickSort(arr, p[1] + 1, R);
        quickSort(arr, L, p[0] - 1);
    }

    public static int[] partition(int[] arr, int L, int R) {
//        int num=arr[R];
        //随机快排
        int num = arr[(int) (Math.random() * (R - L)) + L];
        int less = L - 1, more = R + 1;
        while (L < more) {
            if (arr[L] < num) {
                swap(arr, L++, ++less);
            } else if (arr[L] > num) {
                swap(arr, L, --more);
            } else {
                L++;
            }
        }
        return new int[]{less + 1, more - 1};
    }


    public static void heapSort(int[] arr) {
        int n = arr.length;
        if (n < 2) return;
        for(int i=0;i<n;i++){
            heapInsert(arr,i);
        }
        int heapsize=n;
        swap(arr,--heapsize,0);
        while(heapsize>0){
            heapify(arr,0,heapsize);
            swap(arr,--heapsize,0);
        }

    }

    public static void heapInsert(int[] arr, int index) {
        if (index >= arr.length) return;
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int heapsize) {
        if (index >= heapsize) return;
        int left = index * 2 + 1;
        while (left < heapsize) {
            int largest = left + 1 < heapsize && arr[left + 1] > arr[left] ?
                    left + 1 : left;
            largest = arr[index] > largest ? index : largest;
            if (index == largest) break;
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

//    public static int[] partition(int[] arr, int l, int r) {
//        int less = l - 1;
//        int more = r;
//        while (l < more) {
//            if (arr[l] < arr[r]) {
//                swap(arr, ++less, l++);
//            } else if (arr[l] > arr[r]) {
//                swap(arr, --more, l);
//            } else {
//                l++;
//            }
//        }
//        swap(arr, more, r);
//        return new int[] { less + 1, more };
//    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 2, 5, 1};
//        int[] arr = new int[]{4, 3, 2, 5, 1, 6, 8, 9, 7, 6};
//        bubbleSort(arr);
//        selectSort(arr);
//        insertSort(arr);
//        partition(arr,0,4);
//        quickSort(arr);
//        mergeSort(arr);
        heapSort(arr);
        for (int num : arr) System.out.println(num);
    }
}
