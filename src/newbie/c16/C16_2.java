package newbie.c16;

import java.util.Arrays;

/**
 * 对数器
 * 可用来调错,有一个实际的例子（控制最大长度）
 */
public class C16_2 {
    public static void main(String[] args) {

        int runtimes = 1000000;
        int maxLen = 10;
        int maxValue = 100;
        for (int i=0;i<runtimes;i++) {
            int [] arr = genRandomArr(maxLen,maxValue);
            if (i <= 10) {
                System.out.println("arr: " + Arrays.toString(arr));
            }
            insertSort(arr);
            if (i <= 10) {
                System.out.println("after sorted arr: " + Arrays.toString(arr));
            }
            if ( !isSorted(arr)) {
                System.out.println("error");
                break;
            }
        }
    }

    private static int[] genRandomArr(int maxLen, int maxValue) {
        int L = (int)(Math.random() * maxLen);
        int[] arr = new int[L];
        for (int j=0;j<L;j++) {
            int V = (int)(Math.random() * maxValue);
            arr[j] = V;
        }
        return arr;
    }


    private static void insertSort(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            for (int j=i-1; j>=0 && arr[j] > arr[j+1];j--) {
                swap(arr,j,j+1);
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    private static boolean isSorted(int[] arr) {
        if (arr == null || arr.length < 2)
            return true;
        int pre = arr[0];
        for (int i=1;i<arr.length;i++) {
            if (arr[i] < pre) {
                return false;
            }
            pre = arr[i];
        }
        return true;
    }

}
