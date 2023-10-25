package newbie.c22;

/**
 * 单链表实现队列
 */
public class C22 {
    private static class Queue {
        Node head;
        Node tail;
        private static class Node {
            int v;
            Node next;
            public Node(int v) {
                this.v = v;
            }
        }
        void add(int v) {
            Node node = new Node(v);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        int pop() {
            if (head == null) {
                throw new RuntimeException("no nodes any more...");
            }
            int v = head.v;
            head = head.next;
            return v;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
    }


}
