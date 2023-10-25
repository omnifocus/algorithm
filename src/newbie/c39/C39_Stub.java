package newbie.c39;

/**
 * 判断是否是平衡树
 *https://leetcode.com/problems/balanced-binary-tree/
 * 左右节点的高度绝对值差不超过1
 *
 */
public class C39_Stub {
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        new C39_Stub().isBalancedTree(root);
    }

    private static class Info {
        boolean isBalanced;
        int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public boolean isBalancedTree(TreeNode root) {
        return process(root).isBalanced;
    }


    public Info process(TreeNode node) {
        if (node == null)
            return new Info(true,0);
        int height = 1;
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);
        return new Info(leftInfo.isBalanced && rightInfo.isBalanced && Math.abs(leftInfo.height-rightInfo.height) < 2, height + Math.max(leftInfo.height,rightInfo.height));
    }
}
