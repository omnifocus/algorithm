package newbie.c5;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class C5 {
    public static void main(String[] args) {
        int[] arr = new int[] {1,4,5,7,3,2,6,9};
        System.out.println("before:" + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("after:" + Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // i 如果等于1，表还有两个数
        for (int i=arr.length-1;i>0;i--) {
            for (int j=0;j<i;j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr,j,j+1);
                }
            }
        }

    }
    private static void swap(int[] arr, int k, int i) {
        int tmp = arr[k];
        arr[k] = arr[i];
        arr[i] = tmp;
    }
}
