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
    public boolean isValidBST(TreeNode root) {
        return valid(root,null,null);
    }
    public boolean valid(TreeNode root,Integer minm,Integer maxm)
    {
        if(root==null) return true;
        if(minm!=null && root.val<=minm || maxm!=null && root.val>=maxm) return false;
        boolean left=valid(root.left,minm,root.val);
        boolean right=valid(root.right,root.val,maxm);
        return left && right;
    }
}