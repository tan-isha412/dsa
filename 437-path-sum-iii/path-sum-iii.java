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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        int par=findPath(root,targetSum);
        int l=pathSum(root.left,targetSum);
        int r=pathSum(root.right,targetSum);
        return par+l+r;
    }
    public int findPath(TreeNode node,long targ)
    {
        if(node==null) return 0;
        int cnt=0;
        if(node.val==targ)
            cnt++;
        int l=findPath(node.left,targ-node.val);
        int r=findPath(node.right,targ-node.val);
        return cnt+l+r;
    }
}