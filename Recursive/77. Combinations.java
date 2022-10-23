class Solution {
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<List<Integer>>();
        chosen = new ArrayList<Integer>();
        this.n = n;
        this.k = k;
        findSubsets(1);
        return ans;

    }
     private void findSubsets(int index) {
         //已经超过k个，或者剩下的全选上也不够k，提前退出剪枝
        if (chosen.size() > k || chosen.size() + (n - index + 1) < k) return;
        if (index == n + 1) {
            ans.add(new ArrayList<Integer>(chosen));
            return;
        }
        //每层考虑i这个数选不选，如果不选，考虑下一个i + 1选不选
        findSubsets(index + 1);//面临没改过的chosen
        chosen.add(index);//要num[i]选了，就放到这里面
        findSubsets(index + 1);//面临改过的chosen
        //子问题是独立对，不能被之前加的元素影响到
        chosen.remove(chosen.size() - 1);
        // for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){
        //     path.add(i);
        //     combineHelper(n, k, i + 1);
        //     path.removeLast();
        // }
    }
    private List<List<Integer>> ans;
    private List<Integer> chosen;
    private int n;
    private int k;
}
