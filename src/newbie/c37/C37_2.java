package newbie.c37;

import java.util.HashMap;

/*
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class C37_2 {

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
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        for (int i=0;i<inorder.length;i++) {
            indexMap.put(inorder[i],i);
        }
        return f(preorder,0,preorder.length-1,inorder,0,inorder.length-1,indexMap);
    }

    public TreeNode f(int[] p, int L1, int R1, int[] in, int L2, int R2,HashMap<Integer,Integer> indexMap) {
        if (L1 > R1) return null;
        TreeNode node = new TreeNode(p[L1]);
        if (L1 == R1) {
            return node;
        }
        int find = indexMap.get(p[L1]);
        node.left = f(p,L1+1,L1+find-L2,in,L2,find-1,indexMap);
        node.right = f(p,L1+find-L2+1,R1,in,find+1,R2,indexMap);
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int []{9,3,15,20,7};
//        Output: [3,9,20,null,null,15,7]
        new C37_2().buildTree(preorder,inorder);
    }
}
