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
