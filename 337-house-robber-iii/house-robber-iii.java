/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] ans=hRob(root);
        return Math.max(ans[0],ans[1]);
    }
    public int[] hRob(TreeNode root)
    {
        if(root==null) return new int[2];
        int[] lchild=hRob(root.left);
        int[] rchild=hRob(root.right);
        int take=root.val+lchild[1]+rchild[1];
        int nottake=Math.max(lchild[0],lchild[1])+Math.max(rchild[0],rchild[1]);
        return new int[]{take,nottake};
    }
}