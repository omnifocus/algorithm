package newbie.c22;

/**
 * 单链表实现队列
 */
public class C22_14 {


    private static class Queue<V> {
        Node<V> head,tail;
        int size;
        private static  class Node<V> {
            V v;
            Node<V> next;

            public Node(V v) {
                this.v = v;
            }
        }
        public void offer(V v) {
            Node<V> node= new Node<>(v);
            size ++;
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
            V v = null;
            if (tail == null) return null;
            v = head.v;
            size--;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
           return v;
        }


        public V peek() {
            return head == null ? null: head.v;
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

        System.out.println(q.poll());
        System.out.println(q.isEmpty());

    }


}
