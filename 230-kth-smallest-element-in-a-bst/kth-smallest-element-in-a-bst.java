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
    public int kthSmallest(TreeNode root, int k) {
        int n=0;
        ArrayDeque<TreeNode> st=new ArrayDeque<>();
        TreeNode curr=root;
        while(!st.isEmpty() || curr!=null)
        {
            while(curr!=null)
            {
                st.push(curr);
                curr=curr.left;
            }
            curr=st.pop();
            n++;
            if(n==k) return curr.val;
            curr=curr.right;
        }
        return -1;
    }
}