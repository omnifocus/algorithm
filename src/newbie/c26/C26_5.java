package newbie.c26;

public class C26_5 {
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
//        n23.next = n24;


        doit(n11, n21);


    }

    private static void doit(Node n11, Node n21) {
        Node longNode = findLonger(n11, n21);
        Node shortNode = longNode == n11 ? n21 : n11;
        Node res = longNode;
        Node lastNode = longNode;
        int carrier = 0;
        int sum = 0;
        while (shortNode != null && longNode != null) {
            sum = shortNode.v + longNode.v + carrier;
            longNode.v = sum % 10;
            carrier = sum / 10;
            shortNode = shortNode.next;
            //不加这句，如果两个链表长度相等，最后只剩下头节点和carrier的节点
            lastNode = longNode;
            longNode = longNode.next;
        }
        while (longNode != null) {
            sum = longNode.v + carrier;
            longNode.v = sum % 10;
            carrier = sum / 10;
            lastNode = longNode;
            longNode = longNode.next;
        }
        if (carrier != 0) {
            lastNode.next = new Node(carrier);
        }
        print(res);
    }

    private static Node findLonger(Node n11, Node n21) {
        Node _n11 = n11;
        Node _n21 = n21;
        while (n11 != null && n21!= null) {
            n11 = n11.next;
            n21 = n21.next;
        }
        return n11 == null ? _n21 : _n11;
    }

    private static void print(Node n1) {
        while (n1 != null) {
            System.out.print(n1.v + " ");
            n1 = n1.next;
        }
        System.out.println();
    }

}
