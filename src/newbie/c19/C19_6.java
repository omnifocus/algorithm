package newbie.c19;

import java.util.Arrays;

/**
 * 局部最小值
 * 相邻两数不等，整体无序
 * 求既比左边(如果有)小又比右边（如果有）小的数
 */
public class C19_6 {
    public static void main(String[] args) {

        int count = 1000000;
        int maxL = 20;
        int maxV = 50;
        System.out.println("start");
        for (int i = 0; i < count; i++) {
            int[] arr = genRandomNotEqualBetweenArr(maxL,maxV);
            int index = findOneMin(arr);
            if (!check(arr,index)) {
                System.out.println("error: arr " + Arrays.toString(arr)  + " index " + index);
                break;
            }
        }
        System.out.println("end");


    }


    private static int[] genRandomNotEqualBetweenArr(int maxL, int maxV) {
        int L = (int)(Math.random() * maxL);

        int [] arr = new int[L];

        if (L >0) {
            arr[0]  = (int)(Math.random() * maxV); ;
            for (int i=1;i<L;i++) {
                do {
                    arr[i] = (int)(Math.random() * maxV);

                } while (arr[i] == arr[i-1]);
            }
        }

        return arr;
    }


    private static boolean check(int[] arr, int index) {
        if ( arr == null || arr.length <= 0) {
            return  index == -1;
        }
        int leftIndex = index-1;
        int rightIndex = index+1;
        boolean leftBigger = leftIndex >= 0 ? arr[leftIndex] > arr[index] : true;
        boolean rightBigger = rightIndex < arr.length ? arr[index] < arr[rightIndex] : true;
        return leftBigger && rightBigger;
    }


    private static int findOneMin(int[] arr) {
        if (arr == null || arr.length <= 0 )
            return -1;

        int L = arr.length;
        if (L == 1) {
            return 0;
        }

        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[L-1] < arr[L-2]) {
            return L-1;
        }

        int Start = 0;
        int End = L-1;

        while (Start < End -1) {
            int M = End - ((End - Start) >> 1);
            if (arr[M] < arr[M-1] && arr[M] < arr[M+1]) {
                return M;
            }
            if (arr[M] > arr[M-1]) {
                End = M-1;
                continue;
            }

            if (arr[M] > arr[M+1]) {
                Start = M+1;
                continue;
            }

        }

        return arr[Start] < arr[End] ? Start : End;
    }


}
