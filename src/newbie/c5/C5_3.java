package newbie.c5;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class C5_3 {
    public static void main(String[] args) {
        int[] arr = new int[] {1,4,5,7,3,2,6,9};
        System.out.println("before:" + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("after:" + Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        int N = arr.length;
        // 0~N-1, 0~N-2; 0~N-3...0~1
        for (int i = N-1; i>=0 ; i--) {
            // 0 vs 1  1 vs 2  2 vs 3 ... N-2 vs N-1
            // 0 vs 1  1 vs 2  2 vs 3 ... N-3 vs N-2
            // ...
            // 0 vs 1
            for (int second = 1; second <= i; second ++) {
                if (arr[second-1] > arr[second]) {
                    swap(arr,second,second-1);
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
