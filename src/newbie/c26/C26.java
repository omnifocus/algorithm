package newbie.c26;

public class C26 {
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

    private static void doit(Node n11, Node n21) {
        Node l,s;

        Node _l;

        l = findLongerNodeList(n11,n21);
        _l = l;

        s =  n11 == l ? n21 : n11;

        int carry = 0;
        int sum = 0;
        // 指向当前节点，以备后用
        Node last = l;

        // l s 都不为空
        while (l != null && s != null) {
            sum =  l.v + s.v + carry;
            //将l的值覆写
            l.v = sum % 10;
            carry = sum / 10;
            last = l;
            l = l.next;
            s = s.next;
        }

        // l不为null
        while (l != null ) {
            sum = l.v  + carry;
            l.v = sum % 10;
            carry = sum / 10;
            last = l;
            l = l.next;
        }

        // l 也为null
        if (carry != 0)
            last.next = new Node(carry);

        print(_l);
    }

    private static Node findLongerNodeList(Node n11, Node n21) {
        Node _n11 = n11;
        Node _n21 = n21;
        while (n11 != null && n21 != null) {
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
