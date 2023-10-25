package newbie.c19;

import java.util.Arrays;

/**
 * 局部最小值
 * 相邻两数不等，整体无序
 * 求既比左边(如果有)小又比右边（如果有）小的数
 */
public class C19_1 {
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

    // 两两不等的随机数组
    // 长度可能为0
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

    // 如果数组为空，判断index是否等于-1
    // 左边无元素，默认true，只看右边即可
    // 右边无元素，默认true，只看左边即可
    // 左右都无元素，true，只有一个元素
    // 好处不用限制arr的个数（之前自己需要强制arr至少两个元素）
    private static boolean check(int[] arr, int index) {
        if (arr == null || arr.length == 0)
            return index == -1;
        int leftIndex = index - 1;
        int rightIndex = index + 1;
        boolean leftBigger = leftIndex >= 0 ? arr[leftIndex] > arr[index] : true;
        boolean rightBigger = rightIndex < arr.length ? arr[rightIndex] > arr[index] : true;
        return leftBigger && rightBigger;
    }

    //比标准二分多了最后一步
    //循环时需保证至少三个元素
    //循环出来只剩两个
    //因为一定有最小值，所以取较小值的索引返回即可
    private static int findOneMin(int[] arr) {
        int N = arr.length;
        if (arr == null || N == 0)
            return -1;
        if (N == 1)
            return 0;
        //两个及以上元素的边界处理
        if (arr[0] < arr[1])
            return 0;
        if (arr[N - 2] > arr[N - 1])
            return N - 1;
        int L = 0;
        int R = N - 1;
        while (L < R - 1) {
            int M = R - ((R - L) >> 1);
            if (arr[M] < arr[M - 1] && arr[M] < arr[M + 1])
                return M;
            if (arr[M] > arr[M - 1]) {
                R = M - 1;
                continue;
            }
            if (arr[M] > arr[M + 1]) {
                L = M + 1;
                continue;
            }

        }
        return arr[L] < arr[R] ? L : R;

    }


}
