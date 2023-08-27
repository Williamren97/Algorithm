import java.util.ArrayList;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        ans.add(right);

        int low = -1, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (nums[mid] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        ans.add(high);

        if (ans.get(0) > ans.get(1)) {
            return new int[]{-1, -1};
        } else {
            return new int[]{ans.get(0), ans.get(1)};
        }
    }
}
