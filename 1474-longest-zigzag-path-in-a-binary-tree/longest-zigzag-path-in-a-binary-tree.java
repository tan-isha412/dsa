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
    public int longestZigZag(TreeNode root) {
        if(root==null) return 0;
        zigzag(root.left,true,1);
        zigzag(root.right,false,1);
        return maxm;
    }
    public void zigzag(TreeNode root,boolean b,int len)
    {
        if(root==null) return;
        maxm=Math.max(maxm,len);
        if(b==true)
        {
            zigzag(root.right,!b,len+1);
            zigzag(root.left,b,1);
        }
        else
        {
            zigzag(root.left,!b,len+1);
            zigzag(root.right,b,1);
        }
    }
}