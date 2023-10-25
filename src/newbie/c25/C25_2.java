package newbie.c25;

public class C25_2 {
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
        int K = 10;

        System.out.println("调整前：");
        print(head);


        System.out.println("调整后：");


        Node ret = calc(head, K);

        print(ret);

    }

    private static Node calc(Node head, int k) {
        Node tail = findTail(head,k);

        if (tail == null) {
            return head;
        }
        Node tailNext = null;

        Node beginNode = tail;
        while (tail != null) {
            tailNext = tail.next;
            reverse(head,tailNext);

            tail = findTail(tailNext,k);


            if (tail == null) {
                head.next = tailNext;
                return beginNode;
            }
            head.next = tail;
            head = tailNext;


        }
        return beginNode;
    }

    private static void reverse(Node head, Node tailNext) {
        Node prev = null;
        Node next = null;
        while (head != tailNext) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
    }


    /**
     * 最后一个要么是null，要么是最后一个node
     * @param node
     * @param k
     * @return
     */
    private static Node findTail(Node node, int k) {
        Node _node = node;
        while (--k > 0 && _node != null) {
            _node = _node.next;
        }
        return _node;
    }

    private static void print(Node n1) {
        while (n1 != null) {
            System.out.print(n1.v + " ");
            n1 = n1.next;
        }
        System.out.println();
    }


}
