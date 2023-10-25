package newbie.c25;

public class C25_6 {
    private static class Node {
        int v ;
        Node next;

        public Node(int v) {
            this.v = v;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next = n11;

        Node head = n1;
        int K = 3;

        System.out.println("调整前：");
        print(head);


        System.out.println("调整后：");


        Node ret = calc(head, K);

        print(ret);

    }

    private static Node calc(Node head, int k) {
        Node last = findLast(head,k);
        //说明连一组都凑不够
        if (last == null) {
            return head;
        }
        Node res = last;
        Node next = last.next;
        while (last != null) {
            reverse(head,next);
            last = findLast(next,k);
            if (last == null) {
                head.next = next;
                return res;
            }
            head.next = last;
            head = next;
            next = last.next;
        }
        return res;
    }

    private static void reverse(Node head, Node endNode) {
        Node next;
        Node pre = null;
        while (head != endNode) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
    }

    private static Node findLast(Node head, int k) {
        while (head != null && --k > 0) {
            head = head.next;
        }
        return head;
    }

    private static void print(Node n1) {
        while (n1 != null) {
            System.out.print(n1.v + " ");
            n1 = n1.next;
        }
        System.out.println();
    }


}
