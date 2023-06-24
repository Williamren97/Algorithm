//*由于队列中每个元素的值都小于或等于当前元素的值 nums[i]，所以队列中存储的元素都不可能成为滑动窗口的最大值，需要将其从队列尾部向队首方向依次移除
  ，直到队列为空或者队列尾部元素的值大于当前元素的值 nums[i]，然后将当前元素的下标加入到队列的尾部。由于队首元素为当前滑动窗口的最大值
  ，因此每次加入新元素时，需要保证队列中的元素仍然满足单调性质。*//

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        // 双端队列，存下标（代表时间）
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // 保证队头合法性https://jinshuju.net/f/bY871q
            while (!q.isEmpty() && q.getFirst() <= i - k) q.removeFirst();
            // 维护队列单调性，插入新的选项
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) q.removeLast();
            q.addLast(i);
            // 取队头更新答案
            if (i >= k - 1) ans[i - k + 1] = nums[q.getFirst()];
        }
        return ans;
    }
}
