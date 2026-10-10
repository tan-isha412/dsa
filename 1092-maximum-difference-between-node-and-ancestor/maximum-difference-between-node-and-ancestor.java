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
    public int maxAncestorDiff(TreeNode root) {
        if(root==null) return 0;
        return maxmDiff(root,10001,-1);
    }
    public int maxmDiff(TreeNode curr,int minm,int maxm)
    {
        if(curr==null) return maxm-minm;
        minm=Math.min(minm,curr.val);
        maxm=Math.max(maxm,curr.val);
        int l=maxmDiff(curr.left,minm,maxm);
        int r=maxmDiff(curr.right,minm,maxm);
        return Math.max(l,r);
    }
}