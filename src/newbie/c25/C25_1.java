package newbie.c25;

public class C25_1 {
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


        Node ret = calc(head,K);

        print(ret);
    }

    /**
     * 根据tail是否为null即可判断是不是一组元素
     * @param head
     * @param k
     * @return
     */
    private static Node calc(Node head, int k) {
        Node tail = findTail(head,k);
        Node tailNext;
        if (tail == null)
            return head;

        Node newHead = tail;
        while (tail != null) {
            tailNext = tail.next;
            reverse2(head,tailNext);
            tail = findTail(tailNext,k);
            if (tail == null) {
                head.next = tailNext;
                break;
            }
            head.next = tail;
            head =  tailNext;
        }
        return newHead;

    }



    /**
     * reverse 要有头有尾，否则最终可能是循环
     * @param head
     * @return
     */
    private static Node reverse(Node head) {
        Node prev = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


    /**
     * reverse 要有头有尾，否则最终可能是循环 | 修正版
     * @param head
     * @return
     */
    private static Node reverse2(Node head,Node tailNext) {
        Node _head = head;
        Node prev = null;
        Node next = null;
        while (_head != tailNext) {
            next = _head.next;
            _head.next = prev;
            prev = _head;
            _head = next;
        }
        return prev;
    }

    private static Node findTail(Node head,int k) {
        Node node = head;
        while (--k > 0 && node != null) {
            node = node.next;
        }
        return node;
    }

    private static void print(Node n1) {
        while (n1 != null) {
            System.out.print(n1.v + " ");
            n1 = n1.next;
        }
        System.out.println();
    }

}
