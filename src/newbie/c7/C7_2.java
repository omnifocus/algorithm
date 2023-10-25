package newbie.c7;

/**
 * 计算一个数组上 某两位之间的和
 *
 * 两种方法
 *  1. 构建二维数组 ,缺点 浪费一半空间 （如1到0上不会被利用）,优点：构建完直接查即可
 *  2.    2. 构建一维数组，每个位置存从0到当前位置的和
 */
public class C7_2 {
    public static void main(String[] args) {
        int[] arr = new int[] {1,4,5,7,3,2,6,9};
        int start = 2;
        int end = 7;
       int res1 =  method1(arr,start,end);
       int res2 =  method2(arr,start,end);
        System.out.println((res1 == res2) + ":" + res1  + ", "  + res2);

         start = 0;
         end = 7;
         res1 =  method1(arr,start,end);
         res2 =  method2(arr,start,end);
        System.out.println((res1 == res2) + ":" + res1  + ", "  + res2);
    }

    private static int method2(int[] arr, int start, int end) {
       int[] res = new int[arr.length];
       int sum = arr[0];
       res[0] = arr[0];
       for (int i=1;i<arr.length;i++) {
           sum += arr[i];
           res[i] = sum;
        }
        return start == 0 ? res[end] : res[end] - res[start-1];
    }


    private static int method1(int[] arr, int start, int end) {
        int[][] res = new int[arr.length][arr.length];
        for (int i=0;i<arr.length;i++) {
            int sum = arr[i];
            res[i][i] = arr[i];
            for (int j=i+1;j<arr.length;j++) {
                sum += arr[j];
                res[i][j] = sum;
            }
        }
        return res[start][end];
    }
}
