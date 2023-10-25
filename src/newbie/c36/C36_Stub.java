package newbie.c36;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree
 */
public class C36_Stub {
    private static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
    public int maxDepth(TreeNode root) {

        return calculate(root);
    }

    public int calculate(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxleftlen = calculate(root.left);
        int maxrightlen = calculate(root.right);
        return 1 + (maxleftlen > maxrightlen ? maxleftlen : maxrightlen);
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);

        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;

        System.out.println(new C36_Stub().calculate(root));
    }

}
