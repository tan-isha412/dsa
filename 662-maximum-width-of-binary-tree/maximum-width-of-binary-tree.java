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
    int idx;
    Pair(TreeNode curr,int idx)
    {
        this.curr=curr;
        this.idx=idx;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        ArrayDeque<Pair> q=new ArrayDeque<>();
        int w=0;
        q.offer(new Pair(root,0));
        while(!q.isEmpty())
        {
            int s=q.size();
            int currd=0;
            for(int i=0;i<s;i++)
            {
                Pair ob=q.poll();
                if(i==0) currd-=ob.idx;
                if(i==s-1) currd+=ob.idx;
                if(ob.curr.left!=null) q.offer(new Pair(ob.curr.left,ob.idx*2));
                if(ob.curr.right!=null) q.offer(new Pair(ob.curr.right,ob.idx*2+1));
            }
            w=Math.max(w,currd+1);
        }
        return w;
    }
}