package newbie.c21;

/**
 * 双链表的反转
 */
public class C21_12 {
    private static class Node {
        int value;
        Node pre;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.pre = n1;
        n2.next = n3;
        n3.pre = n2;
        n3.next = n4;
        n4.pre = n3;

        traverseFromBegin(n1);
        traverseFromEnd(n4);

        System.out.println("======= reverse start =========");

        Node n = reverseNode(n1);
        traverseFromBegin(n);
        traverseFromEnd(n1);

    }

    // TODO
    private static Node reverseNode(Node n1) {
        Node next = null;
        Node pre = null;
        while (n1 != null) {
            next = n1.next;
            n1.next = pre;
            n1.pre = next;
            pre = n1;
            n1 = next;
        }
        return pre;
    }

    private static void traverseFromEnd(Node n4) {
        while (n4 != null) {
            System.out.print(n4.value + " ");
            n4 = n4.pre;
        }
        System.out.println();
    }

    private static void traverseFromBegin(Node n1) {
        while (n1 != null) {
            System.out.print(n1.value + " ");
            n1 = n1.next;
        }
        System.out.println();
    }
}
