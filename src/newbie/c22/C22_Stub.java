package newbie.c22;

/**
 * 单链表实现队列
 */
public class C22_Stub {


    private static class Queue<V> {

        public void offer(V v) {
        }

        //注意事项
        public V poll() {
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
        Queue<Integer> q = new Queue();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());

        System.out.println(q.poll());
        System.out.println(q.isEmpty());

    }


}
