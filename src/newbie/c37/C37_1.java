package newbie.c37;

/*
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class C37_1 {

    public class TreeNode {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length)
            return null;

        return f (preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode f (int[] preorder, int L1, int R1 , int[] inorder, int L2, int R2) {
        TreeNode head = new TreeNode(preorder[L1]);
        if (L1 == R1) {
            return head;
        }
        int index = L2;
        while (inorder[index] != preorder[L1]) {
            index++;
        }
        head.left = f (preorder,L1+1,L1+index-L2,inorder,L2,index-1);
        head.right = f (preorder,L1+index-L2+1,R1,inorder,index+1,R2);

        return head;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{1,2};
        int[] inorder = new int []{2,1};
//        Output: [3,9,20,null,null,15,7]
        new C37_1().buildTree(preorder,inorder);
    }
}
