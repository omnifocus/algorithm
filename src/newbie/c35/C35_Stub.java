package newbie.c35;

/**
 * https://leetcode.com/problems/symmetric-tree/
 */
public class C35_Stub {

    private static class TreeNode<V> {
        V val;
        TreeNode<V> left;
        TreeNode<V> right;

        public TreeNode(V v) {
            this.val = v;
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        System.out.println(IsSymmetric(root));
    }

    private static boolean IsSymmetric(TreeNode<Integer> root) {
        return isMirror(root,root);
    }

    private static boolean isMirror(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if (root1 == null ^ root2== null) {
            return false;
        }
        if (root1 == null && root2 == null)
            return true;
        return root1.val == root2.val && isMirror(root1.left,root2.right) && isMirror(root1.right,root2.left);
    }
}
