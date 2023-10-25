package newbie.c20;

/**
 * 单链表反转
 */
public class C20_Stub {

    private static class Node {
        int num;
        Node next;

        public Node(int num) {
            this.num = num;
        }
    }


    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        printNodes(n1);

        Node n = reverseNodes(n1);

        printNodes(n);

    }

    //TODO
    private static Node reverseNodes(Node n1) {
        return null;
    }

    private static void printNodes(Node n1) {
        while (n1 != null) {
            System.out.print(n1.num + "\t");
            n1 = n1.next;
        }
        System.out.println();
    }

}


