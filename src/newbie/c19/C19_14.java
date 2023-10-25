package newbie.c19;

import java.util.Arrays;

/**
 * 局部最小值
 * 相邻两数不等，整体无序
 * 求既比左边(如果有)小又比右边（如果有）小的数
 */
public class C19_14 {

    public static void main(String[] args) {

        int count = 1000000;
        int maxL = 10;
        int maxV = 100;
        System.out.println("start");
        for (int i = 0; i < count; i++) {
            int[] arr = genRandomNotEqualBetweenArr(maxL, maxV);
            int index = findOneMin(arr);
            if (i <= 10) {
                System.out.println("当前的index：" + index + ",当前的arr：" + Arrays.toString(arr));
            }
            if (!check(arr, index)) {
                System.out.println("当前的index：" + index + ",当前的arr：" + Arrays.toString(arr));
                break;
            }
        }
        System.out.println("end");


    }


    private static int[] genRandomNotEqualBetweenArr(int maxL, int maxV) {
        int L = (int) (Math.random() * maxL);
        int[] arr = new int[L];
        if (L > 0) {
            arr[0] = (int) (Math.random() * maxV);
            for (int i = 1; i < L; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxV);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }
    private static boolean check(int[] arr, int index) {

        if (arr == null || arr.length == 0)
            return index == -1;
        int leftIndex = index - 1;
        int rightIndex = index + 1;
        boolean leftBigger = leftIndex >= 0 ? arr[leftIndex] > arr[index] : true;
        boolean rightBigger = rightIndex < arr.length ? arr[rightIndex] > arr[index] : true;
        return leftBigger && rightBigger;

    }


    private static int findOneMin(int[] arr) {
        if (arr == null || arr.length <= 0) return -1;
        if (arr.length == 1) return 0;
        if (arr.length == 2) return  arr[0] < arr[1] ? 0 : 1;
        int L = 0;
        int R = arr.length-1;

        while (L < R -1) {
            int M = R - ((R-L)>>1);
            if (arr[M] < arr[M-1] && arr[M] < arr[M+1])    {
                return M;
            }
            if (arr[M]> arr[M-1]) {
                R = M-1;
                continue;
            }
            if (arr[M] > arr[M+1]) {
                L = M+1;
                continue;
            }
        }
        return arr[L] < arr[R] ? L : R;

    }


}
