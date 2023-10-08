class Solution {
    public int[][] merge(int[][] intervals) {
        // 双关键字排序
        Arrays.sort(intervals,
             (a, b) -> { // 两个长度为2的数组比较
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
             });

        // 合并
        // 维护当前覆盖的最远端
        // 判断一个区间是延续？还是新成立一段？
        // 看它的起点是在最远端之后还是之前
        /*[1, 5]  [2, 6] [3, 4] [6, 10]  [11 12]
        [1  5] 当前覆盖的最远端：5
        [2  6] 当前覆盖的最远端：6
        [3  4] 当前覆盖的最远端：6
        [6 10] 当前覆盖的最远端：10

        [11 12]*/
        List<int[]> ans = new ArrayList<>();;
        int left = -1;
        int far = -1;
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (start <= far) { // 延续
                far = Math.max(far, end);
            } else { // 另起一段
                // 旧的段放进答案
                if (far >= 0) ans.add(new int[]{left, far});
                // 新开一段（只有[start,end]）
                left = start;
                far = end;
            }
        }
        if (far >= 0) {
            ans.add(new int[]{left, far});
        }
        return ans.toArray(new int[0][]);
    }
}

//时间差分法
//class Solution {
//     public int[][] merge(int[][] intervals) {
//         /*[1, 5]  [2, 6] [3, 4] [6, 10]  [11 12]
//            1 2 3 4 5 6 7 8 9 10 11 12
//            1 1 1 1 1
//              1 1 1 1 1
//                1 1
//                      1 1 1 1  1
//                                   1 1
           
//            +1        -1
//              +1        -1
//                +1  -1
//                      +1        -1
//                                +1 -1
//          count: 0
//         把从1覆盖到5这个区间，看作2个事件：
//         (a) 在1处，有一个事件：开始覆盖（次数+1）
//         (b) 在5+1处，有一个事件：结束覆盖（次数-1）
//         */
//         // 产生2n个事件
//         // 时间位置，时间情况(+1/-1)
//         List<int[]> events = new ArrayList<>();
//         for (int[] interval : intervals) {
//             // 差分
//             events.add(new int[]{interval[0], 1});
//             events.add(new int[]{interval[1] + 1, -1});
//         }
//         events.sort((a, b) -> (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1])); 
//         int count = 0;
//         int left = 0;
//         List<int[]> ans = new ArrayList<>();
//         for (int[] event : events) {
//             if (count == 0) // 加之前是0，加之后是非0
//                 left = event[0];  // 一个段的产生
//             count += event[1];
//             if (count == 0) // 非零变零，一个段的结束
//                 ans.add(new int[]{left, event[0] - 1});
//         }
//         return ans.toArray(new int[0][]);
//     }
// }
