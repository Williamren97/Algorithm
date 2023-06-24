class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // [关键码，下标]
        PriorityQueue<int[]> q = new PriorityQueue<>(nums.length, (a, b) -> b[0] - a[0]);
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            q.add(new int[]{nums[i], i});
            if (i >= k - 1) {
                // [i-k+1, i] 这一段的max
                // 懒惰删除
                while (q.peek()[1] <= i - k) q.poll();
                ans[i-k+1] = q.peek()[0];
            }
        }
        return ans;
    }
}
