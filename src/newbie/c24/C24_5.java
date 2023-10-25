package newbie.c24;


/**
 * 双端链表 , O(1)
 * 单链表不能实现，因为跳不回去，不能O(1)
 * 参考C24_2
 */
public class C24_5 {
    private static class MyDeque<V> {
        Node<V> head,tail;
        private static class Node<V> {
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
        }

        void addToTail(V v) {
            Node<V> node = new Node<>(v);
            if (head == null) {
                head = node;
                tail = node;
            } else {
               tail.next = node;
               node.prev =tail;
               tail = node;
            }
        }

        V popFromHead() {
            V v ;
            if (head == null) {
                return null;
            }
            v = head.v;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            return v;
        }

        V popFromTail() {
            V v ;
            if (tail == null) {
                return null;
            }
            v = tail.v;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
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
        System.out.println(dell.popFromHead());
        System.out.println(dell.popFromTail());

    }
}
