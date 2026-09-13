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
    int maxm=Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        if(root==null) return 0;
        return calcMax(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
    public int calcMax(TreeNode root,int minm,int maxm)
    {
        if(root==null) return maxm-minm;
        minm=Math.min(minm,root.val);
        maxm=Math.max(maxm,root.val);
        int left=calcMax(root.left,minm,maxm);
        int right=calcMax(root.right,minm,maxm);
        if(left>right) return left;
        return right;
    }
}