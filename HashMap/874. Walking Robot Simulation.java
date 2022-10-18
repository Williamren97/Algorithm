class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<Long> obs = new HashSet<>();
        for (int[] obstacle : obstacles) {//把obstacles数组hash
            obs.add(calcHash(obstacle));
        }
        int x = 0, y = 0;
        int dir = 0; // N=0, E=1, S=2, W=3
        // 网格中行走题目，技巧：方向数组 ，往北走，x+0 y+1 东 南 西
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int ans = 0;
        for (int command : commands) {
            if (command == -1) {
                dir = (dir + 1) % 4;//右转 北0+1到东 东+1右转到南 南+1到西 西(3+1) mod4 == 0，完成一圈的循环
            } else if (command == -2) {
                dir = (dir + 3) % 4; //-1 + 4
            } else {
                for (int i = 0; i < command; i++) {
                    int nx = x + dx[dir];//在dir方向走一步
                    int ny = y + dy[dir];
                    // 如果obs.contains(...)，是障碍物
                    if (obs.contains(calcHash(new int[]{nx, ny}))) break;
                    x = nx; y = ny;
                    //在指令开始或终止时，是最远位置
                    ans = Math.max(ans, x * x + y * y);
                }
            }
        }
        return ans;
    }

    /*string calcHash(const vector<int>& obstacle) {
        return to_string(obstacle[0]) + "," + to_string(obstacle[1]);
    }*/
    //行号 * 行数 + 列号 10行10列，2，3格子变一维就是 2 * 10 + 3 = 23,
    // 题目里x,y是-3万到3万，就是60001列
    //+30000是为了防负数，从-30000,30000平移到0,60000
    //int上限20e，这么乘是36e,要开long
    //两个int像乘,里面一个int需要转成long，（即使返回long,这里运算还是int来算的!)
    long calcHash(int[] obstacle) {
        return (obstacle[0] + 30000) * 60001l + (obstacle[1] + 30000);
    }
}
