class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= nums[right]) {  // 条件满足（true，即1）
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[right];
    }
}
