package newbie.c25;


/**
 * k个节点的组内逆序
 *  12345678
 *  每3个逆序
 *  32165478
 */
public class C25 {
    private static class Node {
        int v ;
        Node next;
        Node prev;

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
//        n11.next = n12;

        Node head = n1;
        int K = 4;

        System.out.println("调整前：");
        print(head);
        

        System.out.println("调整后：");


        Node ret = calc(head,K);

        print(ret);

    }

    private static Node calc(Node head,int K) {

        Node tail = findTail(head,K);
        //凑不够K个，直接返回头
        if (tail == null) {
            return head;
        }
        Node begin = tail;
        Node curHead = head;
        while (tail != null) {

            //下一圈的开头
            Node nextHead = tail.next;
            tail = findTail(nextHead,K);

            Node prev = null;
            Node cur = curHead;
            Node next = null;
            while (cur != nextHead) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            if (tail == null) {
                curHead.next = nextHead;
                return begin;
            } else {
                curHead.next = tail;
                curHead = nextHead;

            }

        }

        return begin;
    }

    private static void reverse(Node retNode) {
        while (retNode != null) {
            Node prev = retNode.prev;
            if (prev != null) {
                Node prePre = prev.prev;
                Node preNex = prev.next;
                Node next = retNode.next;
                retNode.next = prePre;
                retNode.prev = prev;
                preNex = next;
                prev.prev = retNode;
            }
            retNode = prev;
        }

      //我的下一个指向你的上一个 我的上一个指向你

        //你的下一个指向我的下一个，你的上一个指向我
    }

    private static Node findTail(Node n1, int k) {

        int c = 0;

        while (++c < k && n1 != null) {
            n1 = n1.next;
        }
        return n1;

    }

    private static void print(Node n1) {
        while (n1 != null) {
            System.out.print(n1.v + " ");
            n1 = n1.next;
        }
        System.out.println();
    }
    

}
