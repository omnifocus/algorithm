package newbie.c6;

import java.util.Arrays;

/**
 * 插入排序
 */
public class C6 {
    public static void main(String[] args) {
        int[] arr = new int[] {1,4,5,7,3,2,6,9};
        System.out.println("before:" + Arrays.toString(arr));
        insertSort(arr);
        System.out.println("after:" + Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        for (int i=1;i<arr.length;i++) {
            int k = i;
            while (k>0 && arr[k] < arr[k-1]) {
                swap(arr,k,k-1);
                k--;
            }
        }
    }

    private static void swap(int[] arr, int k, int i) {
        int tmp = arr[k];
        arr[k] = arr[i];
        arr[i] = tmp;
    }
}
