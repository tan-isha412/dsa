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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> l=new ArrayList<>();
        if(root==null) return l;
        ArrayDeque<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        int dirn=1;
        while(!q.isEmpty())
        {
            int s=q.size();
            List<Integer> curr=new ArrayList<>();
            for(int i=0;i<s;i++)
            {
                TreeNode node=q.poll();
                if(dirn==1)
                    curr.add(node.val);
                else
                    curr.add(0,node.val);
                if(node.left!=null)
                    q.offer(node.left);
                if(node.right!=null)
                    q.offer(node.right);
            }
            l.add(new ArrayList<>(curr));
            dirn=1-dirn;
        }
        return l;
    }
}