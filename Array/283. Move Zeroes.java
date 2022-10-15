class Solution {
    public void moveZeroes(int[] nums) {
        int n = 0;
        int x = nums.length;
        for (int i = 0; i < x; ++i) {
            if (nums[i] != 0) {
                nums[n] = nums[i];
                ++n;
            }
        }
        while (n < x) {
            nums[n] = 0;
            ++n;
        }
    }
}
