package newbie.c22;

/**
 * 单链表实现队列
 */
public class C22_1 {
    private static class Queue {
        Node head;
        Node tail;
        private static class Node {
            int i;
            Node next;

            public Node(int i) {
                this.i = i;
            }
        }



        public void add(int i) {
            if (head == null) {
                head = new Node(i);
                tail = head;
            } else {
                tail.next = new Node(i);
                tail = tail.next;
            }
        }

        public int pop() {
            if (head == null) {
                throw new RuntimeException("没有元素了!");
            }
            int v = head.i;
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
        System.out.println(q.pop());
    }


}
