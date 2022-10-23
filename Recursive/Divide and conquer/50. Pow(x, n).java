class Solution {
    // 分治解法, 分成n /2 两个子问题
    //x^n-1 * x
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == -(1l << 31)) return 1.0 / (myPow(x, -(n + 1)) * x); //+1变成-2的31次方 + 1，-了就变成2^31 -1， 再乘x 就是2的31次方
        //如果n当前是-2^31，那-n就是2的31次方，比int上限2的31次方 - 1 大了1
        if (n < 0) return 1.0 / myPow(x, -n);//x的-k次方，等于x的k分之一次方，除以变成正数
        double temp = myPow(x, n / 2);//算x的n/2次方，将其整个平方就是x的n次方,
        double ans = temp * temp;
        if (n % 2 == 1) ans *= x; //奇数n/2除不尽，多乘一个n,让n/2向下取整（奇就是先平方，再乘一个x）
        return ans;
    }
}
