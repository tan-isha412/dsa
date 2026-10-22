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
class Pair
{
    TreeNode curr;
    int w;
    Pair(TreeNode curr,int w)
    {
        this.curr=curr;
        this.w=w;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxW=0;
        if(root==null) return maxW;
        ArrayDeque<Pair> q=new ArrayDeque<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty())
        {
            int s=q.size(),minm=Integer.MAX_VALUE,maxm=Integer.MIN_VALUE,f=q.peek().w;
            for(int i=0;i<s;i++)
            {
                Pair obj=q.poll();
                int n=obj.w-f;
                minm=Math.min(minm,n);
                maxm=Math.max(maxm,n);
                if(obj.curr.left!=null)
                    q.offer(new Pair(obj.curr.left,(2*n)));
                if(obj.curr.right!=null)
                    q.offer(new Pair(obj.curr.right,(2*n+1)));
            }
            maxW=Math.max(maxW,maxm-minm+1);
        }
        return maxW;
    }
}