package newbie.c18;

import java.util.Arrays;

/*
找到有序数组中大于等于某个数的最左数

 */
public class C18_Stub1_1 {
    public static void main(String[] args) {
        test(10,5,100000);
    }

    private static void test(int maxL,int maxV,int maxCount) {
        for (int i=0;i<maxCount;i++) {

            int[] arr = genRandomArray(maxL, maxV);
            int tofind = (int)(Math.random() * maxV);

            if (i <= 10 && (stupidM(arr,tofind) == findMostLeftNum(arr,tofind)) ) {
                System.out.println("当前数组: " + Arrays.toString(arr) +"  , tofind: " + tofind + ", 位置为：" + stupidM(arr,tofind));
            }

            if (stupidM(arr,tofind) != findMostLeftNum(arr,tofind)) {
                System.out.println("error: ");
                System.out.print("当前数组: " + Arrays.toString(arr) +"  , tofind: " + tofind);
                break;
            }
        }
    }

    //TODO
    private static int findMostLeftNum(int[] arr, int tofind) {
        int L = 0;
        int R = arr.length-1;
        int prev = -1;
        while (L <= R) {
            int M = R - ((R-L)>>2);
            if (arr[M] >= tofind) {
                prev = M;
                R = M-1;
            } else {
                L = M+1;
            }

        }
        return prev;
    }

    private static int stupidM(int[] arr, int tofind) {
        if (arr == null || arr.length == 0)
            return -1;
        for (int i=0;i<arr.length;i++) {
            if (arr[i] >= tofind){
                return i;
            }
        }
        return -1;
    }

    private static int[] genRandomArray(int maxL, int maxV) {
        int L = (int)(Math.random() * maxL);
        int[] arr = new int[L];
        for (int i=0;i<L;i++) {
            int V = (int)(Math.random() * maxV);
            arr[i] = V;
        }
        Arrays.sort(arr);
        return arr;
    }

}
