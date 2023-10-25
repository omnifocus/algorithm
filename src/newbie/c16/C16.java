package newbie.c16;



import newbie.c5.C5;
import newbie.c6.C6;

import java.util.HashMap;
import java.util.Map;

/**
 * 对数器
 */
public class C16 {
    public static void main(String[] args) {

        int runtimes = 1000000;
        int len = 10;
        int maxValue = 100;
        for (int i=0;i<runtimes;i++) {

           int[] arr =  genRandomArr(len,maxValue);
           int[] arr2 = new int[arr.length];
           System.arraycopy(arr,0,arr2,0,arr.length);
           C5.bubbleSort(arr);
           C6.insertSort(arr2);
           if (!isSorted(arr) || !isSorted(arr2)) {
               System.out.println("bubblesort:" + isSorted(arr) + " | insertSort: " + isSorted(arr2));
               return;
           }
        }
        System.out.println("all right!");
    }

    /**
     * 全数组没有重复数
     * @param len
     * @param maxValue
     * @return
     */
    public static int[] genRandomArr(int len, int maxValue) {
        int[] arr = new int[len];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<len;i++) {
            do {
                arr[i] = (int) (Math.random() * (maxValue + 1));
            }  while (map.containsValue(arr[i]));
            map.put(i,arr[i]);
        }

        return arr;
    }

    /**
     * 生成相邻不等的数组
     * @param len
     * @param maxValue
     * @return
     */
    public static int[] genRandomArr2(int len, int maxValue) {
        int[] arr = new int[len];
        arr[0] = (int) (Math.random() * (maxValue + 1));
        for (int i=1;i<len;i++) {
            do {
                arr[i] = (int) (Math.random() * (maxValue + 1));
            }  while (arr[i] == arr[i-1]);
        }

        return arr;
    }

    public static int[] copyArr(int[] arr) {
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr,0,arr2,0,arr.length);
        return arr2;
    }

    private static boolean isSorted(int[] arr) {
        if (arr.length < 2)
            return true;
        int max = arr[0];
        for (int i=1;i<arr.length;i++) {
            if (max > arr[i]) {
                return false;
            }
            max = Math.max(max,arr[i]);
        }
        return true;
    }
}
