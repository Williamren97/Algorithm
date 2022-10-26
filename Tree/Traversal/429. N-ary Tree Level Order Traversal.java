/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            for (int i = 0; i < cnt; ++i) {
                Node cur = queue.poll();
                level.add(cur.val);
                for (Node child : cur.children) {
                    queue.offer(child);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}




class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Pair<Node, Integer>> q = new LinkedList<Pair<Node, Integer>>();//点和层数
        List<List<Integer>> seq = new ArrayList<List<Integer>>();
        if (root == null) return seq;
        q.add(new Pair<Node, Integer>(root, 0));
        while (!q.isEmpty()) {
            Node node = q.peek().getKey();
            Integer depth = q.poll().getValue();//去掉队头并获取层数
            if (depth >= seq.size()) seq.add(new ArrayList<Integer>());//每个子数组先建好再放,防止数组越界
            seq.get(depth).add(node.val);
            for (Node child : node.children) {
                q.add(new Pair<Node, Integer>(child, depth + 1));//孩子depth = 父亲depth + 1
            }
        }
        return seq;
    }
}
