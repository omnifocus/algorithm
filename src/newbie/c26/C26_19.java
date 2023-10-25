package newbie.c26;

/**
 * 两个链表各位上的数相加
 */
public class C26_19 {
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


        Node start = doit(n11,n21);
        print(start);




    }

    private static Node doit(Node n11, Node n21) {
        if (n11 == null) return n21;
        if (n21 == null) return n11;
        Node longer = findLonger(n11,n21);
        Node smaller = longer == n11 ? n21 : n11;
        Node res = longer;
       Node last = null;
       int carrier = 0;
       int sum = 0;
        while (longer != null && smaller != null) {
           sum = longer.v + smaller.v + carrier;
           longer.v = sum % 10;
           carrier  = sum / 10;
          last = longer;
          longer = longer.next;
          smaller = smaller.next;
        }
        while (longer != null) {
           sum = longer.v + carrier;
           longer.v = sum  %  10;
           carrier = sum / 10;
           last = longer;
           longer = longer.next;
        }

       if (carrier != 0) {
           last.next = new Node(1);
       }
       return res;
    }

    private static Node findLonger(Node n11, Node n21) {
       Node _n11 = n11;
       Node _n21 = n21;

       while (_n11 != null && _n21 != null) {
           _n11 = _n11.next;
           _n21 = _n21.next;
       }
       if (_n11 == null) return n11;
       return n21;
    }


    private static void print(Node n1) {
        while (n1 != null) {
            System.out.print(n1.v + " ");
            n1 = n1.next;
        }
        System.out.println();
    }

}
