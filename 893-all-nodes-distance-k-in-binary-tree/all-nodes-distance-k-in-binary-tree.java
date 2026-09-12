/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> ans=new ArrayList<>();
    Set<TreeNode> visited=new HashSet<>();
    Map<TreeNode,TreeNode> parMap=new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        build(root,null);
        dfs(target,0,k);
        return ans;
    }
    public void build(TreeNode ch,TreeNode par)
    {
        if(ch==null) return;
        parMap.put(ch,par);
        build(ch.left,ch);
        build(ch.right,ch);
    }
    public void dfs(TreeNode curr,int len,int k)
    {
        if(len>k || curr==null || visited.contains(curr)) return;
        visited.add(curr);
        if(len==k)
        {
            ans.add(curr.val);
            return;
        }
        dfs(curr.left,len+1,k);
        dfs(curr.right,len+1,k);
        dfs(parMap.get(curr),len+1,k);
    }
}