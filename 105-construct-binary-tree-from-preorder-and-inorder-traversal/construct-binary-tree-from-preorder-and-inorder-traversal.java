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
    int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildNode(preorder,inorder,0,inorder.length-1);
    }
    public TreeNode buildNode(int[] preorder,int[] inorder,int left,int right)
    {
        if(left>right) return null;
        TreeNode root=new TreeNode(preorder[idx]);
        int pos=find(inorder,preorder[idx++]);
        root.left=buildNode(preorder,inorder,left,pos-1);
        root.right=buildNode(preorder,inorder,pos+1,right);
        return root;
    }
    public int find(int[] inorder,int val)
    {
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==val)
                return i;
        }
        return -1;
    }
}