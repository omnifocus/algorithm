package newbie.c5;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class C5_Stub {
    public static void main(String[] args) {
        int[] arr = new int[] {1,4,5,7,3,2,6,9};
        System.out.println("before:" + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("after:" + Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {


    }
    private static void swap(int[] arr, int k, int i) {
        int tmp = arr[k];
        arr[k] = arr[i];
        arr[i] = tmp;
    }
}
