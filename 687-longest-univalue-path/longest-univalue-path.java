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
    int maxm=0;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return 0;
        count(root);
        return maxm;
    }
    public int count(TreeNode root)
    {
        if(root==null) return 0;
        int left=count(root.left);
        int right=count(root.right);
        int l=0,r=0;
        if(root.left!=null && root.left.val==root.val)
            l=left+1;
        if(root.right!=null && root.right.val==root.val)
            r=right+1;
        maxm=Math.max(maxm,l+r);
        return Math.max(l,r);
    }
}