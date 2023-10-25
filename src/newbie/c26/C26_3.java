package newbie.c26;

public class C26_3 {
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


        doit(n11,n21);




    }

    private static void doit(Node n1, Node n2) {
        Node l,s,r,last;
        l = findLonger(n1,n2);
        s = l == n1 ? n2 : n1;
        r = l;
        last = l;
        int carry = 0;
        int sum = 0;
        while (l != null && s != null) {
            sum = l.v + s.v + carry;
            l.v = sum % 10;
            carry = sum / 10;
            last = l;
            l = l.next;
            s = s.next;
        }

        while (l != null) {
            sum = l.v + carry;
            l.v = sum % 10;
            carry = sum / 10;
            last = l;
            l = l.next;
        }
        if (carry != 0) {
            last.next = new Node(carry);
        }

        print(r);

    }

    private static Node findLonger(Node n1, Node n2) {
        Node _n1 = n1;
        Node  _n2 = n2;
        while (_n1 != null && _n2 != null) {
            _n1 = _n1.next;
            _n2 = _n2.next;
        }
        return _n1 == null ? n2 : n1;
    }

    private static void print(Node n1) {
        while (n1 != null) {
            System.out.print(n1.v + " ");
            n1 = n1.next;
        }
        System.out.println();
    }

}
