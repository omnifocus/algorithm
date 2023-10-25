package newbie.c27;

/**
 * 合并两个有序链表
 */
public class C27_4 {
    private static class Node {
        int v;
        Node next;

        public Node(int v) {
            this.v = v;
        }
    }

    public static void main(String[] args) {
        Node n11 = new Node(2);
        Node n12 = new Node(4);
        Node n13 = new Node(6);
        Node n14 = new Node(8);
        Node n15 = new Node(10);

        n11.next = n12;
        n12.next = n13;
        n13.next = n14;
        n14.next = n15;

        Node n21 = new Node(1);
        Node n22 = new Node(3);
        Node n23 = new Node(5);
        Node n24 = new Node(7);
        Node n25 = new Node(9);

        n21.next = n22;
        n22.next = n23;
        n23.next = n24;
        n24.next = n25;

        Node head = doit(n11,n21);
        print(head);
    }

    private static Node doit(Node n11, Node n21) {
        Node little = n11.v < n21.v ? n11 : n21;
        Node big = little == n11 ? n21 : n11;
        Node res = little;
        Node trailer = res;
        little = little.next;
        while (little != null && big != null) {
            if (little.v < big.v) {
                trailer.next = little;
                little = little.next;
            } else {
                trailer.next = big;
                big = big.next;
            }
            trailer = trailer.next;
        }
        if (little != null) {
            trailer.next = little;
        }
        if (big != null) {
            trailer.next = big;
        }
        return res;
    }


    private static void print(Node n1) {
        while (n1 != null) {
            System.out.print(n1.v + " ");
            n1 = n1.next;
        }
        System.out.println();
    }

}
