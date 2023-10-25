package newbie.c17;

/**
 * 经典二分
 */
public class C17_1 {
    public static void main(String[] args) {

        test();
    }

    // TODO
    private static boolean findNum(int[] arr, int tofind) {
        if (arr == null || arr.length == 0)
            return false;
        int L = 0;
        int R = arr.length-1;

        while ( L <= R) {
            int M = R - ((R-L)>>1);
            if (arr[M] == tofind)
                return true;
            if (arr[M] < tofind) {
                L = M+1;
            } else {
                R = M-1;
            }
        }
        return false;

    }

    private static void test() {
        int n = 1000000;
        int maxLen = 15;
        int maxValue = 100;
        for (int i=0;i<n;i++) {
             int[] arr = genRandomArr(maxLen,maxValue);
             int toFind = (int)(Math.random() * maxValue);
             if (findNum(arr,toFind)  != findNum2(arr,toFind)) {
                 System.out.println("出错了！");
                 break;
             }
        }
        System.out.println("成功！");
    }

    private static int[] genRandomArr(int maxLen, int maxValue) {
        int len = (int)(Math.random() * maxLen);
        int[] arr = new int[len];
        for (int j=0;j<len;j++) {
            arr[j] = (int)(Math.random() * maxValue);
        }
        insertSort(arr);
//        System.out.println("当前的数组为：" + Arrays.toString(arr));
        return arr;
    }

    private static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        for (int i=0;i<arr.length;i++) {
            int index = i;
            for (int j=i+1;j<arr.length;j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            if (index != i)
                swap(arr,index,i);
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }




    private static boolean findNum2(int[] arr, int tofind) {
        if (arr == null || arr.length == 0)
            return false;
        for (int i=0;i<arr.length;i++) {
            if (arr[i] == tofind) {
                return true;
            }
        }
        return false;
    }


}
