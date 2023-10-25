package newbie.c23;

/**
 * 单例表实现栈
 *
 * emm 不用tail
 */
public class C23_Stub {
    private static class Stack<V> {

        public void push(V v) {
        }

        public V pop() {
            return null;
        }
        public V peek() {
            return null;
        }

        public boolean isEmpty() {
            return false;
        }

    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
    }


}
