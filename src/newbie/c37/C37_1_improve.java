package newbie.c37;

import java.util.HashMap;

/*
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class C37_1_improve {

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
        if (preorder == null || inorder == null || preorder.length != inorder.length )
            return null;

        HashMap<Integer,Integer> indexMap = new HashMap<>();
        for (int i=0;i<inorder.length;i++) {
            indexMap.put(inorder[i],i);
        }

        return f(preorder,0,preorder.length-1,inorder,0,inorder.length-1,indexMap);
    }

    private TreeNode f(int[] preorder, int L1, int R1, int[] inorder, int L2, int R2, HashMap<Integer, Integer> indexMap) {
        if (L1 > R1) return null;
        TreeNode node = new TreeNode(preorder[L1]);
        if (L1 == R1) {
            return node;
        }
        int find = indexMap.get(preorder[L1]);
        node.left = f(preorder,L1+1,L1+find-L2,inorder,L2,find-1,indexMap);
        node.right = f(preorder,L1+find-L2+1,R1,inorder,find+1,R2,indexMap);
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{1,2};
        int[] inorder = new int []{2,1};
//        Output: [3,9,20,null,null,15,7]
        new C37_1_improve().buildTree(preorder,inorder);
    }
}
