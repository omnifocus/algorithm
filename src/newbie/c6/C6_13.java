package newbie.c6;

import java.util.Arrays;

/**
 * 插入排序
 */
public class C6_13 {
    public static void main(String[] args) {
        int[] arr = new int[] {1,4,5,7,3,2,6,9};
        System.out.println("before:" + Arrays.toString(arr));
        insertSort(arr);
        System.out.println("after:" + Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            for (int j=i-1; j>=0 && arr[j] > arr[j+1];j--) {
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
