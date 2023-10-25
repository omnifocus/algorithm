package newbie.c19;

import java.util.Arrays;

/**
 * 局部最小值
 * 相邻两数不等，整体无序
 * 求既比左边(如果有)小又比右边（如果有）小的数
 *
 * 自己写的有问题不完善版本
 */
public class C19_self {
    public static void main(String[] args) {

        int count = 10000000;
        System.out.println("start");
//        int[] arr = new int[]{4, 2, 3, 2, 3, 1, 0, 4, 2};
//        findOneMin(arr);
        for ( int i=0;i<count;i++ ) {
            int[] arr = genRandomNotEqualBetweenArr(50,100);
            int index = findOneMin(arr);
            if (!check(arr,index)) {
                System.out.println("arr: " + Arrays.toString(arr) + "; index: " + index);
                System.out.println("error:" + index);
                break;
            }
        }
        System.out.println("end");


    }

    private static int[] genRandomNotEqualBetweenArr(int maxL, int maxV) {
        //至少得给我两个
        int L = (int)(Math.random()* maxL) + 2;
        int[] arr = new int[L];
        int pre = (int)(Math.random() * maxV);
        for (int i=0;i<L;i++) {
            int v ;
            do {
                v = (int)(Math.random() * maxV);
            } while (pre == v);
            arr[i] = v;
            pre = v;
        }
//        System.out.println("当前的随机数组为：" + Arrays.toString(arr));
        return arr;

    }

    private static boolean check(int[] arr, int index) {
        int left = index - 1;
        int right = index + 1;
        boolean leftB = left < 0 ? arr[0] < arr[1] : arr[index] < arr[index-1];
        boolean rightB = right >= arr.length ? arr[arr.length-1] < arr[arr.length-2] : arr[index] < arr[right];
        return leftB && rightB;
    }

    private static int findOneMin(int[] arr) {
        if (arr == null || arr.length <=1)
            return -1;

        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length-1] < arr[arr.length-2]) {
            return arr.length-1;
        }

        int L = 0;
        int R = arr.length-1;
//        二分中的 L <= R ，是可以取到边界的，所以R=M-1,而L<R-1的情况下，取不到边界，所以R=M
        //三个里面必定有局部最小
        while (L < R-1) {
            int M = R - ((R-L)>>1);
//            System.out.println("当前arr:" + Arrays.toString(arr));
            if (arr[M] < arr[M-1] && arr[M] < arr[M+1]) {
                return M;
            }
            if (arr[M] > arr[M-1]) {
                R = M ;
            }else if (arr[M] > arr[M+1]) {
                L = M;
            }
        }

        return -1;
    }




}
