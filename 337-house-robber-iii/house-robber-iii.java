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
        if(root==null) return 0;
        if(root.left==null && root.right==null) return root.val;
        int[] choice=steal(root);
        return Math.max(choice[0],choice[1]);
    }
    public int[] steal(TreeNode root)
    {
        if(root==null) return new int[]{0,0};
        int[] left=steal(root.left);
        int[] right=steal(root.right);
        int c1=root.val+left[1]+right[1];
        int c2=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return new int[]{c1,c2};
    }
}