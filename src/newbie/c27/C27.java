package newbie.c27;

public class C27 {
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

        doit(n11,n21);

    }

    private static void doit(Node n11, Node n21) {
        //头节点
        Node head,cur1, cur2;
        head = n11.v <= n21.v ? n11 : n21;
        cur1 = head.next;
        cur2 = head == n11 ? n21: n11;

        Node pre = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.v <= cur2.v) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        if (cur1 != null) {
            pre.next = cur1;
        }
        if (cur2 != null) {
            pre.next = cur2;
        }
        print(head);
    }


    private static void print(Node n1) {
        while (n1 != null) {
            System.out.print(n1.v + " ");
            n1 = n1.next;
        }
        System.out.println();
    }

}
