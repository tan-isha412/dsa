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
    int preorderidx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        return build(preorder,inorder,0,inorder.length-1);
    }
    public TreeNode build(int[] preorder, int[] inorder,int l,int r)
    {
        if(l>r) return null;
        int i=findPos(inorder,preorder[preorderidx]);
        TreeNode root=new TreeNode(preorder[preorderidx++]);
        root.left=build(preorder,inorder,l,i-1);
        root.right=build(preorder,inorder,i+1,r);
        return root;
    } 
    public int findPos(int[] inorder,int val)
    {
        int i=0;
        for(;i<inorder.length;i++)
        {
            if(inorder[i]==val) break;
        }
        return i;
    }
}