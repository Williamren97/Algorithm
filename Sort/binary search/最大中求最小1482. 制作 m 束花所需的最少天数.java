class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int MAX = 1000000001;
        int left = 0, right = 1000000001;  // 上限是1e9，加1多一个无解
        while (left < right) {
            int mid = (left + right) / 2;
            if (isValidOnDay(bloomDay, m, k, mid)) right = mid;
            else left = mid + 1;
        }
        if (right == MAX) right = -1; // 无解
        return right;
    }

    // 判定：第T天的开花情况，能否制作m束花，每束花是连续的k朵
    private boolean isValidOnDay(int[] bloomDay, int m, int k, int T) {
        int consecutive = 0;  // 已经连续开了几朵
        int bouquet = 0;  // 花束数量
        // [x, x, x, x, _, x, x]
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= T) { // 已经开了
                consecutive++;
                if (consecutive == k) {
                    bouquet++;
                    consecutive = 0;
                }
            } else {
                consecutive = 0;
            }
        }
        return bouquet >= m;
    }
}

// 花越开越多，T天如果可行（能制作），T+1,T+2,...天都可行（能制作）- 单调分段
// 判定：mid天的开花情况，能否制作m束花，每束花是连续的k朵
