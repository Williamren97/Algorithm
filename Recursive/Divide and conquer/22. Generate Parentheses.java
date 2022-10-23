class Solution {
    // 分治解法
    public List<String> generateParenthesis(int n) {
        if (store == null) store = new HashMap<>();
        if (n == 0) return Arrays.asList("");
        if (store.containsKey(n)) return store.get(n); // 记忆化,比如8分成2 6，2算过了， 6分成24 24算过了
        List<String> ans = new ArrayList<String>();
        for (int k = 1; k <= n; k++) { // 加法原理
            List<String> A = generateParenthesis(k - 1);//k-1个子问题
            List<String> B = generateParenthesis(n - k);
            // S=(A)B
            // 乘法原理
            for (String a : A) //A的所有情况
                for (String b : B)
                    ans.add("(" + a + ")" + b);
        }
        store.put(n, ans);
        return ans;
    }

    HashMap<Integer, List<String>> store;
    //S(A)B
    //外面有k对，A里面有k-1，B还有N-K对括号
    //最外面的一对，是一个不可划分的整体，必须是一对括号匹配，排除掉第一段是并行的情况【唯一就不会重复】
    //K = 1 (A) A=0对括号 B= N-K = 3-1 = 2()()  (()) 让括号A和b分别结合 => ()()() ((()))
    //K= 2 (A) A=1对括号，括号A就是(()) B = N-K = 3-2 = 1对括号()  让括号A和b分别结合 => (())()
    //K= 3 (A) A=2对括号，括号A就是(()()) ((())) [子问题自己算] B = N-K = 3-3 = 0()  让括号A和b分别结合 => (()()) ((()))
}
