class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<List<Integer>>();
        chosen = new ArrayList<Integer>();
        findSubsets(nums, 0);
        return ans;
    }

    private void findSubsets(int[] nums, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<Integer>(chosen));
            return;
        }
        //每层考虑i这个数选不选，如果不选，考虑下一个i + 1选不选
        findSubsets(nums, index + 1);//面临没改过的chosen
        chosen.add(nums[index]);//要num[i]选了，就放到这里面
        findSubsets(nums, index + 1);//面临改过的chosen
        //子问题是独立对，不能被之前加的元素影响到
        chosen.remove(chosen.size() - 1);
        // for (int i = startIndex; i < nums.length; i++){
        //     path.add(nums[i]);
        //     subsetsHelper(nums, i + 1);
        //     path.removeLast();
        // }
    }

    private List<List<Integer>> ans;
    private List<Integer> chosen;
}
