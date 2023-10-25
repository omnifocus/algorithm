package newbie.c22;

/**
 * 单链表实现队列
 */
public class C22_11 {

    private static class Queue<V> {
        private static class Node<V> {
            V v;
            Node<V> next;

            public Node(V v) {
                this.v = v;
            }
        }


        Node<V> head,tail;
        public void offer(V v) {
            Node<V> node = new Node<>(v);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        //注意事项
        public V poll() {
            V v = null ;
            if (head == null) {
               return v;
            }
            if (head == tail) {
               v = head.v;
               head = null;
               tail = null;
            } else {
                v = head.v;
                head = head.next;
            }
            return v;
        }


        public V peek() {
            V v = null;
            if (head == null) return v;
            return head.v;
        }

        public boolean isEmpty() {
            return head == null;
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
