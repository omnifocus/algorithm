package newbie.c23;

/**
 * 单例表实现栈
 *
 * emm 不用tail
 */
public class C23 {
    private static class Stack {
        private Node head;
        private static class Node {
            int val;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }
        void push(int v) {
            Node n = new Node(v);
            if (head == null) {
                head = n;
            } else {
                n.next = head;
                head = n;
            }
        }

        Node pop() {
            Node n = head;
            if (head == null) {
                return null;
            }
            head = n.next;
            return n;

        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s.pop().val);
        System.out.println(s.pop().val);
        System.out.println(s.pop().val);
        System.out.println(s.pop().val);
        System.out.println(s.pop().val);
        System.out.println(s.pop());
    }


}
