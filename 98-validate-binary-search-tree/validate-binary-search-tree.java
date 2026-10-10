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
        if(root==null) return true;
        return valid(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean valid(TreeNode curr,int minm,int maxm)
    {
        if(curr==null) return true;
        if(curr.val<minm || curr.val>maxm) return false;
        if(curr.val==Integer.MIN_VALUE && curr.left!=null) return false;
        if(curr.val==Integer.MAX_VALUE && curr.right!=null) return false;
        return valid(curr.left,minm,curr.val-1) && valid(curr.right,curr.val+1,maxm);
    }
}