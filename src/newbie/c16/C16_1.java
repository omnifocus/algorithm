package newbie.c16;

import java.util.Arrays;

/**
 * 对数器
 * 可用来调错
 */
public class C16_1 {
    public static void main(String[] args) {

        int runtimes = 100000;
        int maxLen = 10;
        int maxValue = 100;
        for (int i=0;i<runtimes;i++) {
           int[] arr =  genRandomArray(maxLen,maxValue);
           int[] originArr = arr;
            bubbleSort(arr);
            if (!isSorted(arr)) {
                System.out.print("原arr如下： ");
                System.out.println(Arrays.toString(originArr));
                System.out.print("排序后的arr如下： ");
                System.out.println(Arrays.toString(arr));
                break;
            }

        }
    }

    private static void bubbleSort(int[] arr) {
        for (int i=arr.length-1;i>=0;i--) {
            for (int second = 1; second <= i;second++) {
                if (arr[second] < arr[second-1]) {
                    swap(arr,second,second-1);
                }
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private static int[]  genRandomArray(int maxLen, int maxValue) {
        int L = (int)(Math.random() * maxLen);
        int[] arr = new int[L];
        for (int i=0;i<L;i++) {
            int V = (int)(Math.random() * maxValue);
            arr[i] = V;
        }
        return arr;
    }

    private static boolean isSorted(int[] arr) {
        if (arr.length < 2)
            return true;
        int max = arr[0];
        for (int i=1;i<arr.length;i++) {
         if (max > arr[i]) {
          return false;
         }
         max = arr[i];
        }
        return true;
    }



}
