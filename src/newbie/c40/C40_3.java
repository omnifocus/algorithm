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
 *  而且必须要传递，否则可能某一分支不满足，而其上层满足
 *
 *  查看c40_2_improve
 *  典型案例 [5,4,6,null,null,3,7]
 *
 *  以下是错误代码
 */
public class C40_3 {
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
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        boolean flag = getNodeInfo(t1).isBST;
        System.out.println(flag);
    }


    public  static  Info getNodeInfo(TreeNode node) {
        if (node == null) return null;
        int max = node.val;
        int min = node.val;
        boolean isBST = true;
        Info leftInfo = getNodeInfo(node.left);
        Info rightInfo = getNodeInfo(node.right);


        if (leftInfo != null) {
            max = Math.max(leftInfo.max,max);
            min = Math.min(leftInfo.min,min);
        }

        if (rightInfo != null) {
            max = Math.max(rightInfo.max,max);
            min = Math.min(rightInfo.min,min);
        }


        boolean leftBool = leftInfo != null ? leftInfo.max < node.val && leftInfo.isBST : true;
        boolean rightBool =   (rightInfo != null ? rightInfo.min > node.val && rightInfo.isBST : true);


        return new Info(rightBool && leftBool  ,max,min);


    }

   static class Info {
        boolean isBST;
        int max;
        int min;

        public Info( boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }
}
