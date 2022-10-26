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
    public List<Integer> postorder(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Deque<Node> nodeStack = new LinkedList<>();
        nodeStack.push(root);
        // 后序：左-右-根，入栈顺序：根-右-左
        while (!nodeStack.isEmpty()) {
            Node node = nodeStack.pop();
            if (node != null) {
                nodeStack.push(node);
                nodeStack.push(null);//这其实是通用的非递归写法，null 是一个标记位，当取到 null 时，说明下一个元素即为要处理的元素（这里的处理就是加入 res 数组中），具体的思想可以看https://www.programmercarl.com/二叉树的统一迭代法.html#迭代法中序遍历
               // List<Node> children = node.children;
              //  if (children != null) {
                    for (int i = node.children.size() - 1; i >= 0; i--) {
                        nodeStack.push(node.children.get(i));
                    }
               // }
            }
             else {
                node = nodeStack.pop();
                res.add(node.val);
            }
        }
        return res;
    }
}

//前序遍历的BFS
// class Solution {
//     public List<Integer> preorder(Node root) {
//         List<Integer> res = new ArrayList<>();
//         if (root == null) return res;
//         Stack<Node> stack = new Stack<Node>();
//         stack.push(root);
//         while (!stack.isEmpty()) {
//             Node node = stack.pop();
//             if (node == null) break;
//             res.add(node.val);
//             for (int i =node.children.size() - 1; i >= 0; --i) {
//                 stack.push(node.children.get(i));//后进先出
//             }
//         }
//         return res;
//     }
// }

//后续便利的DFS
// class Solution {
//     public List<Integer> postorder(Node root) {
//         List<Integer> res = new ArrayList<>();
//         helper(root, res);
//         return res;
//     }
//      public void helper(Node root, List<Integer> res) {
//         if (root == null) {
//             return;
//         }
//         for (Node node : root.children) {
//             helper(node ,res);
//         }
//         res.add(root.val);
//     }
// }
