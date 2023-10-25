package newbie.c6;

import java.util.Arrays;

/**
 * 插入排序
 */
public class C6_4 {
    public static void main(String[] args) {
        int[] arr = new int[] {1,4,5,7,3,2,6,9};
        System.out.println("before:" + Arrays.toString(arr));
        insertSort(arr);
        System.out.println("after:" + Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        for (int i=0;i<arr.length;i++) {
            // 往后难，就往前判断
//            for (int j=i+1;  j >= 1 && arr[j] < arr[j-1] ; j--) {
//                swap(arr,j,j-1);
//            }

            for (int j=i-1; j >= 0 && arr[j] > arr[j+1] ;j --) {
                swap(arr,j,j+1);
            }
        }
    }

    private static void swap(int[] arr, int k, int i) {
        int tmp = arr[k];
        arr[k] = arr[i];
        arr[i] = tmp;
    }
}
