package newbie.c24;


/**
 * 双端链表 , crud O(1)
 * 单链表不能实现，因为跳不回去，不能O(1)
 * 参考C24_2
 */
public class C24_10 {
    private static class MyDeque<V> {

        Node<V> head, tail;
        private static class Node<V> {
            V v;
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
                node.prev = tail;
                tail = node;
            }
        }

        V popFromHead() {
            if (head == null)
                return null;
            V v = head.v;
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

            if (tail == null) return null;
            V v = tail.v;
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
//        mydeque<integer> dell = new mydeque();
//        dell.addtohead(1);
//        dell.addtohead(2);
//        dell.addtotail(3);
//        dell.addtotail(4);
//        system.out.println(dell.popfromhead());
//        system.out.println(dell.popfromtail());
//        system.out.println(dell.popfromhead());
    //        system.out.println(dell.popfromtail());

        String str = "12 w122jk";
        System.out.println(str.replaceAll("\\b12\\b","twelve"));

    }
}
