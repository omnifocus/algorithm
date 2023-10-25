package newbie.c4;

import java.util.Arrays;

/**
 * 选择排序
 */
public class C4_2 {
    public static void main(String[] args) {
        int[] arr = new int[] {1,4,5,7,3,2,6,9};
        System.out.println("before:" + Arrays.toString(arr));
        selectSort(arr);
        System.out.println("after:" + Arrays.toString(arr));
    }

    /**
     * 非每次都交换
     * @param arr
     */
    private static void selectSort(int[] arr) {
       if (arr == null)
           return;
       int index ;
       for (int i=0;i<arr.length-1;i++) {
           index = i;
           for (int j=i+1;j<arr.length;j++) {
               if (arr[index] > arr[j]) {
                   index = j;
               }
           }
           if (index != i)
               swap(arr,i,index);
       }
    }

    private static void swap(int[] arr, int k, int i) {
        int tmp = arr[k];
        arr[k] = arr[i];
        arr[i] = tmp;
    }
}
