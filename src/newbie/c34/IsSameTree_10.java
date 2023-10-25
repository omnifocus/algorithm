package newbie.c34;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsSameTree_10 {
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
//        System.out.println(isSameTree(root,root3));
        String s = "pa,pa";
        String pattern = "\\Gpa";
        Pattern comp = Pattern.compile(pattern);
        Matcher matcher = comp.matcher(s);
        System.out.println(matcher.find() + "," + matcher.find() );
    }


    private static boolean isSameTree(Node<Integer> root, Node<Integer> root3) {
        if (root == null ^ root3 == null) return false;
        if (root == null && root3== null) return true;
        return root.v == root3.v && isSameTree(root.left,root3.left) && isSameTree(root.right,root3.right);
    }


}
