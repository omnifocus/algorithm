package newbie.c23;

/**
 * 单例表实现栈
 *
 * emm 不用tail
 */
public class C23_11 {
    private static class Stack<V> {
        Node<V> head,tail;
        int size;
        private static class Node<V> {
            V v;
            Node<V> next;

            public Node(V v) {
                this.v = v;
            }
        }
        public void push(V v) {
            Node<V> n = new Node<>(v);
            if (head == null) {
                head  = n;
                tail = n;
            } else {
                n.next = head;
                head = n;
            }
            size ++;
        }

        public V pop() {
            V v ;
            if (head == null) return null;
            v = head.v;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
               head = head.next;
            }
            size -- ;
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
