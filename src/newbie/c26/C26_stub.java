package newbie.c26;

/**
 * 两个链表各位上的数相加
 */
public class C26_stub {
    private static class Node {
        int v;
        Node next;

        public Node(int v) {
            this.v = v;
        }
    }

    public static void main(String[] args) {
        Node n11 = new Node(1);
        Node n12 = new Node(2);
        Node n13 = new Node(8);
        Node n14 = new Node(7);

        n11.next = n12;
        n12.next = n13;
        n13.next = n14;

        Node n21 = new Node(8);
        Node n22 = new Node(9);
        Node n23 = new Node(7);
        Node n24 = new Node(7);

        n21.next = n22;
        n22.next = n23;
        n23.next = n24;


//        Node start = doit(n11,n21);
//        print(start);




    }

    private static void print(Node n1) {
        while (n1 != null) {
            System.out.print(n1.v + " ");
            n1 = n1.next;
        }
        System.out.println();
    }

}
