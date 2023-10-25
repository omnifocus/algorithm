package newbie.c22;

/**
 * 单链表实现队列
 */
public class C22_3 {

    private static class Node<V> {
        V v;
        Node<V> next;

        public Node(V v) {
            this.v = v;
        }
    }
    private static class Queue<V> {
        int size;
        Node<V> head,tail;
        public void offer(V v) {
            Node<V> node = new Node<>(v);
            if (tail == null) {
                head = node;
                tail = node;
            } else  {
                tail.next = node;
                tail = node;
            }
            size ++;
        }

        //注意事项
        public V poll() {
            V v = null;
            if (head != null) {
                v = head.v;
                head = head.next;
                size--;
            } else {
                tail = null;
            }

            return v;

        }


        public V peek() {
            V v = null;
            if (head != null) {
                v = head.v;
            }
            return v;
        }

        public boolean isEmpty() {
            return size == 0;
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
    }


}
