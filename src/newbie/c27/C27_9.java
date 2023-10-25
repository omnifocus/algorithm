package newbie.c27;

/**
 * 合并两个有序链表
 */
public class C27_9 {
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
       if (n11 == null || n21 == null) {
           return n11 == null ? n21 : n11;
       }

       Node res  = n11.v < n21.v ? n11 : n21;
       Node cobbler = res;
       if (n11 == res) {
           n11 = n11.next;
       } else {
           n21 = n21.next;
       }
       while (n11 != null && n21 != null) {
          if (n11.v < n21.v) {
             cobbler.next = n11;
             n11 = n11.next;
          } else {
             cobbler.next = n21;
             n21 = n21.next;
          }
          cobbler = cobbler.next;
       }
       if (n11 != null) {
           cobbler.next = n11;
       }
       if (n21 != null) {
           cobbler.next = n21;
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
