package newbie.c27;

/**
 * 合并两个有序链表
 */
public class C27_3 {
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

        //判断空
        if (n11 == null || n21 == null) {
            return n11 == null ? n21 : n11;
        }

        // 没必要找最长的
        Node l = n11;
        Node s = n21;
        //保存头
        Node res = l.v < s.v ? l : s;
        //编织身子
        Node _res = res;
        if (res == l) {
            l = l.next;
        } else {
            s = s.next;
        }
        while (s != null && l != null) {
            if (s.v <= l.v) {
                _res.next = s;
                _res = s;
                s = s.next;
            } else {
                _res.next = l;
                _res = l;
                l = l.next;
            }

            //可合成一句 _res = _res.next;
        }

        if (s != null) {
            _res.next  = s;
        }

        if (l != null) {
            _res.next = l;
        }
        // 再合成一句  _res.next = s!=null ? s : l;
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
