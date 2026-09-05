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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        addAll(root,"",ans);
        return ans;
    }
    public void addAll(TreeNode root,String sb,List<String> ans)
    {
        if(root.left==null && root.right==null)
        {
            sb+=String.valueOf(root.val);
            ans.add(sb);
            return;
        }
        if(root.left!=null)
            addAll(root.left,sb+String.valueOf(root.val)+"->",ans);
        if(root.right!=null)
            addAll(root.right,sb+String.valueOf(root.val)+"->",ans);
    }
}