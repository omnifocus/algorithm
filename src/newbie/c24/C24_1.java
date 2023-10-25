package newbie.c24;


/**
 * 双端链表 , O(1)
 * 单链表不能实现，因为跳不回去，不能O(1)
 * 有🐞️ ！
 *
 * LINE：55行
 */
public class C24_1 {
    private static class DoubleEndedQueue<V> {
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
                head=node;
                tail=node;
            } else{
                node.next = head;
                head.prev = node;
                head = node;
            }
        }

        void addToTail(V v) {
            Node<V> node = new Node<>(v);
            if (tail == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.prev =tail;
                tail = node;
            }
        }

        V popFromHead() {
            V v = null;
            if (head != null) {
                v = head.v;
                Node next = head.next;
                if (next == null) {
                    head = null;
                    tail = null;
                } else {
                    // help GC  注意是prev而非next
                    next.prev = null;
                    head = next;
                }
            }
            return v;
        }

        V popFromTail() {
            V v = null;
            if (tail != null) {
                v = tail.v;
                Node pre = tail.prev;
                if (pre == null) {
                    head = null;
                    tail = null;
                } else {
                    pre.next = null;
                    tail = pre;
                }
            }
            return v;
        }


    }

    public static void main(String[] args) {
        DoubleEndedQueue dell = new DoubleEndedQueue();
        dell.addToHead(1);
        dell.addToHead(2);
        dell.addToTail(3);
        dell.addToTail(4);
        System.out.println(dell.popFromHead());
        System.out.println(dell.popFromTail());
        System.out.println(dell.popFromHead());
        System.out.println(dell.popFromTail());
        System.out.println(dell.popFromHead());
        System.out.println(dell.popFromTail());

    }
}
