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
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node == null) break;
            res.add(node.val);
            for (int i =node.children.size() - 1; i >= 0; --i) {
                stack.push(node.children.get(i));//后进先出
            }
        }
        return res;
    }
}


// class Solution {
//     public List<Integer> preorder(Node root) {
//         List<Integer> res = new ArrayList<>();
//         helper(root, res);
//         return res;
//     }
//     public void helper(Node root, List<Integer> res) {
//         if (root == null) {
//             return;
//         }
//         res.add(root.val);//后序就是先加孩子，后根
//         for (Node node : root.children) {
//             helper(node ,res);
//         }
//     }
// }
