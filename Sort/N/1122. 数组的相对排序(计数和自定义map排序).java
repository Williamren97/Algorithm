class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        int n = 0;

        int[] count = new int[1001];
        for (int i = 0; i < arr1.length; i++)
            count[arr1[i]]++;

        // 按照arr2的顺序来取
        for (int i = 0; i < arr2.length; i++)
            while (count[arr2[i]] > 0) {
                count[arr2[i]]--;
                ans[n] = arr2[i];
                n++;
            }
        
        // 剩余的没在arr2出现过，按顺序取出
        for (int val = 0; val <= 1000; val++)
            while (count[val] > 0) {
                count[val]--;
                ans[n] = val;
                n++;
            }
        return ans;
    }
}





// 如果 num1 和 num2 都在 arr2 中出现（即它们在 record 中都有对应的索引值），那么它们的顺序将由它们在 arr2 中的索引值决定。具体来说，将 num1 在 arr2 中的索引值减去 num2 在 arr2 中的索引值，以确定它们的相对顺序。
// 如果只有 num1 在 arr2 中出现，而 num2 不在 arr2 中，则 num1 将被视为小于 num2。
// 如果只有 num2 在 arr2 中出现，而 num1 不在 arr2 中，则 num1 将被视为大于 num2。
// 如果 num1 和 num2 都不在 arr2 中，那么它们的顺序将由它们的实际数值大小来决定。
// 这个自定义排序函数的目的是按照 arr2 中的顺序对 arr1 中的元素进行排序，同时将不在 arr2 中的元素排在最后。这样可以实现题目中的相对排序要求。
// 在排序时，比较函数返回负数表示第一个参数应该排在前面，返回正数表示第二个参数应该排在前面，返回零表示两个参数相等。这就是为什么在比较函数中使用减法来确定相对顺序。
// class Solution {
//     Map<Integer, Integer> record;
//     public int[] relativeSortArray(int[] arr1, int[] arr2) {
//         record = new HashMap<>(arr2.length);
//         for (int i = 0; i < arr2.length; i++) {
//             record.put(arr2[i], i);
//         }
//         Integer[] arr1Wrapper = new Integer[arr1.length];
//         for (int i = 0; i < arr1.length; i++) {
//             arr1Wrapper[i] = arr1[i];
//         }
//         // Arrays.sort(arr1Wrapper, new Comparator<Integer>() {
//         //     @Override
//         //     public int compare(Integer num1, Integer num2) {
//         //         return less(num1, num2);
//         //     }
//         // });
//         Arrays.sort(arr1Wrapper, (num1, num2) -> less(num1, num2));
//         int[] result = new int[arr1.length];
//         for (int i = 0; i < arr1.length; i++) {
//             result[i] = arr1Wrapper[i];
//         }
//         return result;
//     }

//     public int less(Integer num1, Integer num2) {
//         if (record.containsKey(num1) && record.containsKey(num2)) {
//             return record.get(num1) - record.get(num2);
//         } else if (record.containsKey(num1)) {
//             return -1;
//         } else if (record.containsKey(num2)) {
//             return 1;
//         } else {
//             return num1 - num2;
//         }
//     }
// }
