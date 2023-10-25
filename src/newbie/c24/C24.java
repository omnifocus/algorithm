package newbie.c24;


/**
 * 双端链表 , O(1)
 * 单链表不能实现，因为跳不回去，不能O(1)
 * 有🐞️ ！
 */
public class C24 {
    private static class DoubleEndedLinkedList {

        private static class Node {
            int value;
            Node prev;
            Node next;

            public Node(int value) {
                this.value = value;
            }
        }

        private Node head;
        private Node tail;


        void addToHead(int v) {
            Node n = new Node(v);
            if (head == null) {
                head = n;
                tail = n;
            } else {
                n.next = head;
                head.prev = n;
                head = n;
            }
        }

        void addToTail(int v) {
            Node n = new Node(v);
            if (tail == null) {
                head = n;
            } else {
                tail.next = n;
                n.prev = tail;
            }
            tail = n;
        }

        Node popFromHead() {
            Node n = head;

            if (head != tail) {
                head = head.next;
                head.prev = null;
            } else {
                if (head != null) {
                    head = null;
                    tail = null;
                    return n;
                } else {
                    return n;
                }

            }
            return n;
        }

        Node popFromTail() {
            Node n = tail;
            if (tail != head) {
                tail = tail.prev;
                tail.next = null;
            } else {
                if (tail == null) {
                    return n;
                }
               if (tail == head) {
                   tail = null;
                   head = null;
                   return n;
               }
            }
            return n;
        }
    }

    public static void main(String[] args) {
        DoubleEndedLinkedList dell = new DoubleEndedLinkedList();
        dell.addToHead(1);
        dell.addToHead(2);
        dell.addToTail(3);
        dell.addToTail(4);
        System.out.println(dell.popFromHead().value);
        System.out.println(dell.popFromTail().value);

    }
}
