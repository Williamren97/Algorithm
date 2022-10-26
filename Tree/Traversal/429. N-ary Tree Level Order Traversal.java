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
