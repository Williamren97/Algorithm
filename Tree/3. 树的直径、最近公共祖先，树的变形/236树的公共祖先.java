/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
  //标记法
//p向上一直标记父节点, q一直向上第一次遇到标记点，就是公共祖先
//找一个最深的子树，里面同时有q、p
class Solution {
    private TreeNode p;
    private TreeNode q;
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        dfs(root);
        return ans;
    }
    
    private Map<String, Boolean> dfs(TreeNode root) {
        if (root == null) return new HashMap<String, Boolean>() {{put("p", false); put("q", false);}};
        Map<String, Boolean> leftResult = dfs(root.left);
        Map<String, Boolean> rightResult =  dfs(root.right);
        Map<String, Boolean> result = new HashMap<>();
        result.put("p", leftResult.get("p") || rightResult.get("p") || (root.val == p.val));
        result.put("q", leftResult.get("q") || rightResult.get("q") || (root.val == q.val));
        if (result.get("p") && result.get("q") && ans == null) ans = root;
        return result;
    }
}




// 3. 在 lowestCommonAncestor 方法中，首先将根节点加入到 redNodes Set 中，并对 p 节点执行向上标记，即将 p 及其祖先节点加入至 redNodes 中。

// 4. 然后在 while 循环中，不断将 q 的父节点赋值给 q，直到 q 被加入到 redNodes Set 中，这样返回的 q 就是两个节点的最近公共祖先。


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        father = new HashMap<Integer, TreeNode>();
        calcFather(root);
        redNotes = new HashSet<Integer>();
        redNotes.add(root.val);
        while (p.val != root.val) {
            redNotes.add(p.val);
            p = father.get(p.val);
        }
        while (!redNotes.contains(q.val)) {
            q = father.get(q.val);
        }
         return q;
    }
    private void calcFather(TreeNode root) {
            if (root == null) return;
            if (root.left != null) {
                father.put(root.left.val, root);
                calcFather(root.left);
            }
            if (root.right != null) {
                father.put(root.right.val, root);
                calcFather(root.right);
            }
        }
        
        private Map<Integer, TreeNode> father;
        private Set<Integer> redNotes;
}

