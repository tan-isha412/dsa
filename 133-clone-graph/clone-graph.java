/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Map<Node,Node> m=new HashMap<>();
        Set<Node> v=new HashSet<>();
        ArrayDeque<Node> q=new ArrayDeque<>();
        q.offer(node);
        v.add(node);
        while(!q.isEmpty())
        {
            Node curr=q.poll();
            m.put(curr,new Node(curr.val));
            for(Node nei:curr.neighbors)
            {
                if(!v.contains(nei))
                {
                    q.offer(nei);
                    v.add(nei);
                }
            }
        }
        v.clear();
        q.offer(node);
        v.add(node);
        while(!q.isEmpty())
        {
            Node curr=q.poll();
            for(Node nei:curr.neighbors)
            {
                if(!v.contains(nei))
                {
                    q.offer(nei);
                    v.add(nei);
                }
                m.get(curr).neighbors.add(m.get(nei));
            }
        }
        return m.get(node);
    }
}