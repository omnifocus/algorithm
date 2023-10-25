package newbie.c17;

import algorithm.newbie.c16.C16;

import java.util.Arrays;

/**
 * 二分
 */
public class C17 {
    public static void main(String[] args) {
        int len = 80;
        int maxV = 100;
        int count = 100000;

        for (int i=0;i<count;i++) {
            int[] arr = C16.genRandomArr(len,maxV);
            Arrays.sort(arr);
            int[] arr2 = C16.copyArr(arr);
            int tofind = (int)(Math.random() * maxV);
            System.out.println(Arrays.toString(arr) + "---" + tofind);
            if (! (findNum(arr,tofind) == findNum2(arr,tofind))) {
                System.out.println("error: arr:" + Arrays.toString(arr) + " tofind" + tofind);
                break;
            }
        }
    }



    private static int findNum(int[] arr, int tofind) {
        int L = 0;
        int R = arr.length-1;

        while (L <= R) {
            int M = ((R - L) >> 2) + L;
            if (arr[M] == tofind) {
                return M;
            }
            if (arr[M] > tofind) {
                R = M - 1;
            } else {
                L = M + 1;
            }
        }
        return -1;
    }

    private static int findNum2(int[] arr, int tofind) {
        for (int i=0;i<arr.length;i++) {
            if (arr[i] == tofind) {
                return i;
            }
        }
        return -1;
    }
}
