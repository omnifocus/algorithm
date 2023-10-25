package newbie.c19;


import newbie.c16.C16;

import java.util.Arrays;

/**
 * 局部最小值
 * 相邻两数不等，整体无序
 * 求既比左边(如果有)小又比右边（如果有）小的数
 */
public class C19 {
    public static void main(String[] args) {

        int count = 10000000;
        System.out.println("start");
        for ( int i=0;i<count;i++ ) {
            int[] arr = C16.genRandomArr2(10,200);
            int index = findOneMin2(arr);
            if (!check(arr,index)) {
                System.out.println(Arrays.toString(arr));

                System.out.println("error:" + index);
                break;
            }
        }
        System.out.println("end");


    }

    private static boolean check(int[] arr, int index) {
//        System.out.println(Arrays.toString(arr) + "----" + index);
        int leftIndex = index -1;
        int rightIndex = index + 1;
        boolean leftCon = leftIndex >= 0 ? arr[leftIndex] > arr[index] : true;
        boolean righCon = rightIndex < arr.length ? arr[rightIndex] > arr[index] : true;
        return leftCon && righCon;
    }

    private static int findOneMin(int[] arr) {

        if (arr == null || arr.length == 0) {
            return -1;
        }
        //只有一个数，就返回0位置
        if (arr.length == 1) {
            return  0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        int len = arr.length;
        if (arr[len-2] > arr[len-1]) {
            return len-1;
        }


        // 排除掉首尾，边界问题
        int L = 1;
        int R = len - 2;

        while (L <= R) {
            int M = L + ((R-L) >> 2);
            if (arr[M] < arr[M-1] && arr[M] < arr[M+1]) {
                return M;
            }
            if (arr[M] < arr[M-1]) {
                L = M + 1;
            } else {
                R = M - 1;
            }
        }





        return -1;

    }


    private static int findOneMin2(int[] arr) {

        if (arr == null || arr.length == 0) {
            return -1;
        }
        //只有一个数，就返回0位置
        if (arr.length == 1) {
            return  0;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        int len = arr.length;
        if (arr[len-2] > arr[len-1]) {
            return len-1;
        }


        int L = 0;
        int R = len - 1;

        //保证至少有三个数，否则如果边界落到最起始位置或最后位置，此时-1 | +1就会有问题
        while (L < R-1) {
            int M = L + ((R-L) >> 2);
            if (arr[M] < arr[M-1] && arr[M] < arr[M+1]) {
                return M;
            }
            if (arr[M] < arr[M-1]) {
                L = M + 1;
            } else {
                R = M - 1;
            }
        }
        //一定是极端情况，抛物线 峰底在下
        return arr[L] < arr[R] ? L : R;

    }

}
