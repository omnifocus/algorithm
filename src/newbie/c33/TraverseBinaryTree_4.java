package newbie.c33;

public class TraverseBinaryTree_4 {


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

        //TODO
        traverseTree(root);
    }

    private static void traverseTree(Node<Integer> root) {
            if (root == null)
                return;
        traverseTree(root.left);

        System.out.println(root.v);

        traverseTree(root.right);
    }
}
