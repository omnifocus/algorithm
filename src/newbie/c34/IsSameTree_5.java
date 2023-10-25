package newbie.c34;

public class IsSameTree_5 {
    private static class Node<V> {
        V v ;
        Node<V> left;
        Node<V> right;

        public Node(V v) {
            this.v = v;
        }
    }

    public static void main(String[] args) {

        Node<Integer> root = new Node<>(0);
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);
        Node<Integer> n6 = new Node<>(6);


        n1.left = n2;
        n1.right = n3;

        n4.left = n5;
        n4.right = n6;

        root.left = n1;
        root.right = n4;


        Node<Integer> root3 = new Node<>(0);
        Node<Integer> n13 = new Node<>(1);
        Node<Integer> n23 = new Node<>(2);
        Node<Integer> n33 = new Node<>(3);
        Node<Integer> n43 = new Node<>(4);
        Node<Integer> n53 = new Node<>(5);
        Node<Integer> n63 = new Node<>(6);


        n13.left = n23;
        n13.right = n33;

        n43.left = n53;
        n43.right = n63;

        root3.left = n13;
        root3.right = n43;


        // TODO
        System.out.println(isSameTree(root,root3));
    }

    private static boolean isSameTree(Node<Integer> r1, Node<Integer> r2) {
        if (r1 != null ^ r2 != null) {
            return false;
        }
        if (r1 == null || r2==null)
            return true;
        return r1.v == r2.v && isSameTree(r1.left,r2.left) && isSameTree(r1.right,r2.right);
    }


}
