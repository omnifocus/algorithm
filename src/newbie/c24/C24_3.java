package newbie.c24;


/**
 * 双端链表 , O(1)
 * 单链表不能实现，因为跳不回去，不能O(1)
 * 参考C24_2
 */
public class C24_3 {
    private static class MyDeque<V> {
        Node<V> head, tail;
        int size;
        private static  class  Node<V> {
            V v ;
            Node<V> prev;
            Node<V> next;

            public Node(V v) {
                this.v = v;
            }
        }

        void addToHead(V v) {
            Node<V> node = new Node<>(v);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
            size++;
        }

        void addToTail(V v) {
            Node<V> node = new Node<>(v);
            if (tail == null) {
                tail = node;
                head = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
            size++;
        }

        V popFromHead() {
            V v = null;
            if (head != null) {
                v = head.v;
                head = head.next;
                head.prev = null;
                size--;
            } else {
                tail = null;
            }

            return v;
        }

        V popFromTail() {

            V v = null;

            if (tail != null) {
                v = tail.v;
                tail = tail.prev;
                tail.next = null;
                size--;
            } else {
                head =null;
            }
            return v;
        }
    }

    public static void main(String[] args) {
        MyDeque<Integer> dell = new MyDeque();
        dell.addToHead(1);
        dell.addToHead(2);
        dell.addToTail(3);
        dell.addToTail(4);
        System.out.println(dell.popFromHead());
        System.out.println(dell.popFromTail());

    }
}
