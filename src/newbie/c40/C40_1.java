package newbie.c40;

/**
 * https://leetcode.com/problems/validate-binary-search-tree
 * 验证是否是搜索二叉树
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *  所以必须是max 和 min
 *
 *
 *  典型案例 [5,4,6,null,null,3,7]
 *
 *  以下是错误代码
 */
public class C40_1 {
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
        TreeNode t1 = new TreeNode(32);
        TreeNode t2 = new TreeNode(26);
        TreeNode t3 = new TreeNode(47);
        TreeNode t4 = new TreeNode(19);
        TreeNode t5 = new TreeNode(56);
        TreeNode t6 = new TreeNode(27);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.right = t5;
        t4.right = t6;

        boolean flag = process(t1).isBST;
        System.out.println(flag);
    }

    public boolean isValidBST(TreeNode root) {
        return process(root).isBST;
    }

    public static Info process(TreeNode node) {
        if (node == null)
            return null;
        int max = node.val;
        int min = node.val;
        boolean isBST = true;
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);
        if (leftInfo != null) {
            max = Math.max(leftInfo.max,max);
            min = Math.min(leftInfo.min,min);
        }
        if (rightInfo != null) {
            max = Math.max(rightInfo.max,max);
            min = Math.min(rightInfo.min,min);
        }

        // error  跟leftInfo、rightInfo 满足与否 不相干
        if (node.left != null && node.val <= leftInfo.max) isBST = false;


        if (node.right != null && node.val >= rightInfo.min) isBST = false;

        return new Info(max,min,isBST);
    }

    public static class Info {
        int max;
        int min;
        boolean isBST;
        public Info (int max, int min, boolean isBST) {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }
}
