class Solution {
    public int removeDuplicates(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[n] = nums[i];
                ++n;
            }
        }
        return n;
    }
}
