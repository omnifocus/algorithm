package newbie.c22;

/**
 * 单链表实现队列
 */
public class C22_2 {

    private static class Node<V> {
        V v ;
        Node<V> next;

        public Node(V v) {
            this.v = v;
        }
    }

    private static class Queue<V> {

        Node<V> head, tail;
        int size;
        public Queue() {
            size = 0;
            head = null;
            tail = null;
        }

        public void offer(V v) {
            Node<V> node = new Node<>(v);
            if (tail == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
            size++;
        }

        public V poll() {
            V v = null;
            if (head != null) {
                v = head.v;
                head = head.next;
                size--;
            }
            // 保持head 跟 tail都指向null，否则tail指向的对象不会被释放
            if (head == null) {
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
        System.out.println(q.isEmpty());
        q.offer(4);
        q.offer(5);
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.isEmpty());
        System.out.println(q.poll());

    }


}
