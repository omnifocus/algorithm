package newbie.c38;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 测试java自带的Stack 与 Linkedlist实现的Stack 的 性能对比
 */
public class Test {
    public static void main(String[] args) {
        int testTime = 1000000000;
        long start;
        long end;

        System.out.println("hello");

        //Stack和LinkedList速度测试
        testTime = 100000;
        Stack<Integer> stack = new Stack<>();
        //Stack入栈
        start = System.currentTimeMillis();
        for (int i = 0; i < testTime; i++){
//            stack.add(0, i);
            stack.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println("Stack入栈时间：" + (end - start));
        //Stack出栈
        start = System.currentTimeMillis();
        int a;
        while (!stack.isEmpty()){
          stack.pop();
        }
        end = System.currentTimeMillis();
        System.out.println("Stack出栈时间：" + (end - start));

        //LinkedList替代栈
        LinkedList<Integer> s = new LinkedList<>();
        //LinkedList入栈
        start = System.currentTimeMillis();
        for (int i = 0; i < testTime; i++){
            s.addLast(i);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList入栈时间：" + (end - start));
        //LinkedList出栈
        start = System.currentTimeMillis();
        while (!s.isEmpty()){
            s.pollLast();
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList出栈时间：" + (end - start));
    }
}
