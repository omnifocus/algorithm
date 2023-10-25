package newbie.c18;

/*
指到有序数组中大于等于某个数的最左数
或
小于等于某个数的最右数
 */
public class C18 {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1,2,3,3,3, 4, 5, 6, 7,8, 9, 10};
//        int index = findMostLeftNum(arr,3);
        int index = findMostRightNum(arr, 3);
        System.out.println(index);
    }

    private static int findMostLeftNum(int[] arr, int tofind) {
        int L = 0;
        int R = arr.length - 1;
        int tofindIndex = -1;
        while (L <= R) {
            int M = ((R-L) >> 2) + L;
            if (arr[M] == tofind) {
                tofindIndex = M;
                R = M - 1;
            } else if (arr[M] < tofind) {
                L = M + 1;
            } else {
                R = M - 1;
            }
        }
        return tofindIndex;
    }
    private static int findMostRightNum(int[] arr, int tofind) {
        int L = 0;
        int R = arr.length - 1;
        int tofindIndex = -1;
        while (L <= R) {
            int M = ((R-L) >> 2) + L;
            if (arr[M] == tofind) {
                tofindIndex = M;
                L = M + 1;
            } else if (arr[M] < tofind) {
                L = M + 1;
            } else {
                R = M - 1;
            }
        }
        return tofindIndex;
    }
}
