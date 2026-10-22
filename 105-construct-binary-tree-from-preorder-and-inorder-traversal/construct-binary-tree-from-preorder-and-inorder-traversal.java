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
    Map<Integer,Integer> inOrder=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        preorderidx=0;
        for(int i=0;i<inorder.length;i++)
            inOrder.put(inorder[i],i);
        return build(preorder,0,inorder.length-1);
    }
    public TreeNode build(int[] preorder,int l,int r)
    {
        if(l>r) return null;
        int val=preorder[preorderidx++];
        int i=inOrder.get(val);
        TreeNode root=new TreeNode(val);
        root.left=build(preorder,l,i-1);
        root.right=build(preorder,i+1,r);
        return root;
    } 
}